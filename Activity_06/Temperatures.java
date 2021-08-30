import java.util.ArrayList;

/**
Holds a set of integer values representing daily temperatures
and contains methods for finding high and low temperatures and
comparing temperatures.
@author Chandler Dykes
@version 02/23/2021
Activity 06
*/
public class Temperatures
{
   private ArrayList<Integer> temperatures = new ArrayList<Integer>();
   
   /**
   Constructor that takes in a list of temperatures and assigns
   that array to a local array.
   @param temperaturesIn ArrayList of temperatures inputted
   */
   public Temperatures(ArrayList<Integer> temperaturesIn)
   {
      temperatures = temperaturesIn;
   }
   
   /**
   Scans through the array of temperatures and finds the lowest temp.
   @return low returns the lowest temperature.
   */
   public int getLowTemp()
   {
      if (temperatures.isEmpty())
      {
         return 0;
      }
      int low = temperatures.get(0);
      for (int i = 0; i < temperatures.size(); i++)
      {
         if (temperatures.get(i) < low)
         {
            low = temperatures.get(i);
         }
      }
      return low;
   }
   
   /**
   Scans through the array of temperatures and finds the lowest temp.
   @return high returns the highest temperature.
   */
   public int getHighTemp()
   {
      if (temperatures.isEmpty())
      {
         return 0;
      }
      int high = temperatures.get(0);
      for (Integer temp : temperatures)
      {
         if (temp > high)
         {
            high = temp;
         }
      }
      return high;
   }
   
   /**
   Compares a value the user inputs vs lowest value in array and 
   returns which one one lower.
   @return returns which value is the lowest 
   @param lowIn user input for integer to test
   */
   public int lowerMinimum(int lowIn)
   {
      return lowIn < getLowTemp() ? lowIn : getLowTemp();
   }
   
   /**
   Compares a value the user inputs vs the highest value in array and 
   returns which one is higher.
   @return returns which value is the highest
   @param highIn user input for integer to test
   */
   public int higherMaximum(int highIn)
   {
      return highIn > getHighTemp() ? highIn : getHighTemp();
   }
   
   /**
   Returns the values of the class in a string.
   @return returns the values of the class in a string
   */
   public String toString()
   {
      return "\tTemperatures: " + temperatures
         + "\n\tLow: " + getLowTemp()
         + "\n\tHigh: " + getHighTemp();
   }
}