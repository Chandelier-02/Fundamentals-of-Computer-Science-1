/**
Represents an Online Article in a store.
@author Chandler Dykes
@version 03/30/2021
*/

public class OnlineArticle extends OnlineTextItem
{
   private int wordCount;
   
   /**
   Constructor for OnlineArticle.
   @param nameIn item name
   @param priceIn item price
   */
   public OnlineArticle(String nameIn, double priceIn)
   {
      super(nameIn, priceIn);
      wordCount = 0;
   }
   
   /**
   Sets the word count of the article.
   @param wordCountIn number of words
   */
   public void setWordCount(int wordCountIn)
   {
      wordCount = wordCountIn;
   }
}