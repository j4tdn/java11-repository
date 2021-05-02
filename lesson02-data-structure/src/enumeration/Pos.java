package enumeration;

public enum Pos {
	ONSIDE("TREN"),
	INSIDE("TRONG"),
	OUTSIDE("NGOAI");
	
	String value;
	
	// constructor , private as default access modifier
	Pos(String value){
		this.value = value;
	}
}
