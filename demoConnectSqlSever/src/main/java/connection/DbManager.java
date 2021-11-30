package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbManager {
	public static Connection connection;
	public static String DRIVER = "DRIVER";
	public static String USERNAME = "USERNAME";
	public static String PASSWORD = "PASSWORD";
	public static String URL = "URL";

	public static Connection getConnection() {
		Properties pops = DbProvider.getPops();
		if (connection == null) {
			try {
				Class.forName(pops.getProperty(DRIVER));
				connection = DriverManager.getConnection(
						pops.getProperty(URL),
						pops.getProperty(USERNAME),
						pops.getProperty(PASSWORD));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return connection;
	}
}