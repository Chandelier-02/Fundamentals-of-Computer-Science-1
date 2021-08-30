import java.text.DecimalFormat;

/**
Describes marketing campaign data and provides methods to access the data.
@author Chandler Dykes
@version 04/01/2021
Project 09
*/
public abstract class MarketingCampaign implements Comparable<MarketingCampaign>
{
   protected String name;
   protected double revenue;
   
   protected static int count = 0;
   
   /**
   Constructor for the marketing campaign. Sets initial values.
   @param nameIn name of campaign
   @param revenueIn revenue campaign generated
   */
   public MarketingCampaign(String nameIn, double revenueIn)
   {
      name = nameIn;
      revenue = revenueIn;
      count++;
   }
   
   /**
   Gets the name of the campaign.
   @return name
   */
   public String getName()
   {
      return name;
   }
   
   /**
   Sets the name of the campaign.
   @param nameIn name of campaign
   */
   public void setName(String nameIn)
   {
      name = nameIn;
   }
   
   /**
   Gets the revenue the campaign generated.
   @return revenue
   */
   public double getRevenue()
   {
      return revenue;
   }
   
   /**
   Sets the revenue the campaign generated.
   @param revenueIn revenue campaign generated
   */
   public void setRevenue(double revenueIn)
   {
      revenue = revenueIn;
   }
   
   /**
   Gets the number of marketing campaigns.
   @return number of campaigns
   */
   public static int getCount()
   {
      return count;
   }
   
   /**
   Resets the number of campaigns to 0.
   */
   public static void resetCount()
   {
      count = 0;
   }
   
   /**
   Calculates the ROI of the campaign.
   @return ROI
   */
   public double calcROI()
   {
      return (revenue - campaignCost()) / campaignCost();
   }
   
   /**
   Abstract method allowing one to calculate campaign cost.
   @return cost of campaign
   */
   public abstract double campaignCost();
   
   /**
   Compares two MarketingCampaign objects.
   @param obj marketing campaign to compare to
   @return the result
   */
   public int compareTo(MarketingCampaign obj)
   {
      int result = this.name.toLowerCase().compareTo(obj.name.toLowerCase());
      return result;
   }
   
   /**
   Formats the MarketingCampaign output.
   @return output;
   */
   public String toString()
   {
      DecimalFormat monetary = new DecimalFormat("$#,##0.00");
      DecimalFormat roi = new DecimalFormat("0.##%");
      String output = "";
      output += this.getName() + " (" + this.getClass() + ")";
      output += "\nRevenue: " + monetary.format(revenue)
             + "   Campaign Cost: " + monetary.format(campaignCost())
             + "   ROI: " + roi.format(calcROI());
      return output;
   }
}