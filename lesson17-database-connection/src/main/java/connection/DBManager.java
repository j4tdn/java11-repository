package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBManager {
	private static Connection connection;
	
	public static Connection getConnection() {
		if (connection == null) {
			
			Properties props = DBProvider.getProperties();
			try {
				// 1. Provide driver
				Class.forName(props.getProperty("DRIVER"));

				// 2. Provide database info
				connection = DriverManager.getConnection(
						props.getProperty("URL"),
						props.getProperty("USERNAME"),
						props.getProperty("PASSWORD"));
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return connection;
	}
}