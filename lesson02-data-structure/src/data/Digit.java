package data;

public class Digit {
	// attributr
	public int value;
	public Digit(int input) {
		// current reference
		this.value = input;
	}
	@Override
	public String toString() {
		return "" + value;
	}

}
