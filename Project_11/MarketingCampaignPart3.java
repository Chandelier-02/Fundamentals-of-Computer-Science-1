import java.io.FileNotFoundException;

/**
Creates a new marketing campaign list object based on a csv
file and generates its reports.
@author Chandler Dykes
@version 04/16/2021
*/
public class MarketingCampaignPart3
{
   /**
   Creates the campaign list and prints its reports.
   @param args - name of file
   */
   public static void main(String[] args) 
   {
      if (args.length == 0)
      {
         System.out.println("File name expected as command line argument.");
         System.out.println("Program ending.");
         return;
      }
      
      try
      {
         MarketingCampaignListEdited myList = new MarketingCampaignListEdited();
         myList.readFile(args[0]);
         System.out.println(myList.generateReport());
         //System.out.println();
         System.out.println(myList.generateReportByName());
         //System.out.println();
         System.out.println(myList.generateReportByCampaignCost());
         //System.out.println();
         System.out.println(myList.generateReportByROI());
         //System.out.println();
         System.out.println(myList.generateInvalidRecordsReport());
      }
      catch (FileNotFoundException e)
      {
         System.out.println("*** Attempted to read file: " + args[0] 
            + " (No such file or directory)");
      }
   }
}