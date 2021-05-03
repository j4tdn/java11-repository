package data;

public class Digit {
	// attribute
	public int value;
	
	// construtor: ham khoi tao, dung de khoi tao doi tuong, va tao 1 o nho o heap
	public Digit(int input) {
		// current reference
		this.value = input;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + value;
	}
}
