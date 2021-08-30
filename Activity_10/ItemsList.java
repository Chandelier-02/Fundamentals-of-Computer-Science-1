/**
This class will hold an array of InventoryItems and contains
methods to use the InventoryItems.
@author Chandler Dykes
@version 04/06/2021
*/

public class ItemsList
{
   private InventoryItem[] inventory;
   private int count;
   
   /**
   Constructor for ItemsList.
   */
   public ItemsList()
   {
      inventory = new InventoryItem[20];
      count = 0;
   }
   
   /**
   Adds an item to the list.
   @param itemIn item to add
   */
   public void addItem(InventoryItem itemIn)
   {
      inventory[count] = itemIn;
      count++;
   }
   
   /**
   Calculates the total of all items prices in the list.
   @param electronicsSurcharge added cost for electronics items
   @return total cost
   */
   public double calculateTotal(double electronicsSurcharge)
   {
      double total = 0;
      for (int i = 0; i < count; i++)
      {
         if (inventory[i] instanceof ElectronicsItem)
         {
            total += inventory[i].calculateCost() + electronicsSurcharge;
         }
         else
         {
            total += inventory[i].calculateCost();
         }
      }
      return total;
   }
   
   /**
   Overrides the toString method to print the class
   in a more desirable way.
   @return formatted output
   */
   public String toString()
   {
      String output = "All inventory:\n\n";
      for (int i = 0; i < count; i++)
      {
         output += inventory[i] + "\n";
      }
      return output;
   }
}