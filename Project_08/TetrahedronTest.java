import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
Tests the various methods of the tetrahedron object.
@author Chandler Dykes
@version 03/12/2021
Project 07A
*/
public class TetrahedronTest {


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
   Tests the height method.
   */
   @Test public void heightTest()
   {
      Tetrahedron th = new Tetrahedron("Large Example", 97.36);
      Assert.assertEquals(79.494, th.height(), 0.001);
   }
   
   /**
   Tests the surface area method.
   */
   @Test public void sATest()
   {
      Tetrahedron th = new Tetrahedron("Large Example", 97.36);
      Assert.assertEquals(16418.057, th.surfaceArea(), 0.001);
   }
   
   /**
   Tests the volume method.
   */
   @Test public void volumeTest()
   {
      Tetrahedron th = new Tetrahedron("Large Example", 97.36);
      Assert.assertEquals(108761.565, th.volume(), 0.001);
   }
   
   /**
   Tests the label methods.
   */
   @Test public void label()
   {
      Tetrahedron th = new Tetrahedron("Large Example", 97.36);
      th.setLabel("Really Large");
      Assert.assertEquals("Really Large", th.getLabel());
      Tetrahedron th2 = new Tetrahedron("Large Example", 100);
      Assert.assertEquals(false, th2.setLabel(null));
      Tetrahedron th3 = new Tetrahedron("Large Example", 200);
      Assert.assertEquals(true, th3.setLabel("Big Example"));
   }
   
   /**
   Tests the edge methods.
   */
   @Test public void edge()
   {
      Tetrahedron th = new Tetrahedron("Large Example", 97.36);
      th.setEdge(80.00);
      Assert.assertEquals(80, th.getEdge(), 0.0001);
      Tetrahedron th2 = new Tetrahedron("Large Example", 100);
      Assert.assertEquals(false, th2.setEdge(-1));
      Tetrahedron th3 = new Tetrahedron("Large Example", 200);
      Assert.assertEquals(true, th3.setEdge(1));
   }
   
   /**
   Tests the toString method.
   */
   @Test public void toStringTest()
   {
      Tetrahedron th = new Tetrahedron("Large Example", 97.36);
      Assert.assertTrue(th.toString().contains("\"Large Example\""));
   }
   
   /**
   Tests the getCount method.
   */
   @Test public void getCountTest()
   {
      Tetrahedron.resetCount();
      Assert.assertEquals(0, Tetrahedron.getCount());
      Tetrahedron th = new Tetrahedron("Large Example", 97.36);
      Tetrahedron th2 = new Tetrahedron("Indeed", 69.00);
      Tetrahedron th3 = new Tetrahedron("For Real", 420.00);
      Assert.assertEquals(3, th.getCount());
   }
   
   /**
   Tests the equals method.
   */
   @Test public void equalsTest()
   {
      Tetrahedron th = new Tetrahedron("Large Example", 97.36);
      Tetrahedron th2 = new Tetrahedron("Large Example", 97.36);
      Assert.assertEquals(th, th2);
      Assert.assertEquals(0, th.hashCode());
      Tetrahedron notSameName = new Tetrahedron("Small Example", 97.36);
      Tetrahedron notSameEdge = new Tetrahedron("Large Example", 100);
      Assert.assertFalse(th.equals(notSameName));
      Assert.assertFalse(th.equals(notSameEdge));
      Assert.assertEquals(false, th.equals(55));
      Assert.assertTrue(th.equals(th));
   }
   
   /**
   Tests the compareTo method.
   */
   @Test public void compareTo()
   {
      Tetrahedron large = new Tetrahedron("Large Example", 97.36);
      Tetrahedron small = new Tetrahedron("Small Example", 5.00);
      Tetrahedron equalsLarge = new Tetrahedron("Big Boy", 97.36);
      Assert.assertEquals(-1, small.compareTo(large));
      Assert.assertEquals(0, large.compareTo(equalsLarge));
      Assert.assertEquals(1, large.compareTo(small));
   }
}
