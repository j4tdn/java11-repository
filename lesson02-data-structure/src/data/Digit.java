package data;

public class Digit {
//	attribute (thuoc tinh cua doi tuong)
	public int value;
	
//	construction (ham khoi tao, truong hop nay la ham khoi tao o nho o Heap)
	public Digit (int input) {
//		current reference (tham chieu hien tai)
		this.value = input;
	}
	
	@Override
		public String toString() {
			return "" + value;
		}

}
