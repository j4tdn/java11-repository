package ifelse.switchcase;

public enum Level {
	    GOOD("Gioi"),
		PRETTY_GOOD("Kha"),
		MEDIUM("Trung binh"),
		BAD("Yeu");
		
		public String value;
		//contructor
		Level(String value){
			this.value = value;
		}
}
