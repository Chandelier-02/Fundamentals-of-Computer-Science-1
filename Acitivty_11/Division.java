/**
Provides methods to divide a numerator input by a denominator input
and output the answer as an int or a double.
@author Chandler Dykes
@version 04/13/2021
*/

public class Division
{
   /**
   Divides two ints and return int output.
   @param numeratorIn - numerator
   @param denominatorIn - denominator
   @return int if valid or 0 if not
   */
   public static int intDivide(int numeratorIn, int denominatorIn)
   {
      try
      {
         return (int) numeratorIn / denominatorIn;
      }
      catch (ArithmeticException e)
      {
         return 0;
      }
   }
   
   /**
   Divides two ints and return double output.
   @param numeratorIn - numerator
   @param denominatorIn - denominator
   @return double value if valid 
   @throws IllegalArgumentException if denominator equals 0
   */

   public static double decimalDivide(int numeratorIn, int denominatorIn)
   {
      if (denominatorIn == 0)
      {
         throw new IllegalArgumentException("The denominator "
            + "cannot be zero.");
      }
      
      return (double) numeratorIn / denominatorIn;
   }
}