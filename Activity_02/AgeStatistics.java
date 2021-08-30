import java.util.Scanner;

/**
* This program will display someone’s name, age, 
and gender, along
with calculations for age in minutes and 
centuries well as max heart rate based on age and gender. 
* Activity 2
* @author Chandler Dykes
* @version 1/26/2021
*/

public class AgeStatistics
{
   /**
   * Prompts the user for name, age, and gender.
   * Outputs their age in minutes and centures.
   * Gives the user their max heart rate.
   @param args Command line arguments (not used).
   */
   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      String name = "";
      int ageInYears = 0;
      int gender = 0;
      double maxHeartRate = 0;
      
      //Prompt the user for their name
      System.out.print("Enter your name: ");
      name = userInput.nextLine();
      
      //Prompt the user for their age
      System.out.print("Enter your age in years: ");
      ageInYears = userInput.nextInt();
      
      //Prompt the user for their gender
      System.out.print("Enter your gender (1 for "
         + "female and 0 for male): ");
      gender = userInput.nextInt();
      
      //convert age
      System.out.println("\tYour age in minutes is "
         + ageInYears * 525600 + " minutes.");
      System.out.println("\tYour age in centuries is "
         + (double) ageInYears / 100 + " centuries.");
         
      // display max heart-rate
      System.out.print("Your max heart rate is ");
      
      if (gender == 1) //calculate female HR
      {
         maxHeartRate = 209 - (0.7 * ageInYears);
      }
      else //calculate male HR
      {
         maxHeartRate = 214 - (0.8 * ageInYears);
      }
      
      // print the max heart rate
      System.out.println(maxHeartRate + " beats per minute.");
   }
}
