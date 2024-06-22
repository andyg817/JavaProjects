/*
 * Writen by Andrew Garcia
 */
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class ShowcaseGame {
	private static Showcase showcase = new Showcase();

	private static final String FILE_NAME = "./prizeList.txt";
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
			String play = " ";
			do 
			{
				System.out.println("Welcome to the showcase show down!");
				System.out.println("Your Prizes are: ");
				showcase.readFile(FILE_NAME);
				showcase.getRand();
				System.out.println("You must guess the total cost of all without going over \nEnter your guess");
				int guess = keyboard.nextInt();
				keyboard.nextLine();
				System.out.println("Your guess was "+guess+" the actual price is "+showcase.getPrice());
				if(guess <= showcase.getPrice() && guess >= showcase.getPrice()-2000)
				{
					System.out.println("Your guess was under! You win!");
				}
				else if(guess > showcase.getPrice())
				{
					System.out.println("Your guess was over! You lose!");
				}
				else
					System.out.println("Your guess was bad! You lose!");
				System.out.println("Would you like to play again? Enter 'no' to quit");
				play = keyboard.nextLine();
			}while(!play.equalsIgnoreCase("no"));
	}
}
