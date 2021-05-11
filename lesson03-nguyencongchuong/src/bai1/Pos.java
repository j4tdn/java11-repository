package bai1;

public enum Pos {
	INSIDE("Trong"),
	OUTSIDE("Ngoài"),
	ONSIDE("Trên");
	
	public String value;
	
	 Pos(String value) {
		this.value = value;
	}
}
