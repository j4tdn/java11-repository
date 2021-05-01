package enumeration;

public enum Pos {
	// enumeration name
	INSIDE("Trong"),
	ONSIDE("Tren"),
	OUTSIDE("Ngoai");
	
	public String value;
	
	// constructor, private as default access modifier
	Pos(String value) {
		this.value = value;
	}
}
