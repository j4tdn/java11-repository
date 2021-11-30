package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {
	
	private static Connection connection;
	private static String URL = "URL";
	private static String DRIVER = "DRIVER";
	private static String USER = "USER";
	private static String PASS = "PASS";
	
	public static Connection getConnection() {
		if(connection == null) {
			Properties props = DBProvider.getProps();
			try {
				Class.forName(props.getProperty(DRIVER));
				connection = DriverManager.getConnection(
						props.getProperty(URL), 
						props.getProperty(USER), 
						props.getProperty(PASS)
				);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
