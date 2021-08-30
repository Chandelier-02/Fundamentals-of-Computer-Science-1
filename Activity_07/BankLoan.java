/**
* This class creates a BankLoan object as well as contains
* methods for such loans.
* @author Chandler Dykes
* @version 03/09/2021
* Activity 07
*/
public class BankLoan {
	// constant fields
   private static final int MAX_LOAN_AMOUNT = 100000;

   // instance variables (can be used within the class)
   private String customerName;
   private double balance, interestRate;
   private static int loansCreated = 0;

   /**
   Creates a BankLoan constructor.
   @param customerNameIn customer's name input
   @param interestRateIn interest rate input
   */
   public BankLoan(String customerNameIn, double interestRateIn) { 
      customerName = customerNameIn;
      interestRate = interestRateIn;
      balance = 0;
      loansCreated++;
   }
   
   /**
   Returns the # of loans created.
   @return loansCreated 
   */
   public static int getLoansCreated()
   {
      return loansCreated;
   }
   
   /**
   Resets loansCreated to 0.
   */
   public static void resetLoansCreated()
   {
      loansCreated = 0;
   }
   
   /**
   Creates a boolean for if a loan was made or not.
   @param amount amount that is borrowed
   @return wasLoanMade returns if the loan was made
   */
   public boolean borrowFromBank(double amount) {
      
      boolean wasLoanMade = false;
      
      if (balance + amount < MAX_LOAN_AMOUNT) {
         wasLoanMade = true;
         balance += amount;
      }
   
      return wasLoanMade;
   }

   /**
   Creats a way for one to pay the bank back.
   @param amountPaid amount the client paid
   @return Math.abs(newBalance) returns the overcharge
   */
   public double payBank(double amountPaid) {
      double newBalance = balance - amountPaid;
      if (newBalance < 0) {
         balance = 0;
         // paid too much, return the overcharge
         return Math.abs(newBalance);
      }
      else {
         balance = newBalance;
         return 0;
      }
   }
   
   /**
   Gets the client's balance.
   @return balance user's balance
   */
   public double getBalance() {
      return balance;
   }
   
   /**
   Sets the interest rate for the client.
   @param interestRateIn client's interest rate
   @return if the interest rate has been set or not
   */
   public boolean setInterestRate(double interestRateIn) {
   
      if (interestRateIn >= 0 && interestRateIn <= 1) {
         interestRate = interestRateIn;
         return true;
      }
      else {
         return false;
      }
   }
   
   /**
   Gets the interest rate for the client.
   @return interestRate client's interest rate
   */
   public double getInterestRate() {
      return interestRate;
   }
   
   /**
   Charges interest to the loan amount.
   */
   public void chargeInterest() {
      balance = balance * (1 + interestRate);
   }
   
   /**
   Declares if the loan amount is valid.
   @param amount loan amount input
   @return if the amount is valid
   */
   public static boolean isAmountValid(double amount)
   {
      if (amount >= 0)
      {
         return true;
      }
      return false;
   }
   
   /**
   Declares if the client is in debt.
   @param loan client's loan amount
   @return if the client is in debt
   */
   public static boolean isInDebt(BankLoan loan)
   {
      if (loan.getBalance() > 0)
      {
         return true;
      }
      return false;
   }
   
   /**
   Formats the BankLoan output.
   @return output returns the formatted output
   */
   public String toString() {
      String output = "Name: " + customerName + "\r\n" 
         + "Interest rate: " + interestRate + "%\r\n" 
         + "Balance: $" + balance + "\r\n";
      return output;
   }

}
