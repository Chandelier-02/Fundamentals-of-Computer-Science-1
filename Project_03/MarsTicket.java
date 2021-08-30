import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;

/**
* This program will accept coded ticket information as input
* that includes price, discount, time, date, seat, followed
* by a description of the ticket. Then, the program will print
* the ticket information including the actual cost with discount
* and then contain a random prize number.
* Project 2
* @author Chandler Dykes
* @version 02/05/2021 
*/

public class MarsTicket
{
   /**
   * Takes the input and displays information on the ticket.
   * @param args Command line arguments (not used)
   */
   
   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      
      System.out.print("Enter ticket code: ");
      String ticketCode = userInput.nextLine().trim();
      int ticketLength = ticketCode.length();
      System.out.println("");
      
      //Checks if user inputted actual ticket
      if (ticketCode.length() < 27)
      {
         System.out.println("*** Invalid Ticket Code ***");
         System.out.println("Ticket code must have at least 27 "
            + "characters.");
      }
      else
      {
         int index = 26;
         //Breaks apart the string into readable pieces
         String ticketName = ticketCode.substring(index, ticketLength);
         String priceOnTicket = ticketCode.substring(0, 9);
         String discountOnTicket = ticketCode.substring(9, 11);
         String time = ticketCode.substring(11, 15),
                hours = time.substring(0, 2),
                minutes = time.substring(2, 4);
         String dateOnTicket = ticketCode.substring(15, 23), 
                month = dateOnTicket.substring(0, 2),
                day = dateOnTicket.substring(2, 4),
                year = dateOnTicket.substring(4, 8);
         String seat = ticketCode.substring(23, 26);
         
         //Generate random number for prize
         Random generator = new Random();
         int prize = generator.nextInt(999999) + 1;
         
         //Parses the double values
         double priceNum = Double.parseDouble(priceOnTicket);
         double discountAmt = Double.parseDouble(discountOnTicket) / 100;
         
         //Calculates cost
         double discountPrice = (priceNum - (priceNum * discountAmt));
         
         //Formats the data
         String dateFormatted = month.concat("/") + day.concat("/")
            + year;
         String timeFormatted = hours.concat(":") + minutes; 
         DecimalFormat priceFormatted = new DecimalFormat("$#,##0.00");
         DecimalFormat discFormatted = new DecimalFormat("0%");
         DecimalFormat prizeFormatted = new DecimalFormat("000000");
         
         //Prints the information
         System.out.println("Ticket: " + ticketName + "   Date: "
            + dateFormatted + "   Time: " + timeFormatted
            + "\nSeat: " + seat + "   Price: " 
            + priceFormatted.format(priceNum / 100) + "   Discount: "
            + discFormatted.format(discountAmt) + "   Cost: "
            + priceFormatted.format(discountPrice / 100) + "\nPrize Number: "
            + prizeFormatted.format(prize));
            
      }
      
   }
}