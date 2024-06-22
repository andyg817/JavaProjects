/*
 * Written by Andrew Garcia
 */
import java.util.Scanner;
public class RobotSimulatorFE {
	private static RobotSimulator rsim = new RobotSimulator();
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		boolean play = true;
		while(true)
		{
			beginning();
			end();
			String playA = keyboard.nextLine();
			if(playA.equalsIgnoreCase("True"))
				System.exit(0);
		}
	}
	public static void end()
	{
		System.out.println("Simulation End");
		System.out.println("Quit? Enter 'True' to quit or hit enter to run another simulation");
	}
	public static void beginning()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to the Robot Simulator");
		System.out.println("Enter file for the Board");
		String boardF = keyboard.nextLine();
		rsim.readMaze(boardF);
		System.out.println("Enter file for the Robot Commands");
		String commandF = keyboard.nextLine();
		rsim.readCom(commandF);
		rsim.printBoard();
		System.out.println("Simulation begin");
		rsim.move();
	}
}