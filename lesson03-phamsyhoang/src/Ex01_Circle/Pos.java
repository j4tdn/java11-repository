package Ex01_Circle;

public enum Pos {
	INSIDE("trong"),
	ONSIDE("trên"),
	OUTSIDE("ngoài");
	
	public String value;
	
	Pos(String value){
		this.value=value;
	}
}
