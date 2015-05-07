/*
 * Stack and Queue Maze Explore Program
 * Some code was provided by UWO Computer Science Department
 */

public class Test 
{
	public static void main(String[] args){
		Maze maze = new Maze("maze1.txt");
		Explorator s = new StackExplorator();
		System.out.println("Reached the exit using the Stack explore method: " + maze.explore(s));
		Explorator q = new QueueExplorator();
		System.out.println("Reached the exit using the Queue explore method: " + maze.explore(q));
	}
}
