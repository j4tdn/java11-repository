package singleton;

public class Sglc {

	private static Sglc instance;
	public static Sglc getInstance() {
		if(instance == null) {
			instance = new Sglc();
		}
		return instance;
	}
	private Sglc() {
		
	}
}
