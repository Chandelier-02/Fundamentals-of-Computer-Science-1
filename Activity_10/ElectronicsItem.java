/**
Represents an Electronic item in a store.
@author Chandler Dykes
@version 03/30/2021
*/

public class ElectronicsItem extends InventoryItem
{
   protected double weight;
   
   /**Shipping cost of the item.*/
   public static final double SHIPPING_COST = 1.5;
   
   /**
   Contructor for the ElectronicsItem.
   @param nameIn item name
   @param priceIn item price
   @param weightIn item weight
   */
   public ElectronicsItem(String nameIn, double priceIn, double weightIn)
   {
      super(nameIn, priceIn);
      weight = weightIn;
   }
   
   /**
   Calculates the cost including shipping.
   @return total cost
   */
   public double calculateCost()
   {
      return super.calculateCost() + (SHIPPING_COST * weight);
   }
}