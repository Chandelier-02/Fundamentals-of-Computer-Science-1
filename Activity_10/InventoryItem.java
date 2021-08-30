/**
Represents an inventory item in a store.
@author Chandler Dykes
@version 03/30/2021
*/
public class InventoryItem
{
   protected String name;
   protected double price;
   private static double taxRate = 0;
   
   /**
   Constructor for InventoryItem.
   @param nameIn name input
   @param priceIn price input
   */
   public InventoryItem(String nameIn, double priceIn)
   {
      name = nameIn;
      price = priceIn;
   }
   
   /**
   Gets the name of the item.
   @return name of item
   */
   public String getName()
   {
      return name;
   }
   
   /**
   Calculates the total cost of the item.
   @return cost of the item
   */
   public double calculateCost()
   {
      return price * (1 + taxRate);
   }
   
   /**
   Sets the tax rate.
   @param taxRateIn item's tax rate
   */
   public static void setTaxRate(double taxRateIn)
   {
      taxRate = taxRateIn;
   }
   
   /**
   Converts the item into a string.
   @return string output
   */
   public String toString()
   {
      return name + ": $" + calculateCost();
   }
}