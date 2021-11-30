package demo;

import java.sql.Connection;

import connection.DbManager;

public class App {
	public static Connection connection;
	
	static {
		connection = DbManager.getConnection();
	}
	public static void main(String[] args) {
		System.out.println("connection : " + connection);
	}
}