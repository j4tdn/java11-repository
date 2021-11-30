package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBManager {
	private static Connection connection;
	
	public static Connection getConnection() {
		if (connection == null) {
			
			Properties properties = DBProvider.getProperties();
			try {
				// 1. Provide driver
				Class.forName(properties.getProperty("DRIVER"));

				// 2. Provide database info
				connection = DriverManager.getConnection(
						properties.getProperty("URL"),
						properties.getProperty("USERNAME"),
						properties.getProperty("PASSWORD"));
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return connection;
	}
}
