import java.text.DecimalFormat;

/**
This class stores the name of the list and array of tetrahedron
objects and then has methods to determine total volume and SA,
as well as avg volume and SA as well as means to add, delete, find, and edit
the tetrahedron list. 
@author Chandler Dykes
@version 03/26/2021
*/
public class TetrahedronList
{
   private String name = "";
   private Tetrahedron[] tetraList;
   private int numOfTetra;
   
   /**
   Constructor for the Tetrahedron list.
   @param nameIn name input
   @param tetraListIn list input
   @param numOfTetraIn number input
   */
   public TetrahedronList(String nameIn, Tetrahedron[] tetraListIn, 
      int numOfTetraIn)
   {
      name = nameIn;
      tetraList = tetraListIn;
      numOfTetra = numOfTetraIn;
   }
   
   /**
   Gets the name of the list.
   @return the name of the list
   */
   public String getName()
   {
      return name;
   }
   
   /**
   Finds the number of tetrahedrons in the list.
   @return number of tetrahedrons
   */
   public int numberOfTetrahedrons()
   {
      if (tetraList.length > 0)
      {
         return numOfTetra;
      }
      else
      {
         return 0;
      }
   }
   
   /**
   Finds the total surface area of all tetras in the list.
   @return the total surface area
   */
   public double totalSurfaceArea()
   {
      double surfaceArea = 0;
      for (int i = 0; i < tetraList.length; i++)
      {
         if (tetraList[i] != null)
         {
            surfaceArea += tetraList[i].surfaceArea();
         }
      }
      return surfaceArea;
   }
   
   /**
   Finds the total volume of all tetras in the list.
   @return the total volume
   */
   public double totalVolume()
   {
      double volume = 0;
      for (int i = 0; i < tetraList.length; i++)
      {
         if (tetraList[i] != null)
         {
            volume += tetraList[i].volume();
         }
      }
      return volume;
   }

   /**
   Finds the averge surface area across all tetras in the list.
   @return avergae surface area
   */
   public double averageSurfaceArea()
   {
      return (double) totalSurfaceArea() / numOfTetra;
   }
   
   /**
   Finds the averge surface area across all tetras in the list.
   @return average volume
   */
   public double averageVolume()
   {
      return (double) totalVolume() / numOfTetra;
   }
   
   /**
   Creates a string representation of the tetrahedron list object.
   @return output returns the formatted reprsentation
   */
   public String toString()
   {
      DecimalFormat dcm = new DecimalFormat("#,##0.0##");
      String output = "";
      output += "----- Summary for " + this.getName() 
         + " -----";
      output += "\nNumber of Tetrahedrons: " + numOfTetra;
      output += "\nTotal Surface Area: " + dcm.format(totalSurfaceArea())
         + " square units";
      output += "\nTotal Volume: " + dcm.format(totalVolume())
         + " cubic units";
      output += "\nAverage Surface Area: " + dcm.format(averageSurfaceArea())
         + " square units";
      output += "\nAverage Volume: " + dcm.format(averageVolume())
         + " cubic units";
      return output;
   }
   
   /**
   Gets the array of tetrahedrons.
   @return list of tetrahedrons
   */
   public Tetrahedron[] getList()
   {
      return tetraList;
   }
   
   /**
   Adds a tetrahedron to the list.
   @param labelIn label input
   @param edgeIn edge input
   */
   public void addTetrahedron(String labelIn, double edgeIn)
   {
      Tetrahedron th = new Tetrahedron(labelIn, edgeIn);
      Tetrahedron[] newList = new Tetrahedron[(tetraList.length + 1)];
      
      for (int i = 0; i < this.numberOfTetrahedrons(); i++)
      {
         newList[i] = tetraList[i];
      }
      newList[numOfTetra] = th;
      numOfTetra++;
      tetraList = newList;
   }
   
   /**
   Finds a tetrahedron given its name.
   @param labelIn name of tetrahedron
   @return foundTetra tetrahedron found
   */
   public Tetrahedron findTetrahedron(String labelIn)
   {
      Tetrahedron foundTetra = null;
      for (int i = 0; i < numOfTetra; i++)
      {
         if (labelIn.equalsIgnoreCase(tetraList[i].getLabel()))
         {
            foundTetra = tetraList[i];
         }
      }
      return foundTetra;
   }
   
   /**
   Deletes a tetrahedron from the list.
   @param labelIn name of tetra to delete
   @return deletedTetra tetra deleted
   */
   public Tetrahedron deleteTetrahedron(String labelIn)
   {
      for (int i = 0; i < numOfTetra; i++)
      {
         if (labelIn.equalsIgnoreCase(tetraList[i].getLabel()))
         {
            Tetrahedron deletedTetra = findTetrahedron(labelIn);
         
            for (int j = i; j < numOfTetra - 1; j++)
            {
               tetraList[j] = tetraList[j + 1];
            }
            tetraList[numOfTetra - 1] = null;
            numOfTetra--;
            return deletedTetra;
         }
      }
      return null;
   }
   
   /**
   Edits a tetrahedron in the list.
   @param labelIn name of tetra
   @param edgeIn new edge length 
   @return edited tetrahedron
   */
   public boolean editTetrahedron(String labelIn, double edgeIn)
   {
      boolean edited = false;
      for (int i = 0; i < numOfTetra; i++)
      {
         if (tetraList[i].getLabel() == labelIn)
         {
            tetraList[i].setEdge(edgeIn);
            edited = true;
         }
      }
      return edited;
   }
   
   /**
   Finds the tetrahedron with the largest volume in the list.
   @return largestTetra largest tetrahedron
   */
   public Tetrahedron findTetrahedronWithLargestVolume()
   {
      double largest = 0;
      Tetrahedron largestTetra = null;
      if (numOfTetra > 0)
      {
         largest = tetraList[0].volume();
      }
      
      for (int i = 0; i < numOfTetra; i++)
      {
         if (!(largest > tetraList[i].volume()))
         {
            largest = tetraList[i].volume();
            largestTetra = tetraList[i];
         }
      }
      return largestTetra;
   }
}