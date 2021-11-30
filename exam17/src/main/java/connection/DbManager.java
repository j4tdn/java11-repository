package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbManager {
	private static Connection connection;
	private static Properties props;

	public static Connection getConnection() {

		if (connection == null) {
			props = DbProvider.getProps();
			try {
				Class.forName(props.getProperty("DRIVER"));

				connection = DriverManager.getConnection(props.getProperty("URL"), props.getProperty("USER"),
						props.getProperty("PASS"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
