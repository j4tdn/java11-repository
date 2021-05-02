package data;

public class Digit {
	// attribute
	public int value;

	public Digit(int Input) {
		// current reference
		this.value = Input;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
