import java.text.DecimalFormat;

/**
Represents a indirect marketing campagin along with 
the marketing campaign values and methods.
@author Chandler Dykes
@version 04/01/2021
Project 09
*/
public class IndirectMC extends MarketingCampaign
{
   protected double costPerAd;
   protected int numberOfAds;
   
   /**Base cost of the campaign.*/
   public static final double BASE_COST = 1500.0;
   
   /**
   Constructor for the marketing campaign. Sets initial values.
   @param nameIn name of campaign
   @param revenueIn revenue campaign generated
   @param costPerAdIn cost per ad
   @param numberOfAdsIn number of ads
   */
   public IndirectMC(String nameIn, double revenueIn, 
      double costPerAdIn, int numberOfAdsIn)
   {
      super(nameIn, revenueIn);
      costPerAd = costPerAdIn;
      numberOfAds = numberOfAdsIn;
   }
    
    /**
    Gets the cost per ad.
    @return cost per ad
    */    
   public double getCostPerAd()
   {
      return costPerAd;
   }
   
    /**
    Sets the cost per ad.
    @param costPerAdIn cost per ad
    */
   public void setCostPerAd(double costPerAdIn)
   {
      costPerAd = costPerAdIn;
   }
   
    /**
    Gets the number of ads.
    @return number of ads
    */
   public int getNumberOfAds()
   {
      return numberOfAds;
   }
   
    /**
    Sets the number of ads.
    @param numberOfAdsIn number of ads
    */
   public void setNumberOfAds(int numberOfAdsIn)
   {
      numberOfAds = numberOfAdsIn;
   }
   
    /**
    Returns the base cost of the campaign.
    @return base cost
    */
   public double getBaseCost()
   {
      return BASE_COST;
   }
    
    /**
    Generates the cost of the campaign.
    @return cost of campaign
    */
   public double campaignCost()
   {
      return getBaseCost() + (costPerAd * numberOfAds);
   }
   
    /**
    Formats the indirectMC output.
    @return output formatted output
    */
   public String toString()
   {
      double adCost = getCostPerAd() * getNumberOfAds();
      DecimalFormat monetary = new DecimalFormat("$#,##0.00");
      String output = "";
      output += super.toString();
      output += "\n   Base Cost: " + monetary.format(this.getBaseCost())
         + "\n   Ad Cost: " + monetary.format(adCost)
         + " = " + monetary.format(getCostPerAd()) + " per ad * " 
         + getNumberOfAds() + " ads";
      return output;
   }
}