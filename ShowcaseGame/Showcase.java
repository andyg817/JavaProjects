/*
 * Written by Andrew Garcia
 */
import java.util.Scanner;
import java.io.*;
import java.util.Random;
public class Showcase 
{
	private Prize[] prize1;
	private static final String DELIM = "\t";
	private static final int DEF_SIZE = 50;
	private static final int DELIM_AMT = 1;
	private int sum = 0;
	private static Scanner keyboard = new Scanner(System.in);
	
	public Showcase()
	{
		init(DEF_SIZE);
	}
	public Showcase(int size)
	{
		init(size);
	}
	public void init(int size)
	{
		if(size >= 1)
			prize1 = new Prize[size];
		else
			prize1 = new Prize[DEF_SIZE];
	}
	public void addPrize(Prize aPrize)
	{
		
		if(prize1[prize1.length-1] != null)
			return;
		for(int i=0;i<prize1.length;i++)
		{
			if(prize1[i] == null)
			{
				prize1[i] = aPrize;
				break;
			}
		}
	}
	public Prize[] getRand()
	{
		Prize[] arr = new Prize[5];
		int v = 0;
		Random rndm = new Random();
		for(int i=0;i<arr.length;i++)
		{
			v = rndm.nextInt(50)%50;
			arr[i] = prize1[v];
			sum += arr[i].getPrice();
		}
		for(Prize prize : arr)
		{
			if(prize == null)
				break;
			System.out.println(prize);
		}
		return arr;
	}
	public int getPrice()
	{
		return sum;
	}
	public void readFile(String aName)
	{
		try
		{
			Scanner scanner1 = new Scanner(new File(aName));
			String fileL = scanner1.nextLine();
			String[] splitL = fileL.split(DELIM);
			if(splitL.length > DELIM_AMT)
			{
				int size = Integer.parseInt(splitL[1]);
				init(size);
			}
			else
				return;
			while(scanner1.hasNextLine())
			{
				fileL = scanner1.nextLine();
				splitL = fileL.split(DELIM);
				if(splitL.length > DELIM_AMT)
				{
					String name = splitL[0];
					double price = Double.parseDouble(splitL[1]);
					Prize aPrize = new Prize(name,price);
					this.addPrize(aPrize);
				}
			}
			scanner1.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
