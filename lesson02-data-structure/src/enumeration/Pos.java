package enumeration;

public enum Pos {
	// enum name
	INSIDE("Trong"),
	ONSIDE("Tren"),
	OUTSIDE("Ngoai");

	String value;

	// construction, private as default access modifier
	Pos(String value) {
		this.value = value;
	}

}
