import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
Parses a file to extract name, height, and radius of 
a cone and then creates a ConeList and invokes its methods 
which invokes the cone's methods.
* @author Chandler Dykes
* @version 02/19/2021
Project 05 ConeListApp
*/
public class ConeListApp
{
   /**
   Scans a file, parses its data, creates a new cone, adds it to 
   a list, creates a new list, invokes the methods of ConeList.
   * @param args Command Line arguments - not used
   * @throws IOException throws exception if no file is found
   */
   public static void main(String[] args) throws IOException
   {
      ArrayList<Cone> coneList = new ArrayList<Cone>();
      System.out.print("Enter file name: ");
      Scanner in = new Scanner(System.in);
      String fileName = in.next();
      Scanner fileScan = new Scanner(new File(fileName));
      
      String listName = fileScan.nextLine();
      while (fileScan.hasNext())
      {
         String coneLabel = fileScan.nextLine();
         double side = Double.parseDouble(fileScan.nextLine());
         double height = Double.parseDouble(fileScan.nextLine());
         Cone c = new Cone(coneLabel, side, height);
         coneList.add(c);
      }
      fileScan.close();
      ConeList myConeList = new ConeList(listName, coneList);
      System.out.println("\n" + myConeList);
      System.out.println("\n" + myConeList.summaryInfo());
   }
}