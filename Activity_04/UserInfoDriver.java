/**
This class relates to the UserInfo class by creating two 
instances of it. It then invokes the methods of the 
UserInfo class objects.
* Activity 04
* @author Chandler Dykes
* @version 02/08/2021
*/

public class UserInfoDriver
{
   /**
   Creates new UserInfo objects to store 
   users' information.
   * @param args Command Line arguments (Not used)
   */
   public static void main(String[] args)
   {
      //Creates instance for user1
      UserInfo user1 = new UserInfo("Pat", "Doe");
      System.out.println("\n" + user1);
      user1.setLocation("Auburn");
      user1.setAge(19);
      user1.logOn();
      System.out.println("\n" + user1);
      
      //Creates instance for user2
      UserInfo user2 = new UserInfo("Sam", "Jones");
      System.out.println("\n" + user2);
      user2.setLocation("Atlanta");
      user2.setAge(21);
      user2.logOn();
      System.out.println("\n" + user2);
   }
}