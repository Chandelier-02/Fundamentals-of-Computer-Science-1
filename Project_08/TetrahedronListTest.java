import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
Tests the methods of the TetrahedronList object.
@author Chandler Dykes
@version 03/26/2021
*/

public class TetrahedronListTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /**
   Tests the getName method.
   */
   @Test public void getNameTest()
   {
      Tetrahedron[] tetras = {new Tetrahedron("Yeet", 5.0), 
         new Tetrahedron("Yote", 10.0)};
      TetrahedronList thList = new TetrahedronList("The List", tetras, 2);
      Assert.assertEquals("The List", thList.getName());
   }
   
   /**
   Tests the numberOfTetrahedrons method.
   */
   @Test public void numberOfTetrahedronsTest()
   {
      Tetrahedron[] tetras = {new Tetrahedron("Yeet", 5.0), 
         new Tetrahedron("Yote", 10.0)};
      TetrahedronList thList = new TetrahedronList("The List", tetras, 2);
      Assert.assertEquals(2, thList.numberOfTetrahedrons());
      Tetrahedron[] zero = new Tetrahedron[0];
      TetrahedronList none = new TetrahedronList("None", zero, 0);
      Assert.assertEquals(0, none.numberOfTetrahedrons());
   }
   
   /**
   Tests the totalSurfaceArea method.
   */
   @Test public void totalSurfaceAreaTest()
   {
      Tetrahedron[] tetras = {new Tetrahedron("Yeet", 5.0), 
         new Tetrahedron("Yote", 10.0)};
      double s1 = tetras[0].surfaceArea();
      double s2 = tetras[1].surfaceArea();
      double sTotal = s1 + s2;
      TetrahedronList thList = new TetrahedronList("The List", tetras, 2);
      Assert.assertEquals(sTotal, thList.totalSurfaceArea(), 0.0001);
      Tetrahedron[] extended = {new Tetrahedron("Yeet", 5.0), 
         new Tetrahedron("Yote", 10.0), null};
      double ss1 = extended[0].surfaceArea();
      double ss2 = extended[1].surfaceArea();
      double ssTotal = ss1 + ss2;
      TetrahedronList extendedList = new TetrahedronList("Extended", 
         extended, 3);
      Assert.assertEquals(ssTotal, extendedList.totalSurfaceArea(), 0.0001);
   }
   
   /**
   Tests the totalVolume method.
   */
   @Test public void totalVolume()
   {
      Tetrahedron[] tetras = {new Tetrahedron("Yeet", 5.0), 
         new Tetrahedron("Yote", 10.0)};
      double v1 = tetras[0].volume();
      double v2 = tetras[1].volume();
      double vTotal = v1 + v2;
      TetrahedronList thList = new TetrahedronList("The List", tetras, 2);
      Assert.assertEquals(vTotal, thList.totalVolume(), 0.0001);
      Tetrahedron[] extended = {new Tetrahedron("Yeet", 5.0), 
         new Tetrahedron("Yote", 10.0), null};
      double vv1 = extended[0].volume();
      double vv2 = extended[1].volume();
      double vvTotal = vv1 + vv2;
      TetrahedronList extendedList = new TetrahedronList("Extended", 
         extended, 3);
      Assert.assertEquals(vvTotal, extendedList.totalVolume(), 0.0001);
   }
   
   /**
   Tests the avergaeSurfaceArea and averageVolume methods.
   */
   @Test public void averageSurfaceAreaAndVolumeTest()
   {
      Tetrahedron[] tetras = {new Tetrahedron("Yeet", 5.0), 
         new Tetrahedron("Yote", 10.0)};
      TetrahedronList thList = new TetrahedronList("The List", tetras, 2);
      double s1 = tetras[0].surfaceArea();
      double s2 = tetras[1].surfaceArea();
      double sTotal = s1 + s2;
      double sAvg = sTotal / thList.numberOfTetrahedrons();
      double v1 = tetras[0].volume();
      double v2 = tetras[1].volume();
      double vTotal = v1 + v2;
      double vAvg = vTotal / thList.numberOfTetrahedrons();
      Assert.assertEquals(sAvg, thList.averageSurfaceArea(), 0.00001);
      Assert.assertEquals(vAvg, thList.averageVolume(), 0.00001);
   }
   
   /**
   Tests the toString method.
   */
   @Test public void toStringTest()
   {
      Tetrahedron[] tetras = {new Tetrahedron("Yeet", 5.0), 
         new Tetrahedron("Yote", 10.0)};
      TetrahedronList thList = new TetrahedronList("The List", tetras, 2);
      Assert.assertTrue(thList.toString().contains("Number of Tetrahedrons: "));
   }
   
   /**
   Tests the getList method.
   */
   @Test public void getListTest()
   {   
      Tetrahedron[] tetras = {new Tetrahedron("Yeet", 5.0), 
         new Tetrahedron("Yote", 10.0)};
      TetrahedronList thList = new TetrahedronList("The List", tetras, 2);
      Assert.assertEquals(tetras, thList.getList());
   }
   
   /**
   Tests the addTetrahedron method.
   */
   @Test public void addTetrahedronTest()
   {
      Tetrahedron[] tetras = {new Tetrahedron("Yeet", 5.0), 
         new Tetrahedron("Yote", 10.0)};
      TetrahedronList thList = new TetrahedronList("The List", tetras, 2);
      thList.addTetrahedron("New Tetra", 8.0);
      Tetrahedron[] test = {new Tetrahedron("Yeet", 5.0), 
         new Tetrahedron("Yote", 10.0), new Tetrahedron("New Tetra", 8.0)};
      TetrahedronList testList = new TetrahedronList("The Test", test, 3);
      Assert.assertEquals(3, thList.numberOfTetrahedrons());
   }
   
   /**
   Tests the findTetrahedron method.
   */
   @Test public void findTetrahedronTest()
   {
      Tetrahedron[] tetras = {new Tetrahedron("Yeet", 5.0), 
         new Tetrahedron("Yote", 10.0)};
      TetrahedronList thList = new TetrahedronList("The List", tetras, 2);
      Tetrahedron th = tetras[0];
      Assert.assertEquals(th, thList.findTetrahedron("Yeet"));
   }
   
   /**
   Tests the deleteTetrahedron method.
   */
   @Test public void deleteTetrahedronTest()
   {
      Tetrahedron[] tetras = {new Tetrahedron("Yeet", 5.0), 
         new Tetrahedron("Yote", 10.0)};
      TetrahedronList thList = new TetrahedronList("The List", tetras, 2);
      Tetrahedron deleted = tetras[0];
      Assert.assertEquals(deleted, thList.deleteTetrahedron("Yeet"));
      Assert.assertEquals(null, thList.deleteTetrahedron("Not In List"));
   }
   
   /**
   Tests the editTetrahedron method.
   */
   @Test public void editTetrahedronTest()
   {
      Tetrahedron[] tetras = {new Tetrahedron("Yeet", 5.0), 
         new Tetrahedron("Yote", 10.0)};
      TetrahedronList thList = new TetrahedronList("The List", tetras, 2);
      Tetrahedron edited = new Tetrahedron("Yeet", 8.0);
      Assert.assertEquals(true, thList.editTetrahedron("Yeet", 8.0));
   }
   
   /**
   Tests the findTetrahedronWithLargestVolume method.
   */
   @Test public void findTetrahedronWithLargestVolumeTest()
   {
      Tetrahedron[] tetras = {new Tetrahedron("Yeet", 5.0), 
         new Tetrahedron("Yote", 10.0)};
      TetrahedronList thList = new TetrahedronList("The List", tetras, 2);
      Assert.assertEquals(tetras[1], thList.findTetrahedronWithLargestVolume());
      
      Tetrahedron[] none = new Tetrahedron[0];
      TetrahedronList noneList = new TetrahedronList("None", none, 0);
      Assert.assertEquals(null, noneList.findTetrahedronWithLargestVolume());
   }
}
