import java.awt.Color;

/**
 * This class contains the relevant information for Square objects
 * @author Angus
 */
public class Square {
	
	protected int i;
	protected int j;
	
	final Color RED = new Color(255, 0, 0);
	
	/**
	 * Constructor creates a Square with the given position
	 * @param i the integer being used for y-axis placement
	 * @param j the integer being used for x-axis placement
	 */
	public Square(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	/**
	 * Constructor creates a Square with the default position of (0,0)
	 */
	public Square() {
		this.i = 0;
		this.j = 0;
	}
	
	/**
	 * Set the i-value of the Square
	 * @param i the integer being used for y-axis placement
	 */
	public void putI(int i) {
		this.i = i;
	}
	
	/**
	 * Set the j-value of the Square
	 * @param j the integer being used for x-axis placement
	 */
	public void putJ(int j) {
		this.j = j;
	}
	
	/**
	 * Get the i-value of the Square
	 * @return i value
	 */
	public int getI() {
		return this.i;
	}
	
	/**
	 * Get the j-value of the Square
	 * @return j value
	 */
	public int getJ() {
		return this.j;
	}
	
	/**
	 * Return the Square as a string
	 * @return the Square as a string value
	 */
	public String toString() {
		
		String result = "";
		
		result = String.valueOf(this.i) + " " + String.valueOf(this.j);
		
		return result;
	}
	
	/**
	 * Check if this Square is equal to the given Square
	 * @param s the Square being compared to
	 * @return true if the squares are equal, false if they are not
	 */
	public boolean equals(Square s) {
		
		if(this.getI() == s.getI() && this.getJ() == s.getJ())
			return true;
		else
			return false;
	}

}
