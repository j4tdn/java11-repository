package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;

import connection.DBManager;
import persistence.Employee;
import utils.SqlUtils;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private Connection connection;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public EmployeeDaoImpl() {
		connection = DBManager.getConnection();
	}
	
	private static final String DEFAULT = "EMPTY";
	private static final int DEFAULT_INT = 1;
	private static final String Q_SIGN_UP = 
			"INSERT INTO NhanVien(TenNV, Email, SDT, DiaChi, MatKhau, MaCV)\n"
			+ "VALUES(?,?,?,?,?,?)";
	
	private static final String Q_SIGN_IN = 
			"SELECT MaNV " + Employee.ID + " \n"
			+ ", TenNV " + Employee.NAME + " \n"
			+ ", Email " + Employee.EMAIL + " \n"
			+ ", SDT " + Employee.PHONE + " \n"
			+ ", DiaChi " + Employee.ADDRESS + " \n"
			+ "FROM NhanVien \n"
			+ "Where Email = ? and MatKhau = ?";
	
	@Override
	public Employee signUp(String email, String password) {
		int affected = 0;
		try {
			// get generated key
			pst = connection.prepareStatement(Q_SIGN_UP, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, DEFAULT);
			pst.setString(2, email);
			pst.setString(3, DEFAULT);
			pst.setString(4, DEFAULT);
			pst.setString(5, DigestUtils.md5Hex(password));
			pst.setInt(6, DEFAULT_INT);
			
			affected = pst.executeUpdate();
			
			if(affected > 0) {
				int generatedKey = SqlUtils.getGeneratedKey(pst);
				return new Employee(generatedKey, DEFAULT, email, DEFAULT, DEFAULT, password);
			}

		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("Account " + email + " be exist");
		} finally {
			SqlUtils.close(pst);
		}
		
		return null;
	}

	@Override
	public Employee signIn(String username, String password) {
		Employee result  = null;
		try {
			pst = connection.prepareStatement(Q_SIGN_IN);
			pst.setString(1, username);
			pst.setString(2, DigestUtils.md5Hex(password));
			rs = pst.executeQuery();
			if(rs.next()) {
				result = Employee.addResultTransformer(rs, username, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}
}
