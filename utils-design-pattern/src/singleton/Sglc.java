package singleton;

/**
 * Singleton is a creational design pattern that lets you ensure that a class has only one instance, 
 * while providing a global access point to this instance
 */
public class Sglc {
	
	private String Value;

	private static Sglc instance;
	public static Sglc getInstance() {
		if(instance == null) {
			instance = new Sglc();
		}
		return instance;
	}
	private Sglc() {
		
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
}
