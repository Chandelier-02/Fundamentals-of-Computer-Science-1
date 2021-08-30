import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/**
Creates a list of marketing campaigns and contains methods
to add objects to that list as well as create a list from a file.
@author Chandler Dykes
@version 04/09/2021
*/
public class MarketingCampaignListEdited
{
   private MarketingCampaign[] campaigns;
   private String[] invalids;
   
   /**Constructor for the MarketingCampaignList.*/
   public MarketingCampaignListEdited()
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
      Scanner fileScan = new Scanner(new File(fileNameIn));
      Scanner lineScan = null;
     
      String name;
      int count = 0;
      double revenue, costPerMailPiece, numberOfMailPieces, costPerAd, numberOfAds;
      
      ArrayList<ArrayList<String>> allValuesList = new ArrayList<ArrayList<String>>();
     
      while (fileScan.hasNext())
      {
         String campaignInfo = fileScan.nextLine();
         lineScan = new Scanner(campaignInfo);
         lineScan.useDelimiter(",");
         ArrayList<String> valuesInLine = new ArrayList<String>();
         while (lineScan.hasNext())
         {
            String value = lineScan.next();
            valuesInLine.add(value);
         }
         allValuesList.add(valuesInLine);
      }
      
      
      for (int i = 0; i < allValuesList.size(); i++)
      {
         Iterator<String> it = allValuesList.get(i).iterator();
         while (it.hasNext())
         {
            char typeOfCampaign = it.next().charAt(0);
            try
            {
               switch (typeOfCampaign)
               {
                  case 'D':
                     name = it.next();
                     revenue = Double.parseDouble(it.next());
                     costPerMailPiece = Double.parseDouble(it.next());
                     numberOfMailPieces = Integer.parseInt(it.next());
                     addMarketingCampaign(new DirectMC(name, revenue,
                              costPerMailPiece, (int) numberOfMailPieces));
                     break;
                  case 'I':
                     name = it.next();
                     revenue = Double.parseDouble(it.next());
                     costPerAd = Double.parseDouble(it.next());
                     numberOfAds = Integer.parseInt(it.next());
                     addMarketingCampaign(new IndirectMC(name, revenue,
                              costPerAd, (int) numberOfAds));
                     break;
                  case 'S':
                     name = it.next();
                     revenue = Double.parseDouble(it.next());
                     costPerAd = Double.parseDouble(it.next());
                     numberOfAds = Integer.parseInt(it.next());
                     addMarketingCampaign(new SearchEngineMC(name, revenue,
                              costPerAd, (int) numberOfAds));
                     break;
                  case 'M':
                     name = it.next();
                     revenue = Double.parseDouble(it.next());
                     costPerAd = Double.parseDouble(it.next());
                     numberOfAds = Integer.parseInt(it.next());
                     addMarketingCampaign(new SocialMediaMC(name, revenue,
                              costPerAd, (int) numberOfAds));
                     break;
                  default:
                     InvalidCategoryException e = 
                        new InvalidCategoryException(
                           String.valueOf(allValuesList.get(i).toString().charAt(1)));
                     
                     addInvalidRecord(allValuesList.get(i) + "\n" + e.toString());
                     break;
               
               }
               break;
            }
            catch (NumberFormatException e)
            {
               addInvalidRecord(allValuesList.get(i) + "\n" + e.toString());
               break;
            }
            catch (NoSuchElementException e)
            {
               e = new NoSuchElementException("For missing input data");
               addInvalidRecord(allValuesList.get(i) + "\n" + e.toString());
               break;
            }
         
         }
      }
      
      for (int i = 0; i < allValuesList.size(); i++)
      {
         String output = "";
         for (int j = 0; j < allValuesList.get(i).size(); j++)
         {
            output += "\t" + allValuesList.get(i).get(j);
         }
         System.out.println(output);
      }
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
      String output = "-----------------------------------------";
      output += "\nMarketing Campaign Report (by Name)";
      output += "\n-----------------------------------------";
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