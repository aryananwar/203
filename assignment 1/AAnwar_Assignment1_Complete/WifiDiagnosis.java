import java.util.Scanner;
/*
 * Class: CMSC203-24307
 * Instructor: Dr. Tsai
 * Description: program that diagnoses wifi problems
 * Due: 9/12/2021
 * Platform/compiler: java
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Aryan Anwar
*/


public class WifiDiagnosis {

	
	
	public static void main(String[] args) 
	{
		//declare scanner object and string for answer
		String answer;
		Scanner keyboard = new Scanner(System.in);
	
		//step 1
		System.out.println("if you have a problem with internet conectivity, this wifi diagnosis might work \n");
		System.out.println("first step: reeboot your computer");
		System.out.println("are you able to connect to the internet (yes/no)");
		answer = keyboard.nextLine();
		if (answer.equalsIgnoreCase("yes"))
		{
			System.out.println("reebooting your computer seemed to work");
			System.exit(0);
		}

		
		//step 2
		System.out.println("second step: reeboot your router");
		System.out.println("are you able to connect to the internet (yes/no)");
		answer = keyboard.nextLine();
		if (answer.equalsIgnoreCase("yes"))
		{
			System.out.println("reebooting your router seemed to work");
			System.exit(0);
		}
		
		
		//step 3
		System.out.println("third step: make sure the cables to your router are plugged in firmly and your router is getting power");
		System.out.println("are you able to connect to the internet (yes/no)");
		answer = keyboard.nextLine();
		if (answer.equalsIgnoreCase("yes"))
		{
			System.out.println("readjusting your cables seeemed to work ");
			System.exit(0);
		}
		
		
		//step 4
		System.out.println("fourth step: move your computer closer to your router");
		System.out.println("are you able to connect to the internet (yes/no)");
		answer = keyboard.nextLine();
		if (answer.equalsIgnoreCase("yes"))
		{
			System.out.println("moving your computer closer to your router seemed to work");
			System.exit(0);
		}
		
		
		//step 5
		System.out.println("fifth step: contact your ISP \nmake sure your ISP is hooked up to your router");
		System.out.println("are you able to connect to the internet (yes/no)");
		answer = keyboard.nextLine();
		if (answer.equalsIgnoreCase("yes"))
		{
			System.out.println("contacting your ISP seemed to work");
			System.exit(0);
		}
		System.exit(0);
		
		
		
	}
	

}
