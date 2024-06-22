import java.io.*;
import java.util.Scanner;

/*
 * Written by Andrew Garcia
 */
public class videogameManager {
	private static final String DELIM = "\t";
	private static final int DELIM_AMT = 1;
	private static Scanner keyboard = new Scanner(System.in);
	GenL<videogame> game = new GenL<videogame>();
	GenL<videogame> newList = new GenL<videogame>();
	
	public void searchFile(String aName, String aConsole)
	{
		try
		{
			newList = new GenL<videogame>();
			game.reset();
			while(game.hasMore())
			{
				videogame game2 = game.getCurrent();
				String name = game2.getName();
				String console = game2.getConsole();
				if(aName.equals("*") && console.toUpperCase().contains(aConsole.toUpperCase()))
				{
					videogame bruh = new videogame(game2.getName(), game2.getConsole());
					newList.add(bruh);
				}
				else if(aConsole.equals("*") && name.toUpperCase().contains(aName.toUpperCase()))
				{
					videogame whip = new videogame(game2.getName(), game2.getConsole());
					newList.add(whip);
				}
				else if(aName.equals("*") && aConsole.equals("*"))
				{
					videogame naenae = new videogame(game2.getName(), game2.getConsole());
					newList.add(naenae);
				}
				else if(name.toUpperCase().contains(aName.toUpperCase()) && console.toUpperCase().contains(aConsole.toUpperCase()))
				{
					videogame game1 = new videogame(game2.getName(), game2.getConsole());
					newList.add(game1);
				}
				game.gotoNext();
			}
			newList.print();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void readFile(String filename)
	{
		try
		{
			game = new GenL<videogame>();
			Scanner scanner1 = new Scanner(new File(filename));
			while(scanner1.hasNextLine())
			{
				String fileL = scanner1.nextLine();
				String[] splitL = fileL.split(DELIM);
				if(splitL.length > DELIM_AMT)
				{
					String name = splitL[0];
					String console = splitL[1];
					videogame game1 = new videogame(name, console);
					game.add(game1);
				}
			}
			scanner1.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void print()
	{
		game.print();
	}
	public void writeFile(String aName, boolean aAppend)
	{
		try
		{
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aName));
			newList.reset();
			fileWriter.println(newList);
			while(newList.hasMore())
			{
				fileWriter.println(newList.getCurrent().getName()+DELIM+newList.getCurrent().getConsole());
				newList.gotoNext();
			}
			if(aAppend)
			{
				PrintWriter filewriter = new PrintWriter(new FileOutputStream(aName), aAppend);
				filewriter.close();
			}
			fileWriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}