package enumeration;

public enum Pos {
	//enum name
	INSIDE("tren"), 
	ONSIDE("trong"), 
	OUTSIDE("ngoai");

	public String value;

// constructor private as default
	Pos(String value) {
		this.value = value;
	}
}
