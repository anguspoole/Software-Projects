
/**
 * This class creates and contains the relevant information for QueueExplorator objects
 * @author Angus
 *
 */
public class QueueExplorator implements Explorator{

	private QueueADT<Square> queue;
	
	/**
	 * Constructor creates a LinkedQueue of Square objects
	 */
	public QueueExplorator() {
		queue = new LinkedQueue<Square>();	
	}
	
	/**
	 * Empty the queue
	 */
	public void clear() {
		while(!queue.isEmpty())
			queue.dequeue();
	}
	
	/**
	 * Determine if the queue is empty
	 * @return true if the queue is empty, false if the queue is not
	 */
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	/**
	 * Obtain the next item in the queue
	 * @return the next item in the queue
	 */
	public Square getNext() {
		return queue.dequeue();
	}
	
	/**
	 * Add an item of type Square to the queue
	 * @param s Square object to be added to the queue
	 */
	public void add(Square s) {
		queue.enqueue(s);
	}
	
}
