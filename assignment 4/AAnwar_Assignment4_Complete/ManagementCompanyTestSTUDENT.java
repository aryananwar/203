package assignment4;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	Property p1, p2, p3, p4, p5, p6;
	ManagementCompany co = new ManagementCompany(); 
	@Before
	public void setUp() throws Exception {
		
		//student create a management company
		
		//student add three properties, with plots, to mgmt co
		p1 = new Property ("Hello", "Amazing", 300, "A",2,1,2,2);
		p2 = new Property ("Nice", "Great", 4500, "B", 6,1,1,2);
		p3 = new Property ("Foo", "Bar", 200, "C",3,5,2,1);
		co.addProperty(p1);
		co.addProperty(p2);
		co.addProperty(p3);
		
	}

	@After
	public void tearDown() {
		p1=p2=p3=null;
		co=null;  
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot (0,0,1,1)
		assertEquals(co.addProperty("burp", "slap", 5000, "no way"), 3,0 );
		//student should add property with 8 args
		assertEquals(co.addProperty("hey", "hi", 400, "no thanks", 2, 3, 1, 9), 4,0);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
		assertEquals(co.addProperty("sorry", "no", 100, "room for you", 2, 3, 1, 9), -1, 0);
	}
 
	@Test
	public void testMaxRentProp() {
		assertEquals(co.maxRentProp(),4500.0,0);
		
	}

	@Test
	public void testTotalRent() {
		assertEquals(co.totalRent(),5000.0,0);
	}

 }
