import java.text.DecimalFormat;
/**
This class creates a tetrahedron object and uses various methods
to determine its height, surface area, and volume.
@author Chandler Dykes
@version 03/12/2021
Project 07A
*/
public class Tetrahedron implements Comparable<Tetrahedron>
{
   private String label = "";
   private double edge = 0;
   
   private static int count = 0;
   
   /**
   Creats a new tetrahedron and increments count.
   @param labelIn tetrahedron's label input
   @param edgeIn tetrahedron's edge input
   */
   public Tetrahedron(String labelIn, double edgeIn)
   {
      setLabel(labelIn);
      setEdge(edgeIn);
      count++;
   }
   
   /**
   Sets the label.
   @param labelIn user inputted label
   @return if label has been set or not
   */
   public boolean setLabel(String labelIn)
   {
      if (labelIn != null)
      {
         label = labelIn.trim();
         return true;
      }
      return false;
   }
   
   /**
   Gets the label.
   @return the label
   */
   public String getLabel()
   {
      return label;
   }
   
   /**
   Sets the edge length.
   @param edgeIn user inputted edge length
   @return if edge length has been set
   */
   public boolean setEdge(double edgeIn)
   {
      if (edgeIn > -1)
      {
         edge = edgeIn;
         return true;
      }
      return false;
   }
   
   /**
   Gets the edge.
   @return the edge length
   */
   public double getEdge()
   {
      return edge;
   }
   
   /**
   Generates the height of the tetrahedron.
   @return tetraHeight tetrahedron's height
   */
   public double height()
   {
      double tetraHeight = Math.sqrt(2.0 / 3.0) * edge;
      return tetraHeight;
   }
   
   /**
   Generates the surface area of the tetrahedron.
   @return tetraSA tetrahedron's surface area
   */
   public double surfaceArea()
   {
      double tetraSA = Math.sqrt(3) * Math.pow(edge, 2);
      return tetraSA;
   }
   
   /**
   Generates the volume of the tetrahedron.
   @return tetraVolume tetrahedron's volume
   */
   public double volume()
   {
      double tetraVolume = Math.pow(edge, 3) / (6.0 * Math.sqrt(2));
      return tetraVolume;
   }
   
   /**
   Turns the tetrahedron output into a string.
   @return output formatted string output
   */
   public String toString()
   {
      String output = "";
      DecimalFormat dcf = new DecimalFormat("#,##0.0##");
      output += "Tetrahedron" + " \"" + this.label + "\" "
         + "with six edges of length " + dcf.format(this.edge) + " has: "
         + "\n\theight = " + dcf.format(this.height()) + " units"
         + "\n\tsurface area = " + dcf.format(this.surfaceArea()) + " square "
         + "units"
         + "\n\tvolume = " + dcf.format(this.volume()) + " cubic units";
      return output;
   }
   
   /**
   Gets the count of tetrahedrons.
   @return count number of tetrahedrons
   */
   public static int getCount()
   {
      return count;
   }
   
   /**
   Resets the count to 0.
   */
   public static void resetCount()
   {
      count = 0;
   }
   
   /**
   Compares two tetrahedrons to see if they are equal.
   @return the tetrahedron if equal
   @param obj tetrahedron object
   */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Tetrahedron))
      {
         return false;
      }
      else
      {
         Tetrahedron d = (Tetrahedron) obj;
         return (label.equalsIgnoreCase(d.getLabel())
            && Math.abs(edge - d.getEdge()) < .000001);
      }
   }
   
   /**
   I have no idea what this does to be honest.
   @return 0 for some reason to appease the CheckStyle gods
   */
   public int hashCode()
   {
      return 0;
   }
   
   /**
   Compares tetrahedrons based on volume.
   @return -1 if less, 0 if equal, 1 if greater
   @param tetra Tetrahedron to compare to
   */
   public int compareTo(Tetrahedron tetra)
   {
      if (this.volume() < tetra.volume())
      {
         return -1;
      }
      else if ((Math.abs(this.volume() - tetra.volume()) < 0.000001))
      {
         return 0;
      }
      else
      {
         return 1;
      }
   }
}