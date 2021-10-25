import java.util.Scanner;

public class MovieDriver {

	public static void main(String[] args) {

		String yesno = "no";
		Scanner keyboard = new Scanner(System.in);
		do 
		{
			
			Movie x = new Movie();
			
			System.out.println("Enter name of movie: ");
			String name = keyboard.nextLine();
			x.setTitle(name);
			
			System.out.println("Enter rating of movie (x/10): ");
			String rating = keyboard.nextLine();
			x.setRating(rating);
			
			System.out.println("Enter number of tickets sold at theatre: ");
			int tix = keyboard.nextInt();
			x.setSoldTickets(tix);
			keyboard.nextLine();
	
			System.out.println(x.toString());
			
			System.out.println("Would you like to enter another movie? (yes/no)");
			yesno = keyboard.nextLine();
			System.out.println(yesno);
			
			
		} while(yesno.equals("yes")  || yesno.equals("Yes"));
		
		keyboard.close();
	}

}
