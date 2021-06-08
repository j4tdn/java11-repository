package singleton;

/**
 * Singleton is a creation design pattern that lets you ensure that a class has only one instance, 
 * while providing a global access point to this instance
 */
public class Sglc {
	
	private static Sglc instance = null;
	
	private String value;
	
	public static Sglc getInstance() {
		if (instance == null) {
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
