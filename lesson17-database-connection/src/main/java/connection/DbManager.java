package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbManager {

	private static Connection connection;

	public static Connection getConnection() {
		if (connection == null) {
			try {
				Properties props = DbProvider.getProps();
				Class.forName(props.getProperty("DRIVER"));
				connection = DriverManager.getConnection(props.getProperty("URL"), props.getProperty("USERNAME"),
						props.getProperty("PASSWORD"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}