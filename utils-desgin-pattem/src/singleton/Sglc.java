package singleton;

public class Sglc {
	private String value;
	
	
	
	private static Sglc instance  = null;
	
	public static Sglc getIntance() {
		if(instance == null) {
			instance = new Sglc();
		}
		return instance;
	}
	
	
	private Sglc() {
		
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
