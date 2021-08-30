/**
Main driver method for creating new inventory items and adding them
to the items list and printing the toString methods.
@author Chandler Dykes
@version 04/06/2021
*/

public clas s InventoryListApp
{
   /**
   Creates items and adds them to a list and then prints the items list object.
   @param args Command Line arguments (not used)
   */
   public static void main(String[] args)
   {
      ItemsList myItems = new ItemsList();
      InventoryItem.setTaxRate(0.05);
      
      myItems.addItem(new ElectronicsItem("laptop", 1234.56, 10.0));
      myItems.addItem(new InventoryItem("motor oil", 9.8));
      myItems.addItem(new OnlineBook("All Things Java", 12.3));
      myItems.addItem(new OnlineArticle("Useful Acronyms", 3.4));
      
      System.out.println(myItems);
      System.out.println("Total: " + myItems.calculateTotal(2.0));
   }
}