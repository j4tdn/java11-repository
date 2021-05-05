package enumeration;

public enum Pos {
    INSIDE("Trong"),
	ONSIDE("Tren"),
	OUTSIDE("Ngoai");
	
	public String value;
	//contructor
	Pos(String value){
		this.value = value;
	}
	
}
