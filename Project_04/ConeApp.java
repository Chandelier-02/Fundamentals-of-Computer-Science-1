import java.util.Scanner;

/**
This program allows the user to enter a lable, height, and radius
for a cone. This method then creates a new cone object 
from the Cone class and inputs the values into it. If the values 
are correct, a message describing the cone with be printed.
* @author Chandler Dykes
* @version 02/11/2020
* Project 04 ConeApp
*/

public class ConeApp
{

   /**
   Allows the user to input values, and if they are correct,
   it prints out info about the cone.
   * @param args Command line arguments (not used);
   */

   public static void main(String[] args)
   {
      Scanner myScanner = new Scanner(System.in);
      
      System.out.println("Enter label, height, and radius for a cone.");
      
      //Lets the user input the label and height
      System.out.print("\tlabel: ");
      String label = myScanner.nextLine();
      System.out.print("\theight: ");
      double height = Double.parseDouble(myScanner.nextLine());
      
      //Checks to make sure the height is > 1
      if (height < 1)
      {
         System.out.println("Error: height must be greater than 0.");
         return;
      }
      
      //Lets the user input the radius
      System.out.print("\tradius: ");
      double radius = Double.parseDouble(myScanner.nextLine());
      
      //Checks to make sure the radius is > 1
      if (radius < 1)
      {
         System.out.println("Error: radius must be greater than 0.");
         return;
      }
      
      //Creates a new Cone object and prints its information
      Cone myCone = new Cone(label, height, radius);
      System.out.println(myCone);
   }
}