import java.util.ArrayList;
import java.text.DecimalFormat;

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