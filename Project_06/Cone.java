import java.text.DecimalFormat;

/**
This program is used to generate a cone object based 
on height, radius, and name input. It then calculates
the perimeterof the base, base area, slant height,
side area, surface area, and volume from the values 
inputted.
* @author Chandler Dykes
* @version 02/11/2021
* Project 04 Cone
*/

public class Cone
{
   //instance variables
   private String label;
   private double height, radius;
   
   //constructor
   /**
   Takes in the label, height, and radius and then 
   sets those values to instance variables.
   * @param labelIn - name of cone
   * @param heightIn - height of cone
   * @param radiusIn - radius of cone
   */
   public Cone(String labelIn, double heightIn, double radiusIn)
   {
      setLabel(labelIn);
      setHeight(heightIn);
      setRadius(radiusIn);
   }
    
    //methods
    
    /**
    Sets the label if it is not null.
    * @param labelIn - name of cone
    * @return - returns value of isSet 
    */  
   public boolean setLabel(String labelIn)
   {
      boolean isSet = false;
      if (labelIn != null)
      {
         label = labelIn.trim();
         isSet = true;
      }
      return isSet;
   }
   
   /**
   Returns the label of the cone.
   * @return - returns label of cone
   */
   public String getLabel()
   {
      return label;
   }

   /**
   Returns the height of the cone.
   * @return - returns the height of the cone
   */
   public double getHeight()
   {
      return height;
   }
   
   /**
   Sets the height if it is > 0.
   * @param heightIn - height of cone
   * @return isSet - returns isSet
   */
   public boolean setHeight(double heightIn)
   {
      boolean isSet = false;
      if (heightIn > 0)
      {
         height = heightIn;
         isSet = true;
      }
      return isSet;
   }
   
   /**
   Returns the radius of the cone's base.
   * @return - returns the radius of the cone's base
   */
   public double getRadius()
   {
      return radius;
   }
   
   /**
   Sets the radius if it is > 0.
   * @param radiusIn - radius of cone base
   * @return isSet - returns isSet
   */
   public boolean setRadius(double radiusIn)
   {
      boolean isSet = false;
      if (radiusIn > 0)
      {
         radius = radiusIn;
         isSet = true;
      }
      return isSet;
   }
   
   /**
   Returns the length of the base perimetere of the cone.
   * @return - returns length of base perimeter
   */
   public double basePerimeter()
   {
      return 2 * Math.PI * radius;
   }
   
   /**
   Returns the area of the cone's base.
   * @return - returns area of base
   */
   public double baseArea()
   {
      return Math.PI * Math.pow(radius, 2);
   }
   
   /**
   Returns the slant height of the side of the cone.
   * @return - returns length of slant height
   */
   public double slantHeight()
   {
      return Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
   }
   
   /**
   Returns the area of the side of the cone.
   * @return - returns the area of the side of cone
   */
   public double sideArea()
   {
      return Math.PI * radius * slantHeight();
   }
   
   /**
   Returns the area of the cone's surface.
   * @return - returns the area of cone's surface
   */
   public double surfaceArea()
   {
      return Math.PI * radius * (radius + slantHeight());
   }
   
   /**
   Returns the volume of the cone.
   * @return - returns the volume of the cone
   */
   public double volume()
   {
      return Math.PI * Math.pow(radius, 2) * height / 3;
   }
   
   /**
   Turns the cone's values into an easily readable 
   string and formats the values included.
   * @return - returns the output
   */
   public String toString()
   {
      DecimalFormat dcv = new DecimalFormat("#,##0.0##");
      String output = "\"" + label + "\"" + " is a cone with height = " 
         + dcv.format(height) + " units and radius = "
         + dcv.format(radius) + " units,\nwhich has base perimeter = "
         + dcv.format(basePerimeter()) + " units, base area = " 
         + dcv.format(baseArea()) + " square units,\nslant height = "
         + dcv.format(slantHeight()) + " units, side area = "
         + dcv.format(sideArea()) + " square units,\nsurface area = "
         + dcv.format(surfaceArea()) + " square units, and volume = "
         + dcv.format(volume()) + " cubic units.";
         
      return output;
   }
}