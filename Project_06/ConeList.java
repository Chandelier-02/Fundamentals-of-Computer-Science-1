import java.util.ArrayList;
import java.text.DecimalFormat;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

/**
Creates a list of cones and then finds amount of their
values added together as well as averages and then. 
provides a summary
* @author Chandler Dykes
* @version 02/19/2021
Project 05 ConeList
*/
public class ConeList
{
   private String listName;
   private ArrayList<Cone> myCones = new ArrayList<Cone>();
   
   //Constructor
   /**
   Takes in two parameters.
   @param listNameIn name of list user inputs
   @param coneIn array of cones user inputs
   */
   public ConeList(String listNameIn, ArrayList<Cone> coneIn)
   {
      listName = listNameIn;
      myCones = coneIn;
   }
   
   //Methods
   
   /**
   Returns list name.
   @return listName returns the name of the list
   */
   public String getName()
   {
      return listName;
   }
   
   /**
   Returns amount of cones in list.
   @return myCones.size() returns # of cones in list
   */
   public int numberOfCones()
   {
      if (!myCones.isEmpty())
      {
         return myCones.size();
      }
      else
      {
         return 0;
      }
   }
   
   /**
   Returns the total base perimeter.
   @return perim returns total perimeter of all cones
   */
   public double totalBasePerimeter()
   {
      double perim = 0;
      if (!myCones.isEmpty())
      {
         int i = 0;
         while (i < myCones.size())
         {
            Cone c = myCones.get(i);
            perim += c.basePerimeter(); 
            i++;
         }
      }
      else
      {
         return 0;
      }
      return perim;
   }
   
   /**
   Returns the total base area.
   @return area returns total base area of cones
   */
   public double totalBaseArea()
   {
      double area = 0;
      if (!myCones.isEmpty())
      {
         int i = 0;
         while (i < myCones.size())
         {
            Cone c = myCones.get(i);
            area += c.baseArea(); 
            i++;
         }
      }
      else
      {
         return 0;
      }
      return area;
   }
   
   /**
   Returns the total slant height.
   @return height returns total slant height for all cones
   */
   public double totalSlantHeight()
   {
      double height = 0;
      if (!myCones.isEmpty())
      {
         int i = 0;
         while (i < myCones.size())
         {
            Cone c = myCones.get(i);
            height += c.slantHeight(); 
            i++;
         }
      }
      else
      {
         return 0;
      }
      return height;
   }

   /**
   Returns the total side area.
   @return sideArea returns total side area of all cones
   */
   public double totalSideArea()
   {
      double sideArea = 0;
      if (!myCones.isEmpty())
      {
         int i = 0;
         while (i < myCones.size())
         {
            Cone c = myCones.get(i);
            sideArea += c.sideArea(); 
            i++;
         }
      }
      else
      {
         return 0;
      }
      return sideArea;
   }

   /**
   Returns the total surface area.
   @return surfaceArea returns total surface are for all cones
   */
   public double totalSurfaceArea()
   {
      double surfaceArea = 0;
      if (!myCones.isEmpty())
      {
         int i = 0;
         while (i < myCones.size())
         {
            Cone c = myCones.get(i);
            surfaceArea += c.surfaceArea(); 
            i++;
         }
      }
      else
      {
         return 0;
      }
      return surfaceArea;
   }

   /**
   Returns total volume.
   @return volume returns total volume for all cones
   */
   public double totalVolume()
   {
      double volume = 0;
      if (!myCones.isEmpty())
      {
         int i = 0;
         while (i < myCones.size())
         {
            Cone c = myCones.get(i);
            volume += c.volume();  
            i++;
         }
      }
      else
      {
         return 0;
      }
      return volume;
   }

   /**
   Returns average surface area.
   @return totalSurfaceArea() / myCones.size() returns 
   average surface area of cones
   */
   public double averageSurfaceArea()
   {
      if (!myCones.isEmpty())
      {
         return totalSurfaceArea() / myCones.size();
      }
      else
      {
         return 0;
      }
   }

   /**
   Returns average volume.
   @return totalVolume() / myCones.size() returns 
   average volume of cones
   */
   public double averageVolume()
   {
      if (!myCones.isEmpty())
      {
         return totalVolume() / myCones.size();
      }
      else 
      {
         return 0;
      }
   }
   
   /**
   Turns the output into a string.
   @return output returns values as a string
   */
   public String toString()
   {
      int i = 0;
      String output = "";
      output += (listName + "\n");
      while (i < myCones.size())
      {
         output += ("\n" + myCones.get(i).toString() + "\n");
         i++;
      }
      return output;
   }
   
   /**
   Returns the list of cones.
   @return returns the list of cones
   */
   public ArrayList<Cone> getList()
   {
      return myCones;
   }
   
   /**
   Reads in data from a file, parses it, and then creates
   new cones which are then added to a list which is then
   added to a created ConeList object.
   @param fileNameIn user inputted file name
   @throws IOException if no file is found
   @return returns the newly created ConeList object
   */
   public ConeList readFile(String fileNameIn) throws IOException
   {
      String fileName = fileNameIn;
      Scanner fileScan = new Scanner(new File(fileName));
      listName = fileScan.nextLine();
      while (fileScan.hasNext())
      {
         String coneLabel = fileScan.nextLine();
         double side = Double.parseDouble(fileScan.nextLine());
         double height = Double.parseDouble(fileScan.nextLine());
         Cone c = new Cone(coneLabel, side, height);
         myCones.add(c);
      }
      fileScan.close();
      ConeList myConeList = new ConeList(listName, myCones);
      return myConeList;
   }
   
   /**
   Method used for adding a cone to the ConeList object.
   @param labelIn user inputted label
   @param heightIn user inputted height
   @param radiusIn user inputted radius
   */
   public void addCone(String labelIn, double heightIn, double radiusIn)
   {
      Cone c = new Cone(labelIn, heightIn, radiusIn);
      myCones.add(c);
      ConeList myConeList = new ConeList(labelIn, myCones);
   }
   
   /**
   Finds a particular cone in the list of cones.
   @param labelIn user inputted label
   @return foundCone is the cone we found if it was in the list
   */
   public Cone findCone(String labelIn)
   {
      Cone foundCone = null; 
      int index = -1;
      for (Cone c : myCones)
      {
         if (c.getLabel().equalsIgnoreCase(labelIn))
         {
            index = myCones.indexOf(c);
         }
      }
      if (index >= 0)
      {
         foundCone = myCones.get(index);
      }
      return foundCone;
   }
   
   /**
   Finds a cone in the list of cones and removes it.
   @param labelIn user inputted label
   @return deletedCone is the cone that was deleted
   */
   public Cone deleteCone(String labelIn)
   {
      int index = -1;
      Cone deletedCone = null;
      for (Cone c : myCones)
      {
         if (c.getLabel().equalsIgnoreCase(labelIn))
         {
            index = myCones.indexOf(c);
         }
      }
      if (index >= 0)
      {
         deletedCone = myCones.get(index);
         myCones.remove(index);
      }
      return deletedCone;
   }
   
   /**
   This is a boolean that allows the user to find a cone and edit it if it 
   exists. 
   @param labelIn user inputted label
   @param heightIn user inputted height
   @param radiusIn user inputted radius
   @return isFound if the cone that is being edited is found in the list
   */
   public boolean editCone(String labelIn, double heightIn, double radiusIn)
   {
      int index = -1;
      boolean isFound = false;
      for (Cone c : myCones)
      {
         if (c.getLabel().equalsIgnoreCase(labelIn))
         {  
            index = myCones.indexOf(c);
            myCones.get(index).setHeight(heightIn);
            myCones.get(index).setRadius(radiusIn);
            isFound = true;
         }
         else
         {
            isFound = false;
         }
      }
      return isFound;
   }
   
   /**
   Provides a basic summary of the cones.
   @return output returns the string summary
   */
   public String summaryInfo()
   {
      DecimalFormat dcv = new DecimalFormat("#,##0.0##");
      String output;
      output = "----- Summary for " + listName
         + " -----";
      output += "\nNumber of Cones: " + dcv.format(myCones.size());
      output += "\nTotal Base Perimeter: " + dcv.format(totalBasePerimeter());
      output += "\nTotal Base Area: " + dcv.format(totalBaseArea());
      output += "\nTotal Slant Height: " + dcv.format(totalSlantHeight());
      output += "\nTotal Side Area: " + dcv.format(totalSideArea());
      output += "\nTotal Surface Area: " + dcv.format(totalSurfaceArea());
      output += "\nTotal Volume: " + dcv.format(totalVolume());
      output += "\nAverage Surface Area: " + dcv.format(averageSurfaceArea());
      output += "\nAverage Volume: " + dcv.format(averageVolume());
      return output;
   }
}