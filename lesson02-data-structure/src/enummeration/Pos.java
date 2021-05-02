package enummeration;

public enum Pos {
	// enumeration name
	INSIDE("Trong"), ONSIDE("Tren"), OUTSIDE("Ngoai");

	String value;

	// constructor, private as default access modifier
	Pos(String value) {
		this.value = value;

	}

}
