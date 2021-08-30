import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

/**
Provides the user with an interface to perform various methods
and view various forms of cone data.
@author Chandler Dykes
@version 02/26/2021
Project 06
*/
public class ConeListMenuApp
{
   /**
   Creates the user interface and defines what the user can do.
   @param args Command Line arguments (not used)
   @throws IOException if file not found
   */
   public static void main(String[] args) throws IOException
   {
      String label = "";
      double height = 0, radius = 0;
      String listName = "*** no list name assigned ***";
      ArrayList<Cone> myCones = new ArrayList<Cone>();
      ConeList myConeList = new ConeList(listName, myCones);
      char letterIn;
      Scanner userInput = new Scanner(System.in);
      System.out.println("Cone List System Menu"
                         + "\nR - Read File and Create Cone List"
                         + "\nP - Print Cone List"
                         + "\nS - Print Summary"
                         + "\nA - Add Cone"
                         + "\nD - Delete Cone"
                         + "\nF - Find Cone"
                         + "\nE - Edit Cone"
                         + "\nQ - Quit");
      do
      {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         letterIn = 'R';
         letterIn = userInput.next().toUpperCase().charAt(0);
          
         switch (letterIn)
         {
            case 'R':
               String fileName = "";
               System.out.print("\tFile name: ");
               fileName = userInput.next();
               myConeList = myConeList.readFile(fileName);
               System.out.println("\tFile read in and Cone List created" 
                  + "\n");
               break;
            case 'P':
               System.out.println("\n" + myConeList.toString());
               break;
            case 'S':
               System.out.println("\n" + myConeList.summaryInfo() + "\n");
               break;
            case 'A':
               System.out.print("\tLabel: ");
               label = userInput.nextLine();
               userInput.nextLine();
               System.out.print("\tHeight: ");
               height = Double.parseDouble(userInput.next());
               System.out.print("\tRadius: ");
               radius = Double.parseDouble(userInput.next());
               myConeList.addCone(label, height, radius);
               System.out.println("\t*** Cone added ***" + "\n");
               break;
            case 'D':
               System.out.print("\tLabel: ");
               userInput.nextLine();
               label = userInput.nextLine();
               Cone c = myConeList.findCone(label);
               if (myConeList.findCone(label) != null)
               {
                  label = c.getLabel();
                  myConeList.deleteCone(label);
                  System.out.println("\t\"" + label + "\"" + " deleted"
                     + "\n");
               }
               else
               {
                  System.out.println("\t\"" + label + "\"" + " not found"
                     + "\n");
               }
               break;
            case 'F':
               System.out.print("\tLabel: ");
               userInput.nextLine();
               label = userInput.nextLine();
               myConeList.findCone(label);
               if (myConeList.findCone(label) == null)
               {
                  System.out.println("\t\"" + label + "\"" + " not found"
                     + "\n");
               }
               else
               {
                  System.out.println(myConeList.findCone(label).toString() 
                     + "\n");
               }
               break;
            case 'E':
               System.out.print("\tLabel: ");
               userInput.nextLine();
               label = userInput.nextLine();
               System.out.print("\tHeight: ");
               height = userInput.nextDouble();
               System.out.print("\tRadius: ");
               radius = userInput.nextDouble();
               if (myConeList.findCone(label) == null)
               {
                  System.out.println("\t\"" + label + "\"" + " not found" 
                     + "\n");
               }
               else
               {
                  myConeList.editCone(label, height, radius);
                  System.out.println("\t\"" + label + "\"" 
                     + " successfully edited" + "\n");
               }
               break;
            case 'Q':
               break;
            default:
               System.out.println("\t*** invalid code ***" + "\n");
         }
      } while (letterIn != 'Q');
   }
}