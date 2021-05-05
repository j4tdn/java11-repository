package enumeration;

public enum Pos {
	//enum name
		INSIDE("Tren"),
		ONSIDE("Trong"),
		OUTSIDE("Ngoai");
		
		public String value;
		
		Pos(String value){
			this.value=value;
		}

}
