/**
This activity will test out properties of Arrays
through a scores class and its methods.
@author Chandler Dykes
@version 03/23/2021
Activity 08
*/

public class Scores
{
   private int[] numbers;
   
   /**
   Sets the array of numbers based on input.
   @param numbersIn numbers inputted
   */
   public Scores(int[] numbersIn)
   {
      numbers = numbersIn;
   }
   
   /**
   Selects the even numbers in the array.
   @return evens even numbers in the array
   */
   public int[] findEvens()
   {
      int numberEvens = 0;
      
      for (int i = 0; i < numbers.length; i++)
      {
         if (numbers[i] % 2 == 0)
         {
            numberEvens++;
         }
      }
      
      int[] evens = new int[numberEvens];
      
      int count = 0;
      
      for (int i = 0; i < numbers.length; i++)
      {
         if (numbers[i] % 2 == 0)
         {
            evens[count] = numbers[i];
            count++;
         }
      }
      
      return evens;
   }
   
   /**
   Finds the odd numbers in the array.
   @return odds odd numbers in the array
   */
   public int[] findOdds()
   {
      int numberOdds = 0;
      
      for (int i = 0; i < numbers.length; i++)
      {
         if (numbers[i] % 2 == 1)
         {
            numberOdds++;
         }
      }
      
      int[] odds = new int[numberOdds];
      
      int count = 0;
      
      for (int i = 0; i < numbers.length; i++)
      {
         if (numbers[i] % 2 == 1)
         {
            odds[count] = numbers[i];
            count++;
         }
      }
      
      return odds;
   }
   
   /**
   Calculates the average of the numbers in the array.
   @return returns the average
   */
   public double calculateAverage()
   {
      int sum = 0;
      
      for (int i = 0; i < numbers.length; i++)
      {
         sum += numbers[i];
      }
      
      return (double) sum / (double) numbers.length;
   }
   
   /**
   Returns the array as a string value.
   @return result numbers in the array
   */
   public String toString()
   {
      String result = "";
      
      for (int i = 0; i < numbers.length; i++)
      {
         result += numbers[i] + "\t";
      }
      
      return result;
   }
   
   /**
   Returns the array backwards as a string value.
   @return result numbers in the array printed backwards
   */
   public String toStringInReverse()
   {
      String result = "";
      
      for (int i = numbers.length - 1; i >= 0; i--)
      {
         result += numbers[i] + "\t";
      }
      
      return result;
   }
}