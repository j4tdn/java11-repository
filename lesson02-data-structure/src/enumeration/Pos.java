package enumeration;

public enum Pos {
	//enum name
	INSIDE("Trong"), 
	ONSIDE("Tren"),
	OUTSIDE("Ngoai");
	
	public String value;
	
	Pos(String value){
		this.value=value;
	}
}
