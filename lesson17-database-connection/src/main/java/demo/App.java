package demo;

import java.sql.Connection;

import connection.DbManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Connection connection=DbManager.getConnection();
        System.out.println(connection);
    }
}
