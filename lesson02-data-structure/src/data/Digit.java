package data;

public class Digit {
	//attribue
	public int value;
	
	//constructor: ham khoi tao, tao doi tuong o heap
	public Digit(int input) {
		//current reference
		this.value = input;
	}
public String toString() {
	return "" + value;
}
}
