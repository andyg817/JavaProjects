import java.io.File;
import java.util.Scanner;
/*
 * Written by Andrew Garcia
 */
public class RobotSimulator {
	public static final int MAZE_SIZE = 10;
	private char [][] maze;
	public static final char EMPTY = '_';
	public static final char OBST = 'X';
	public static final char ROBOT = 'O';
	public static final String MOVE_UP = "Move Up";
	public static final String MOVE_DOWN = "Move Down";
	public static final String MOVE_LEFT = "Move Left";
	public static final String MOVE_RIGHT = "Move Right";
	private int[] currLoc;
	LLQueue<String> com = new LLQueue<String>();
	public RobotSimulator()
	{
		this.init();
	}
	private void init()
	{
		maze = new char[MAZE_SIZE][MAZE_SIZE];
		for(int i=0;i<maze.length;i++)
			for(int j=0;j<maze.length;j++)
				maze[i][j] = EMPTY;
		currLoc = new int[] {0,0};
	}
	public void move()
	{
		maze[currLoc[0]][currLoc[1]] = EMPTY;
		int currY = currLoc[0];
		int currX = currLoc[1];
		for(int i=0;com.peek() != null;i++)
		{
			String word = com.dequeue();
			maze[currLoc[0]][currLoc[1]] = EMPTY;
			if(word.equalsIgnoreCase(MOVE_UP))
			{
				System.out.println("Command "+i);
				if(maze[currY-1][currX] != OBST)
				{
					currLoc[0]--;
					maze[currLoc[0]][currLoc[1]] = ROBOT;
					printBoard();
				}
				else if(maze[currY-1][currX] == OBST)
				{
					System.out.println("CRASH!");
					break;
				}
			}
			if(word.equalsIgnoreCase(MOVE_DOWN))
			{
				System.out.println("Command "+i);
				if(maze[currY+1][currX] != OBST)
				{
					currLoc[0]++;
					maze[currLoc[0]][currLoc[1]] = ROBOT;
					printBoard();
				}
				else if(maze[currY+1][currX] == OBST)
				{
					System.out.println("CRASH!");
					break;
				}
			}
			if(word.equalsIgnoreCase(MOVE_LEFT))
			{
				System.out.println("Command "+i);
				if(maze[currY][currX-1] != OBST)
				{
					currLoc[1]--;
					maze[currLoc[0]][currLoc[1]] = ROBOT;
					printBoard();
				}
				else if(maze[currY][currX-1] == OBST)
				{
					System.out.println("CRASH!");
					break;
				}
			}
			if(word.equalsIgnoreCase(MOVE_RIGHT))
			{
				System.out.println("Command "+i);
				if(maze[currY][currX+1] != OBST)
				{
					currLoc[1]++;
					maze[currLoc[0]][currLoc[1]] = ROBOT;
					printBoard();
				}
				else if(maze[currY][currX+1] == (OBST))
				{
					System.out.println("CRASH!");
					break;
				}
			}
		}
	}
	public void readCom(String filename)
	{
		com = new LLQueue<String>();
		try
		{
			Scanner scanner1 = new Scanner(new File(filename));
			while(scanner1.hasNextLine())
			{
				String command = scanner1.nextLine();
				com.enqueue(command); 
			}
			scanner1.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void readMaze(String filename)
	{
		init();
		try
		{
			Scanner scanner1 = new Scanner(new File(filename));
			while(scanner1.hasNext())
			{
				for(int i=0;i<maze.length;i++)
				{
					String fileL = scanner1.nextLine();
					maze[i] = fileL.toCharArray();
					maze[0][0] = ROBOT;
				} 
			}
			scanner1.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void printBoard()
	{
		for(int i=0;i<maze.length;i++)
		{
			for(int j=0;j<maze.length;j++)
				System.out.print(maze[i][j]);
		System.out.println();
		}
	}
}