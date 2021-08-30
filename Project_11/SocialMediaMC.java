/**
Represents a type (Social Media) of indirect marketing campagin along with 
the marketing campaign values and methods.
@author Chandler Dykes
@version 04/01/2021
Project 09
*/

public class SocialMediaMC extends IndirectMC
{
   /**Base cost of the campaign.*/
   public static final double BASE_COST = 3000.0;
   
   /**
   Constructor for the marketing campaign. Sets initial values.
   @param nameIn name of campaign
   @param revenueIn revenue campaign generated
   @param costPerAdIn cost per ad
   @param numberOfAdsIn number of ads
   */
   public SocialMediaMC(String nameIn, double revenueIn,
      double costPerAdIn, int numberOfAdsIn)
   {
      super(nameIn, revenueIn, costPerAdIn, numberOfAdsIn);
   }
    
    /**
    Returns the base cost of the campaign.
    @return base cost of campaign
    */    
   public double getBaseCost()
   {
      return BASE_COST;
   }
}