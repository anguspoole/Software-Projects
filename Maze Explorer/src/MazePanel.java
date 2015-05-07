import java.awt.*;
import javax.swing.*;

/**
 * This class creates and contains relevant information for the MazePanel class
 * @author Angus
 *
 */
public class MazePanel extends JPanel  {
  final int SQUARE_SIZE = 30;
  final Color GREY = new Color(200, 200, 200);

  private QueueADT<GraphicalObject> queue = new LinkedQueue<GraphicalObject>();

  /**
   * Add the given graphical object to the queue
   * @param obj graphical object to be added to the queue
   */
  void add(GraphicalObject obj){
	queue.enqueue(obj);
  }

  /**
   * Constructor creates MazePanel object of the given height and width
   * @param h height of the MazePanel object
   * @param w width of the MazePanel object
   */
  MazePanel(int h, int w){
    Dimension g = new Dimension(SQUARE_SIZE*w, SQUARE_SIZE*h);
    setPreferredSize(g);
    setBackground(GREY);
  }

  /**
   * Display all graphical objects in the queue, then re-enqueue them
   * @param g given graphics object used for displaying objects in the queue
   */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    for(int i=0; i < queue.size(); i++) {
    	GraphicalObject x;
    	x = queue.dequeue();
    	x.draw(g, SQUARE_SIZE);
    	add(x);
    }    
  }
}