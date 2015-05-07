import java.awt.*;

import javax.swing.*;

/**
 * This class contains the relevant information for Maze objects
 * @author Angus
 */
public class Maze
{
	
	private int h, w;
	private boolean[][] maze;
	private boolean[][] visited;
	private Square start;
	private Square exit;
	
	/**
	 * The Constructor for Maze objects
	 * @param fileName the file from which Maze object data is obtained
	 */
	public Maze(String fileName)
	{
		
		InStringFile reader = new InStringFile(fileName);
		System.out.println("Reading from file " + fileName + "/n");
		
		String line;
		int i = 0;
		int j = 0;

		// read data from the file to obtain the height and width of the maze
		line = reader.read();
		h = Integer.parseInt(line);
		line = reader.read();
		w = Integer.parseInt(line);
		maze = new boolean[h][w];
		
		// read data from the file to obtain the start of the maze
		line = reader.read();
		i = Integer.parseInt(line);
		line = reader.read();
		j = Integer.parseInt(line);
		start = new Square(i, j);
		
		// read data from the file to obtain the exit of the maze
		line = reader.read();
		i = Integer.parseInt(line);
		line = reader.read();
		j = Integer.parseInt(line);
		exit = new Square(i, j);
		
		i = 0;
		j = 0;
		
		// determine the free squares from the maze squares
		do
		{
			line = reader.read();
			for(j = 0; j < line.length(); j++) 
			{
				if (line.charAt(j) == '0')
					maze[i][j] = true;
				else
					maze[i][j] = false;
			}
			
			j = 0;
			i++;
			
		} while (!reader.endOfFile());
		reader.close();
	}
	
	/**
	 * Get the Maze's starting Square 
	 * @return the Maze's starting Square
	 */
	public Square getStart()
	{
		return start;
	}
	
	/**
	 * Get the Maze's exit Square
	 * @return the Maze's exit Square
	 */
	public Square getExit()
	{
		return exit;
	}
	
	/**
	 * Get the height of the Maze
	 * @return height of the Maze
	 */
	public int getHeight()
	{
		return h;
	}
	
	/**
	 * Get the width of the Maze
	 * @return the width of the Maze
	 */
	public int getWidth()
	{
		return w;
	}
	
	/**
	 * Determine if the Square at the given location is free
	 * @param i the y-coordinate for the square
	 * @param j the x-coordinate for the square
	 * @return true if the square is not a wall, false if it is
	 */
	public boolean isFree(int i, int j)
	{
		return !maze[i][j];
	}
	
	/**
	 * Explore the maze, from the start to the exit Squares, showing through animation the pathways taken
	 * @param e the Explorator interface being used to move through the maze
	 * @return true if the exit is found, false otherwise
	 */
	public boolean explore(Explorator e)
	{
		
		visited = new boolean[h][w];
		int i = 0;
		int j = 0;
		Square t = new Square();
	    MazeFrame frame = new MazeFrame(this);	    
	    
	    SquareLeft sl;
	    SquareRight sr;
	    SquareDown sd;
	    SquareUp su;
	    
		e.add(start);
			
		for (int x=0; x < h; x++) {
			for (int y = 0; y < w; y++) {
				visited[x][y] = false;				
			}
		}
		
	    while(e.isEmpty()!=true)
	    {
	    	t=e.getNext();
	    	i = t.getI();
	    	j = t.getJ();
	    	
	    	if (t.equals(getExit())) {
		    	e.clear();
		    	return true;
		    	}
		    
		    if (i == 0 && j != 0 && j < w - 1) {
			   	if (isFree(i+1, j) && !visited[i+1][j]) {
			   		e.add(sd = new SquareDown(i+1, j));
			   		frame.add(sd.step());
			   		pause(100);
			   	}
			   	if (isFree(i, j+1) && !visited[i][j+1]) {
			   		e.add(sr = new SquareRight(i, j+1));			   		
			   		frame.add(sr.step());
			   		pause(100);
			   	}

			   	if (isFree(i, j-1) && !visited[i][j-1]) {
			   		e.add(sl = new SquareLeft(i, j-1));	
			   		frame.add(sl.step());
			   		pause(100);
			   	}
			   		
		    }
		    
		    if (i != 0 && j == 0 && i < h-1) {
			   	if (isFree(i+1, j) && !visited[i+1][j]) {
			   		e.add(sd = new SquareDown(i+1, j));
			   		frame.add(sd.step());
			   		pause(100);
			   	}
			   	if (isFree(i, j+1) && !visited[i][j+1]) {
			   		e.add(sr = new SquareRight(i, j+1));
			   		frame.add(sr.step());
			   		pause(100);
			   	}
			   	if (isFree(i-1, j) && !visited[i-1][j]) {
			   		e.add(su = new SquareUp(i-1, j));
			   		frame.add(su.step());
			   		pause(100);
			   	}
		    }
		    
		    if (i == 0 && j == 0) {
		    	if (isFree(i+1, j) && !visited[i+1][j]) {
		    		e.add(sd = new SquareDown(i+1, j));
		    		frame.add(sd.step());
		    		pause(100);
		    	}
			   	if (isFree(i, j+1) && !visited[i][j+1]) {
			   		e.add(sr = new SquareRight(i, j+1));
			   		frame.add(sr.step());
			   		pause(100);
			   	}
		    }
		    	
		    if (i != 0 && j != 0 && i < h-1 && j < w) {
		    	if (isFree(i+1, j) && !visited[i+1][j]) {
		    		e.add(sd = new SquareDown(i+1, j));
		    		frame.add(sd.step());
		    		pause(100);
		    	}
			   	if (isFree(i, j+1) && !visited[i][j+1]) {
			   		e.add(sr = new SquareRight(i, j+1));
			   		frame.add(sr.step());
			   		pause(100);
			   	}
			   	if (isFree(i-1, j) && !visited[i-1][j]) {
			   		e.add(su = new SquareUp(i-1, j));
			   		frame.add(su.step());
			   		pause(100);
			   	}			   		
			   	if (isFree(i, j-1) && !visited[i][j-1]) {
			   		e.add(sl = new SquareLeft(i, j-1));
			   		frame.add(sl.step());
			   		pause(100);
			   	}
		    }	
	    	visited[i][j] = true;
	    }
	    return false;
	}
	
	/**
	 * Pause the animation for a moment
	 * @param i how many milliseconds the animation should pause for
	 */
	static void pause (int i) {
	    try {
	      Thread.sleep(i);
	    } catch (InterruptedException e) { }
	  }

}
