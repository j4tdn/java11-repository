package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbManager {
	private static Connection con = null;

	public static Connection getConnection() {
		if (con == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java11_shopping", "root", "huunghia1111");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
}
