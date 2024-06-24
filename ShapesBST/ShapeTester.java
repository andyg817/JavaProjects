/*
 * Wrtten by Andrew Garcia
 */
import java.util.*;
import java.io.*;
public class ShapeTester {

	public static void main(String[] args) {
		System.out.println("Welcome to the shape tree tester!\nReading from file");
		LinkedBST<Shape> shapeTree = new LinkedBST<Shape>();
		try 
		{
			Scanner fileScanner = new Scanner(new File("shapeFile.txt"));
			while(fileScanner.hasNextLine())
			{
				String currLine = fileScanner.nextLine();
				String[] splitLine = currLine.split("\t");
				if(splitLine.length >= 2)
				{
					Shape s = new Shape(Double.parseDouble(splitLine[1]),splitLine[0]);
					shapeTree.add(s);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("\nPrinting pre-order");
		shapeTree.printPreorder();
		System.out.println("\nPrinting in-order");
		shapeTree.printInorder();
		System.out.println("\nPrinting post-order");
		shapeTree.printPostorder();
		System.out.println("\nThe max area is: ");
		System.out.println("\nDeleting Rectangle Side 1: 2.0 Side2: 7.0 Area: 14.0");
		System.out.println("\nDeleting values larger then 30");
	}
}
