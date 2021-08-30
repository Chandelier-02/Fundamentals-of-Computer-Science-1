/**
* This program will consist of two classes: UserInfo
* and UserInfoDriver which will contain a main method 
* used for creating instances of UserInfo and calling 
* its methods.
* Activity 4
* @author Chandler Dykes
* @version 02/08/2021
*/

public class UserInfo
{
   // instance varibales
   private String firstName, lastName, location;
   private int age;
   private int status;
   private static final int OFFLINE = 0, ONLINE = 1;
   
   // constructor
   /**
   This constructor takes in the first and last names of
   the user as well as their loaction, age, and status.
   * @param firstNameIn - user's first name
   * @param lastNameIn - user's last name
   */
   public UserInfo(String firstNameIn, String lastNameIn)
   {
      firstName = firstNameIn;
      lastName = lastNameIn;
      location = "Not specified";
      age = 0;
      status = OFFLINE;
   }
   
   // methods
   /**
   This method returns a string representation of the 
   UserInfo object.
   * @return - returns a string representing the UserInfo object.
   */
   public String toString()
   {
      String output = "Name: " + firstName + " "
         + lastName + "\n";
      output += "Location: " + location + "\n";
      output += "Age: " + age + "\n";
      output += "Status: ";
      if (status == OFFLINE)
      {
         output += "Offline";
      }
      else
      {
         output += "Online";
      }
      return output;
   }
   
   /**
   This method sets the location of the user.
   @param locationIn - user's location
   */
   public void setLocation(String locationIn)
   {
      location = locationIn;
   }
   
   /**
   This method sets the age of the user if it 
   is above 0.
   * @param ageIn - user's age
   * @return isSet - returns the value of isSet.
   */
   public boolean setAge(int ageIn)
   {
      boolean isSet = false;
      if (ageIn > 0)
      {
         age = ageIn;
         isSet = true;
      }
      return isSet;
   }
   
   /**
   This method gets the age of the user.
   * @return age - returns user's age
   */
   public int getAge()
   {
      return age;
   }
   
   /**
   This method sets the location of the user.
   * @return location - returns user's location
   */ 
   public String getLocation()
   {
      return location;
   }
   
   /**
   This method sets the user's status to offline.
   */
   public void logOff() 
   {
      status = OFFLINE;
   }
   
   /**
   This method sets the user's status to online.
   */
   public void logOn()
   {
      status = ONLINE;
   }
}