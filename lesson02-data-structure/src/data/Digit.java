package data;

public class Digit {
	//attribute
	public int value;
	
	public Digit(int input) {
		//current reference
		this.value = input;
	}
	
	@Override //constructor
	public String toString() {
		// TODO Auto-generated method stub
		return "" + value;
	}
}
