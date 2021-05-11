package ex01;

public enum Pos {
	ONSIDE("trong"),
	OUTSIDE("ngoai"),
	INSIDE("tren");
	
	public String value;
	
	Pos(String value){
		this.value =value;
	}
}
