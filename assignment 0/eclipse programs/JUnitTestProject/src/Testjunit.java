import org.junit.Test;

import static org.junit.Assert.assertEquals;





public class Testjunit {

	String message = "Hello World";
	MessageUtil messageUtil = new MessageUtil(message);
	
	@Test
	
	public void testPrintMessage()
	{
		assertEquals(message, messageUtil.printMessage());
		
	}

}
