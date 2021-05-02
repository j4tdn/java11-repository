package data;

public class Digit {
	public int value;
	
	public Digit(int input) {
		
		//current reference
		this.value = input;
	}
	
	
	@Override
	public String toString() {
		
		return String.valueOf(value);
		// return "" + value;
		
	}
	

}
