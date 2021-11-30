package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbManager {
	private static Connection connection;

	public static Connection getConnection() {

		if (connection == null) {
			Properties props = DbProvider.getProps();
			try {
				Class.forName(props.getProperty("DRIVER"));

				connection = DriverManager.getConnection(
						props.getProperty("URL"),
						props.getProperty("USENAME"),
						props.getProperty("PASSWORK"));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return connection;
	}

}
