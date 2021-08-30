/**
Represents an Online Text item in a store.
@author Chandler Dykes
@version 03/30/2021
*/

public abstract class OnlineTextItem extends InventoryItem
{
   /**
   Constructor for the Online Text item.
   @param nameIn item name
   @param priceIn item price
   */
   public OnlineTextItem(String nameIn, double priceIn)
   {
      super(nameIn, priceIn);
   }
   
   /**
   Calculates the cost of the item.
   @return price
   */
   public double calculateCost()
   {
      return price;
   }
}