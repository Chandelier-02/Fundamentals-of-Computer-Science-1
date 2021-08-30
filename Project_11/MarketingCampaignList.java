import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.io.File;

/**
Creates a list of marketing campaigns and contains methods
to add objects to that list as well as create a list from a file.
@author Chandler Dykes
@version 04/09/2021
*/
public class MarketingCampaignList
{
   private MarketingCampaign[] campaigns;
   private String[] invalids;
   
   /**Constructor for the MarketingCampaignList.*/
   public MarketingCampaignList()
   {
      campaigns = new MarketingCampaign[0];
      invalids = new String[0];
   }
   /**
   Gets the marketing campaign array.
   @return marketing campaign array
   */
   public MarketingCampaign[] getMarketingCampaignArray()
   {
      return campaigns;
   }
   /**
   Gets the invalid records array.
   @return invalid records array
   */
   public String[] getInvalidRecordsArray()
   {
      return invalids;
   }
   /**
   Adds a marketing campaign to the array.
   @param newCampaign new marketing campaign
   */
   public void addMarketingCampaign(MarketingCampaign newCampaign)
   {
      campaigns = Arrays.copyOf(campaigns, campaigns.length + 1);
      campaigns[campaigns.length - 1] = newCampaign;
   }
   /**
   Adds a invalid record to the array of invalid records.
   @param newInvalid new invalid record
   */
   public void addInvalidRecord(String newInvalid)
   {
      invalids = Arrays.copyOf(invalids, invalids.length + 1);
      invalids[invalids.length - 1] = newInvalid;
   }
   /**
   Reads a file and extracts its data and creates a Marketing 
   Campaign object to add to the list.
   @param fileNameIn name of file
   @throws FileNotFoundException for file not found
   */
   public void readFile(String fileNameIn) throws FileNotFoundException
   {
      String campaignInfo;
      Scanner fileScan, valueScan;
      int lineNumber = 0;
      
      fileScan = new Scanner(new File(fileNameIn));
      
      do
      {
         campaignInfo = fileScan.nextLine();
         valueScan = new Scanner(campaignInfo);
         valueScan.useDelimiter(",");
         lineNumber++;
            
         while (valueScan.hasNext())
         {
            char typeOfCampaign = valueScan.next().charAt(0);
            String name;
            double revenue, costPerMailPiece, numberOfMailPieces, costPerAd,
                     numberOfAds;
               
            try 
            {
               switch (typeOfCampaign)
               {
                  case 'D':
                     name = valueScan.next();
                     revenue = Double.parseDouble(valueScan.next());
                     costPerMailPiece = Double.parseDouble(valueScan.next());
                     numberOfMailPieces = Integer.parseInt(valueScan.next());
                     addMarketingCampaign(new DirectMC(name, revenue,
                              costPerMailPiece, (int) numberOfMailPieces));
                     break;
                  case 'I':
                     name = valueScan.next();
                     revenue = Double.parseDouble(valueScan.next());
                     costPerAd = Double.parseDouble(valueScan.next());
                     numberOfAds = Integer.parseInt(valueScan.next());
                     addMarketingCampaign(new IndirectMC(name, revenue,
                              costPerAd, (int) numberOfAds));
                     break;
                  case 'S':
                     name = valueScan.next();
                     revenue = Double.parseDouble(valueScan.next());
                     costPerAd = Double.parseDouble(valueScan.next());
                     numberOfAds = Integer.parseInt(valueScan.next());
                     addMarketingCampaign(new SearchEngineMC(name, revenue,
                              costPerAd, (int) numberOfAds));
                     break;
                  case 'M':
                     name = valueScan.next();
                     revenue = Double.parseDouble(valueScan.next());
                     costPerAd = Double.parseDouble(valueScan.next());
                     numberOfAds = Integer.parseInt(valueScan.next());
                     addMarketingCampaign(new SocialMediaMC(name, revenue,
                              costPerAd, (int) numberOfAds));
                     break;
                  default:
                     InvalidCategoryException e = 
                        new InvalidCategoryException(
                           String.valueOf(campaignInfo.charAt(0)));
                     
                     addInvalidRecord(campaignInfo + "\n" + e.toString());
                     break;
               }
               break;
            }
            catch (NumberFormatException e)
            {
               addInvalidRecord(campaignInfo + "\n" + e.toString());
               break;
            }
            catch (NoSuchElementException e)
            {
               e = new NoSuchElementException("For missing input data");
               addInvalidRecord(campaignInfo + "\n" + e.toString());
               break;
            }
           
         }
      } while (fileScan.hasNext());
      fileScan.close();
   }

   /**
   Generates a list of invalid records and concats them.
   @return invalid records list as a string
   */
   public String generateInvalidRecordsReport()
   {
      String output = "----------------------";
      output += "\nInvalid Records Report";
      output += "\n----------------------"; 
      output += "\n"; 
      for (String invalid : getInvalidRecordsArray())
      {
         output += "\n" + invalid + "\n";
      }
      return output;
   }

   /**
   Generates the report based on its original order.
   @return report
   */
   public String generateReport()
   {
      String output = "-------------------------------";
      output += "\nMarketing Campaign Report";
      output += "\n-------------------------------";
      output += "\n";
      for (MarketingCampaign campaign: getMarketingCampaignArray())
      {
         output += "\n" + campaign + "\n";
      }
      return output;
   }
   /**
   Generates the report based on its name order.
   @return report
   */
   public String generateReportByName()
   {
      Arrays.sort(getMarketingCampaignArray());
      String output = "M-----------------------------------------";
      output += "\nMarketing Campaign Report (by Name)";
      output += "\nM-----------------------------------------";
      output += "\n";
      for (MarketingCampaign campaign: getMarketingCampaignArray())
      {
         output += "\n" + campaign + "\n";
      }
      return output;
   }
   /**
   Generates the report based on its lowest campaign cost order.
   @return report
   */
   public String generateReportByCampaignCost()
   {
      Arrays.sort(getMarketingCampaignArray(), new CampaignCostComparator());
      String output = "-------------------------------------------------";
      output += "\nMarketing Campaign Report (by Lowest Campaign Cost)";
      output += "\n-------------------------------------------------";
      output += "\n";
      for (MarketingCampaign campaign: getMarketingCampaignArray())
      {
         output += "\n" + campaign + "\n";
      }
      return output;
   }
   /**
   Generates the report based on its highest ROI order.
   @return report
   */
   public String generateReportByROI()
   {
      Arrays.sort(getMarketingCampaignArray(), new ROIComparator());
      String output = "-------------------------------------------------";
      output += "\nMarketing Campaign Report (by Highest ROI)";
      output += "\n-------------------------------------------------";
      output += "\n";
      for (MarketingCampaign campaign: getMarketingCampaignArray())
      {
         output += "\n" + campaign + "\n";
      }
      return output;
   }

}