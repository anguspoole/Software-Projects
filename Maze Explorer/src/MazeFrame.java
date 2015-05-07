import java.awt.*;
import javax.swing.*;

/**
 * This class contains the relevant information for the MazeFrame class, which pertains to the whole window
 * @author Angus
 *
 */
public class MazeFrame extends JFrame{
  final static Color BLACK = new Color(0, 0, 0);
  final static Color WHITE = new Color(255, 255, 255);
  final static Color RED = new Color(255, 0, 0);
  final static Color GREEN = new Color(0, 255, 0);
  final static Color BLUE = new Color(0, 0, 255);

  private MazePanel panel;

  /**
   * Add a new graphical object to the MazePanel list
   * @param obj the given graphical object
   */
  void add(GraphicalObject obj){
    panel.add(obj);
    repaint();    
  }
  
  /**
   * Constructor creates a MazeFrame using the given Maze
   * @param maze the Maze object
   */
  MazeFrame(Maze maze){
    super("Maze");  
    
    int h = maze.getHeight();
    int w = maze.getWidth();

    panel = new MazePanel(h, w);  
    add(panel);  

    // your code here for drawing the maze
    int i = 0;
    int j = 0;
    
    for(i=0; i < h; i++) {
    	for (j=0; j < w; j++) {
    	    if(maze.isFree(i, j)) {
                SquareObject s = new SquareObject(WHITE, i, j);
                panel.add(s); 
    	    }
    	    else {
    	    	SquareObject s = new SquareObject(BLACK, i, j);
    	    	panel.add(s);
    	    }
    	}
    }
    
    // create the starting Square's graphic
    i = maze.getStart().getI();
    j = maze.getStart().getJ();
    SquareObject start = new SquareObject(GREEN, i, j);
    add(start);
    
    // create the exit Square's graphic
    i = maze.getExit().getI();
    j = maze.getExit().getJ();
    SquareObject exit = new SquareObject(BLUE, i, j);
    add(exit);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    pack();
    setResizable(false);
    setVisible(true);
    repaint();
  }
}