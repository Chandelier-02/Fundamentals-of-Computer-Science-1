import java.util.Scanner;
/**
This program will allow the user to input the 
amount of petroleum in ounces, and will then display
the number in barrels, gallons, quarts, and ounces
from largest to smallest.
* Project 2 PetroleumUnits
* @author Chandler Dykes
* @version 01/29/2021
*/

public class PetroleumUnits
{
   /**
   Asks the user the input the amount of 
   petroleum (less than 1 billion) in oz
   and then outputs the amount in barrels,
   gallons, quarts, and ounces.
   * @param args Command line arguments (not used)
   */
   public static void main(String[] args)
   {
      int petroleumInOunces = 0;
      final int maxAmount = 1000000000;
      int barrel = 0, gallon = 0, quart = 0, ounce = 0;
      int remainder = 0;
      
      //Gets the user input in ounces
      Scanner userInput = new Scanner(System.in);
      System.out.print("Enter amount of petroleum in ounces: ");
      petroleumInOunces = userInput.nextInt();
      
      //Sees how many barrels are left 
      //and how much oz are left
      barrel = petroleumInOunces / 5376;
      remainder = petroleumInOunces % 5376;
      
      //Sees how many gallons can be made from
      //the remainder of the barrel division
      gallon = remainder / 128;
      remainder = remainder % 128;
      
     //Sees how many quarts can be made from
     //the remainder of the gallon divison
      quart = remainder / 32;
      remainder = remainder % 32;
      
      //Calculates the remaining oz
      ounce = petroleumInOunces - (barrel * 5376)
                                - (gallon * 128)
                                - (quart * 32);
                       
      
      //Makes sure the user didn't input a number
      //too big. If not, it prints the values
      if (petroleumInOunces > maxAmount)
      {
         System.out.println("Amount must not exceed 1,000,000,000.");
      }
      else
      {
         System.out.println("Petroleum amount in units: ");
         System.out.println("\tBarrels: " + barrel);
         System.out.println("\tGallons: " + gallon);
         System.out.println("\tQuarts: " + quart);
         System.out.println("\tOunces: " + ounce);
         System.out.println(petroleumInOunces + " oz =" + " (" + barrel  
            + " bl * 5376 oz) + (" + gallon 
            + " gal * 128 oz) + (" + quart 
            + " qt * 32 oz) + (" + ounce + " oz)");
      }
      
   }
}