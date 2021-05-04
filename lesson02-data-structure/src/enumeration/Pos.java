package enumeration;

public enum Pos {
	
	INSIDE("TRONG"),
	ONSIDE("TREN"),
	OUTSIDE("NGOAI");
	public String Value;
	
	Pos(String Value){
		this.Value = Value;
	}

}
