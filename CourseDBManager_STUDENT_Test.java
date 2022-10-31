/**
 * @author Sepand Jahrominejad
 * 
 * CMSC 204
 * Project 4
 * 10/30/2022
 */




import static org.junit.Assert.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 */
public class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("CMSC100",21556,2,"Distance-Learning","Janet E. Joy");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		dataMgr.add("CMSC100",21556,2,"Distance-Learning","Janet E. Joy");
		dataMgr.add("CMSC100",22344,2,"SW217","Gloria E. Barron");
		dataMgr.add("CMSC100",21561,2,"SC451","Rabiha J. Kayed");
		ArrayList<String> list = dataMgr.showAll();
		assertEquals(list.get(0),"\nCourse:CMSC100 CRN:22344 Credits:2 Instructor:Gloria E. Barron Room:SW217");
	 	assertEquals(list.get(1),"\nCourse:CMSC100 CRN:21556 Credits:2 Instructor:Janet E. Joy Room:Distance-Learning");
		assertEquals(list.get(2),"\nCourse:CMSC100 CRN:21561 Credits:2 Instructor:Rabiha J. Kayed Room:SC451");
	}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("StudentTest.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC110 21565 3 DistanceLearning Janet E. Joy\n"
					+ "CMSC110 21564 3 SC451 Behzad Maghami\n"
					+ "CMSC110 21560 3 SC450 Behzad Maghami");
			
			inFile.close();
			dataMgr.readFile(inputFile);
			assertEquals("CMSC110",dataMgr.get(21565).getID());
			assertEquals("CMSC110",dataMgr.get(21564).getID());
			assertEquals("SC450",dataMgr.get(21560).getRoomNum());
			assertEquals("DistanceLearning",dataMgr.get(21565).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
