package data;

/**
 * Same as Integer
 * @author qphan
 *
 */
public class Digit {
	// attribute
	public int value;
	
	// constructor
	public Digit(int input) {
		// current reference
		this.value = input;
	}
	
	@Override
	public String toString() {
		return "" + value;
	}
}
