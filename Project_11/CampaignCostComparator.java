import java.util.Comparator;

/**
Provides an alternate way to compare campaigns and sort them
based on their cost.
@author Chandler Dykes
@version 04/09/2021
*/
public class CampaignCostComparator implements Comparator<MarketingCampaign>
{
   /**
   Compares the campaigns and returns a int value.
   @param c1 marketing campaign 1
   @param c2 marketing campaign 2
   @return -1 if less, 1 if greater, 0 if equal.
   */
   public int compare(MarketingCampaign c1, MarketingCampaign c2)
   {
      if (c1.campaignCost() < c2.campaignCost())
      {
         return -1;
      }
      else if (c1.campaignCost() > c2.campaignCost())
      {
         return 1;
      }
      else
      {
         return 0;
      }
   }
}