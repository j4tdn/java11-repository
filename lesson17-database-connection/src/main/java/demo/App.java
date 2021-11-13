package demo;

import connection.DbManager;
import connection.DbProvider;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		 System.out.println(DbManager.getConnection());
		System.out.println(DbProvider.getProps());
	}
}
