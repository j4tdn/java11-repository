package singleton;

/*
 * Singleton pattern: class has only one instance
 * Follow Java Calendar class
 */
public class DateTimeHelper {

	private static DateTimeHelper instance = null;

	private DateTimeHelper() {

	}

	public static DateTimeHelper getInstance() {
		if (instance == null) {
			instance = new DateTimeHelper();
		}
		return instance;
	}
}
