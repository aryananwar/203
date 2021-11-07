

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSetSTUDENT = {{2.5 ,11.3 ,4.2},{6.5},{3.2,7.5,32.1},{5.34,2.9,11.3,7.8}};
	
	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(94.64,TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT),.001);	
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(8.603,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT),.001);
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(18.0,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT,0),.001);
		assertEquals(6.5,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT,1),.001);
		assertEquals(42.8,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT,2),.001);
		assertEquals(27.34,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT,3),.001);
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(17.54,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT,0),.001);
		assertEquals(21.7,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT,1),.001);
		assertEquals(47.60,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT,2),.001);
		assertEquals(7.8,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT,3),.001);
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(32.1,TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT),.001);	
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] array=null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT, outputFile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array = TwoDimRaggedArrayUtility.readFile(outputFile); 
		assertEquals(2.5, array[0][0],.001);
		assertEquals(11.3, array[0][1],.001);
		assertEquals(4.2, array[0][2],.001);
		assertEquals(6.5, array[1][0],.001);
		assertEquals(3.2, array[2][0],.001);
		assertEquals(7.5, array[2][1],.001);
		assertEquals(32.1, array[2][2],.001);
		assertEquals(5.34, array[3][0],.001);
		assertEquals(2.9, array[3][1],.001);
		assertEquals(11.3, array[3][2],.001);
		assertEquals(7.8, array[3][3],.001);
	}

}
