package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DbManager;
import persistence.Employee;

public class EmployeeImpl implements EmployeeDao{
	
	private Connection connection;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public EmployeeImpl() {
		connection = DbManager.getConnection();
	}
	
	private static final String Q_SIGN_UP = "INSERT INTO NhanVien";
	
	@Override
	public Employee signup(String username, String password) {
		
		
		return null;
	}
}
