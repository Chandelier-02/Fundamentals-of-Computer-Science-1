import javax.swing.JOptionPane;

/**
Main driver for the division program. Creates a JOption Pane for user input
and then uses those values to divide. Also provides try, throw, and catch 
statements.
@author Chandler Dykes
@version 04/13/2021
*/

public class DivisionDriver
{
   /**
   Creats the JOptionsPane and invokes the static Division methods
   to divide the inputs.
   @param args Command Line arguments - not used
   */
   public static void main(String[] args)
   {
      String numInput = JOptionPane.showInputDialog("Enter the Numerator:");
      String denomInput 
         = JOptionPane.showInputDialog("Enter the Denominator:");
      
      try 
      {   
         int num = Integer.parseInt(numInput);
         int denom = Integer.parseInt(denomInput);
      
         String result = "Integer division: \n"
            + Division.intDivide(num, denom)
            + "\n\nFloating point division: \n"
            + Division.decimalDivide(num, denom);
         
         JOptionPane.showMessageDialog(null, result, 
            "Result", JOptionPane.PLAIN_MESSAGE);
      }
      catch (NumberFormatException e)
      {
         JOptionPane.showMessageDialog(null,
            "Invalid input: enter numerical integer values only.",
            "Error", JOptionPane.ERROR_MESSAGE);
      }
      catch (IllegalArgumentException e)
      {
         JOptionPane.showMessageDialog(null,
            e, "Error", JOptionPane.ERROR_MESSAGE);
      }
   }
}