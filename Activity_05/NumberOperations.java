/**
This class contains an integer value that can then 
me modified using various methods.
* @author Chandler Dykes
* @version 02/17/2021
* Activity 05
*/

public class NumberOperations
{
   private int number;
   
   /**
   Takes in the number the user inputs.
   * @param numberIn - userInput
   */
   public NumberOperations(int numberIn)
   {
      number = numberIn;
   }
   
   /**
   Returns the value of number.
   @return - returns number
   */
   public int getValue()
   {
      return number;
   }
   
   /**
   Finds the odd numbers under the number
   inputted.
   * @return output - returns the odd numbers
   */
   public String oddsUnder()
   {
      String output = "";
      int i = 0;
      while (i < number)
      {
         if (i % 2 != 0)
         {
            output += i + "\t";
         }
         i++;
      }
      return output;
   }
   
   /**
   Finds the powers of two under the number
   inputted.
   * @return output - returns the powers of two
   */
   public String powersTwoUnder()
   {
      String output = "";
      int powers = 1;
      while (powers < number)
      {
         output += powers + "\t";
         powers = powers * 2;
      }
      return output;
   }
   
   /**
   Determines if the vlaue is greater than a number inputted.
   @return - returns 1 if bigger, -1 if smaller, 0 if equal
   @param compareNumber - inputted number to compare number to
   */
   public int isGreater(int compareNumber)
   {
      if (number > compareNumber)
      {
         return 1;
      }
      else if (number < compareNumber)
      {
         return -1;
      }
      else 
      {
         return 0;
      }
   }
   
   /**
   Turns the output into a string.
   @return - returns the number string
   */
   public String toString()
   {
      return number + "";
   }
}