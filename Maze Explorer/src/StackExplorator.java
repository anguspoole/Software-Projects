/**
 * This class creates and contains relevant information for StackExplorator objects
 * @author Angus
 *
 */
public class StackExplorator implements Explorator {
	
	private StackADT<Square> stack;
	
	/**
	 * Constructor creates a LinkedStack of Square objects
	 */
	public StackExplorator() {
		stack = new LinkedStack<Square>();	
	}
	
	/**
	 * Empty the stack
	 */
	public void clear() {
		while (stack.size() > 0)
			stack.pop();
	}
	
	/**
	 * Determines if the stack is empty
	 * @return true if the stack is empty, false if it is not
	 */
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	/**
	 * Obtain the next item in the stack
	 * @return the next item in the stack
	 */
	public Square getNext() {
		return stack.pop();
	}
	
	/**
	 * Add a Square object to the stack
	 * @param s Square object to be added to the stack
	 */
	public void add(Square s) {
		stack.push(s);
	}
}
