import java.util.Scanner;
import java.text.DecimalFormat;

/**
* This program will solve the expression 
* (6x^3 + sqrt(3x^2 + 2x + 1)) / (abs(2x) + 4).
* The program allows the user to input a value for x
* and then solves for x.
* Project 3
* @author Chandler Dykes
* @version 02/05/2021
*/

public class SolveIt
{
   /**
   * Takes the user input and solves for x.
   * @param args Command line arguments (not used)
   */
   public static void main(String[] args)
   {
      double result, x, expression, determinant, root, divisor;
      Scanner userInput = new Scanner(System.in);
      System.out.print("Enter a value for x: ");
      x = userInput.nextDouble();
      
      //Finds 6x^3
      expression = 6 * Math.pow(x, 3);
      
      //Finds the root
      root = 3 * Math.pow(x, 2) + (2 * x) + 1;
      
      //Gets the square root
      determinant = Math.sqrt(root);
      
      //Gets the divisor
      divisor = (Math.abs(2 * x) + 4);
      
      //Finds the result
      result = (expression + determinant) / (divisor);
      
      System.out.println("Result: " + result);
      
      //Finds index and length of string
      String numbers = Double.toString(result);
      int index = numbers.indexOf(".");
      int amount = numbers.length();
     
     //Finds amt of #s on left and right of decimal
      int numLeft = index;
      int endIndex = amount - numLeft;
      int numRight = numbers.length() - index - 1;
      
      //Formats the output
      DecimalFormat outPut = new DecimalFormat("#,##0.0##");
      
      //Prints the results
      System.out.println("# of characters to left of decimal point: " 
         + numLeft);
      System.out.println("# of characters to right of decimal point: " 
         + numRight);
      
      System.out.println("Formatted Result: " + outPut.format(result));
   }
}