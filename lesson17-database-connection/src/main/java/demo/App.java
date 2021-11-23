package demo;

import java.sql.Connection;
import java.util.Properties;

import connection.DbManager;
import connection.DbProvider;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Connection connection = DbManager.getConnection();
    	System.out.println("connection : "+ connection);
    	
    	Properties pros = DbProvider.getPros();
    	System.out.println("props" + pros);
    }
}
