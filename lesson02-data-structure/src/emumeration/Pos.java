package emumeration;

public enum Pos {
	//enumeration name
	INSIDE("Trong"),
	ONSIDE("Tren"),
	OUTSIDE("Ngoai");
	
	public String value;
	
	Pos(String value){
		this.value = value;
	}

}
