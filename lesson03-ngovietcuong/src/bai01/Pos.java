package bai01;

public enum Pos {
   INSIDE("Trong"),
   OUTSIDE("Ngoai"),
   ONSIDE("Tren");
	
	public String value; 
	
	Pos(String value) {
		this.value = value;
	}
}
