package enumeration;

public enum Pos {
	//Pos: enumaration name
	INSIDE("Trong"),
	OUTSIDE("Tren"),
	ONSIDE("Ngoai");
	
	public String value;
	
	//create: contructor, private as default access modifier
	Pos(String value) {
		this.value = value;
	}
	

}