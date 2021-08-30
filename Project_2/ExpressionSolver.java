import java.util.Scanner;
/**
* This program will find the result of 
* (9x+6.25)(6y-4.5)(3z+2.75) / xyz
* for values of x,y,z the user inputs.
* Project 2 Expression Solver
* @author Chandler Dykes
* @version 01/29/2021
*/


public class ExpressionSolver
{
/**
* Prompts the user to input values for 
* x,y,z and then solves the expression.
* @param args Command line arguments (not used)
*/
   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      double x = 0, y = 0, z = 0;
      double result = 0;
      
      //prints the statement
      System.out.println("result = (9x + 6.25) (6y - 4.5) "
         + "(3z + 2.75) / xyz");
      
      //asks user to input x-value
      System.out.print("\tx = ");
      x = userInput.nextDouble();
      
      //asks user to input y-value
      System.out.print("\ty = ");
      y = userInput.nextDouble();
      
      //asks user to input z-value
      System.out.print("\tz = ");
      z = userInput.nextDouble();
      
      //checks to see if x, y, or z = 0
      /*if true, its prints the statement
      saying its undefined
      * if false, it calculates the result
      and prints it
      */
      if (x * y * z == 0)
      {
         System.out.print("result is \"undefined\"");
      }
      else
      {
         result = (9 * x + 6.25) * (6 * y - 4.5)  
            * (3 * z + 2.75) / (x * y * z);
         System.out.println("result = " + result);
      }
   }
}