package enumeration;

public enum Pos {
	INSIDE("trong"),
	ONSIDE("tren"),
	OUTSIDE("ngoai");
	
	public String value;
	
	//contructor, private as default access modifier
	Pos(String value){
		this.value = value;
	}
	
}
