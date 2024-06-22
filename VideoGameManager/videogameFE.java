import java.util.Scanner;

/*
 * Written by Andrew Garcia
 */
public class videogameFE {
	private static videogameManager vgManager = new videogameManager();
	private static String FILE_NAME = "./gameList.txt";
	public static void main(String[] args) {
		String choice = "9";
		while(choice != "0")
		{
			Scanner keyboard = new Scanner(System.in);
			printGreeting();
			choice = keyboard.nextLine();
			if(choice.equals("1"))
				loadDatabase();
			else if(choice.equals("2"))
				searchDatabase();
			else if(choice.equals("3"))
				printDatabase();
			else if(choice.equals("4"))
				printFile();
			else
			{
				System.out.println("Goodbye!");
				System.exit(0);
			}
		}
	}
	public static void printGreeting()
	{
		System.out.println("Welcome to the video game database!");
		System.out.println("Enter 1 to load the video game database");
		System.out.println("Enter 2 to search the database");
		System.out.println("Enter 3 to print current database");
		System.out.println("Enter 4 to print current results to file");
		System.out.println("Enter 0 to quit");
	}
	public static void loadDatabase()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the name of the file");
		String filename = keyboard.nextLine();
		vgManager.readFile(filename);
	}
	public static void searchDatabase()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the name of the game or '*' for all names");
		String game = keyboard.nextLine();
		System.out.println("Enter the name of the console or '*' for all consoles");
		String console = keyboard.nextLine();
		vgManager.searchFile(game, console);
	}
	public static void printDatabase()
	{
		vgManager.print();
	}
	public static void printFile()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the file name to print out");
		String filename = keyboard.nextLine();
		System.out.println("Append to file? True or False");
		boolean ap = keyboard.nextBoolean();
		vgManager.writeFile(filename, ap);
	}
}
