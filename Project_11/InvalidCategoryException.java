/**
Creates a new Exception for when the user inputs a 
category that isn't valid.
@author Chandler Dykes
@version 04/16/2021
*/

public class InvalidCategoryException extends Exception
{
   /**
   Constructor for the InvalidCategoryException.
   @param categoryIn - invalid catgeory
   */
   public InvalidCategoryException(String categoryIn)
   {
      super("For category: " + categoryIn);
   }
}