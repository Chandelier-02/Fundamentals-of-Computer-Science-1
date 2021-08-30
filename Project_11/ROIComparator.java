import java.util.Comparator;

/**
Provides an alternate way to compare campaigns and sort them
based on their ROI from greatest to least.
@author Chandler Dykes
@version 04/09/2021
*/

public class ROIComparator implements Comparator<MarketingCampaign>
{
   /**
   Compares the campaigns and returns a int value.
   @param c1 marketing campaign 1
   @param c2 marketing campaign 2
   @return -1 if greater, 1 if less, 0 if equal.
   */
   public int compare(MarketingCampaign c1, MarketingCampaign c2)
   {
      if (c1.calcROI() < c2.calcROI())
      {
         return 1;
      }
      else if (c1.calcROI() > c2.calcROI())
      {
         return -1;
      }
      else
      {
         return 0;
      }
   }

}