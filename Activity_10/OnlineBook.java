/**
Represents an Online Book in a store.
@author Chandler Dykes
@version 03/30/2021
*/

public class OnlineBook extends OnlineTextItem
{
   protected String author;
   
   /**
   Constructor for the OnlineBook object.
   @param nameIn book name
   @param priceIn book price
   */
   public OnlineBook(String nameIn, double priceIn)
   {
      super(nameIn, priceIn);
      author = "Author Not Listed";
   }
   
   /**
   Converts the object into a string format.
   @return a string book object
   */
   public String toString()
   {
      return name + " - " + author + ": $" + price;
   }
   
   /**
   Sets the book's author name.
   @param authorIn book's author
   */
   public void setAuthor(String authorIn)
   {
      author = authorIn;
   }
}