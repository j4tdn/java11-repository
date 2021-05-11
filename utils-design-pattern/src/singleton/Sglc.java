package singleton;

/**
 * The builder pattern, as name implies, is an alternative way to construct
 * complex objects. This should be used only when you want to build different
 * immutable objects using same object building process
 *
 */
public class Sglc {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private static Sglc instance = null;

	public static Sglc getInstance() {
		if (instance == null) {
			instance = new Sglc();
		}
		return instance;
	}

	private Sglc() {

	}
}
