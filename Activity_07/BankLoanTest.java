//import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
This class is used to test the methods of the BankLoan.java class.
* @author Chandler Dykes
* @version 03/09/2021
* Activity 07
*/
public class BankLoanTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   /*@Test public void defaultTest() {
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   }*/
   
   /**
   Tests the make sure the chargeInterestRate method works.
   */
   @Test public void chargeInterestRate()
   {
      BankLoan loan1 = new BankLoan("Jane", .10);
      loan1.borrowFromBank(1000.00);
      loan1.chargeInterest();
      assertEquals(" ", 1100, loan1.getBalance(), .000001);
   }
}
