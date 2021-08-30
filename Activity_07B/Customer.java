/**
This activity creates a customer object with various 
methods to modify the object as well as a means to
compare customer objects.
@author Chandler Dykes
@version 03/15/2021
Activity 07B
*/

public class Customer implements Comparable<Customer>
{
   private String customerName = "";
   private String customerLocation = "";
   private double balance = 0;
   
   /**
   Constructor for customer object.
   @param nameIn customer's name
   */
   public Customer(String nameIn)
   {
      customerName = nameIn;
      customerLocation = "";
      balance = 0; 
   }
   
   /**
   Sets the customer's location.
   @param locationIn customer's location
   */
   public void setLocation(String locationIn)
   {
      customerLocation = locationIn;
   }
   
   /**
   Sets the customer's location.
   @param city customer's city of dwelling
   @param state customer's state of dwelling
   */
   public void setLocation(String city, String state)
   {
      customerLocation = city + ", " + state;
   }
   
   /**
   Changes the customer's balance.
   @param amount customer's new balance
   */
   public void changeBalance(double amount)
   {
      balance = amount;
   }
   
   /**
   Gets the customer's location.
   @return customerLocation returns their location
   */ 
   public String getLocation()
   {
      return customerLocation;
   }
   
   /**
   Gets the customer's balance.
   @return balance customer's balance
   */
   public double getBalance()
   {
      return balance;
   }
   
   /**
   Formats the output of the customer object.
   @return output formatted output
   */
   public String toString()
   {
      String output = "";
      output += customerName;
      output += "\n" + getLocation();
      output += "\n" + "$" + getBalance();
      return output;
   }
   
   /**
   Compares customers based on balance amounts.
   @return 0 if customer balance is the same. Return
      -1 if the customer balance is less. 1 if greater
   @param obj customer to be compared to
   */
   public int compareTo(Customer obj)
   {
      if (Math.abs(this.balance - obj.getBalance()) < 0.000001)
      {
         return 0;
      }
      else if (this.balance < obj.getBalance())
      {
         return -1;
      }
      else
      {
         return 1;
      }
   }
}