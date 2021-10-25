package assignment2;
import java.util.Scanner;


public class driver {
	
	public static void main (String args[])
	{
		// declare variables for do-while statements
		String yesno = "";
		int guess;
		int lowGuess = 0;
		int highGuess= 100;
		boolean a;
		
		//declare objects
		Scanner key = new Scanner(System.in);
		RNG x = new RNG();
		
		
		
		
		//main do while statement that loops controls entire program, only loops again if the user wants to play another round of guessing
		do 
		{
			//create random number set equal to num
			int num = x.rand();
			
			// print number for debugging purpose
			 System.out.println(num);
			
			//ask user to enter number between 0-100, if number is less or greater than loop through
			do
			{
				System.out.println("Enter a number that is between 0 and 100");
				guess = key.nextInt();
				key.nextLine();
				
			} while(guess < 0 || guess > 100);
			
			
			
			// while the guess is not the number execute the code logic of changing low-high ranges based on what the user enters
			while (guess != num)
			{
				int ogGuess = guess;
				if (guess < num)
				{
			
					System.out.println("Your guess is too low, try again!");
					System.out.println("Enter a number from " + ogGuess + " to " + highGuess);
					do
					{
						guess = key.nextInt();
						a = x.inputValidation(guess, ogGuess, highGuess);
					} while( a != true);
					lowGuess = ogGuess;
					continue;
		
				}
				
				if (guess > num)
				{
			
					System.out.println("Your guess is too high, try again!");
					System.out.println("Enter a number from " + lowGuess +  " to " + ogGuess);
					do
					{
						guess = key.nextInt();
						a = x.inputValidation(guess, lowGuess, ogGuess);
					} while( a != true);
					
					highGuess = ogGuess;
					continue;
				}

			}
			
			//once the user guesses correctly, print finalizing statements then ask if the user wants to play again
			if (guess == num)
			{
				key.nextLine();
				System.out.println("Great job, you guessed correctly it only took you " + x.getCount() + " tries!");
				System.out.println("Would you like to try again? (yes/no)");
				yesno = key.nextLine();
				continue;
			}
			
			
			
			
			//test code, just here for reference
			/*
			if (guess == num)
			{
				System.out.println("Great job, you guessed correctly it only took you " + x.getCount() + " tries!");
				System.out.println("Would you like to try again? (yes/no)");
				yesno = key.nextLine();
				continue;
			}
			if (guess > num)
			{
				int ogGuess = guess;
				System.out.println("Your guess is too high, try again!");
				System.out.println("Enter a number from 0 to " + ogGuess);
				do
				{
					guess = key.nextInt();
					a = x.inputValidation(guess, 0, ogGuess);
				}while( a != true);
			}
			if (guess < num)
			{
				int ogGuess = guess;
				System.out.println("Your guess is too low, try again!");
				System.out.println("Enter a number from " + ogGuess + " to 100");
				do
				{
					guess = key.nextInt();
					a = x.inputValidation(guess, 110, ogGuess);
				}while( a != true);
			}
			*/
			
		} while(yesno.equalsIgnoreCase("yes"));
		
		//close out scanner and exit program
		key.close();
		System.exit(0);
	}

		
}
