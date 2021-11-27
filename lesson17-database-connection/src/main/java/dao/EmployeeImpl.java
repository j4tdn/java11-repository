package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;

import connection.DbManager;
import persistence.Employee;
import utils.SqlUtils;

public class EmployeeImpl implements EmployeeDao {

	private Connection connection;
	private PreparedStatement pst;
	private ResultSet rs;

	public EmployeeImpl() {
		connection = DbManager.getConnection();
	}

	private static final String DEFAULT_STRING = "EMPTY";
	private static final String DEFAULT_INT = "1";
	private static final String Q_SIGN_UP = 
			  "INSERT INTO NhanVien(TenNV, Email, SDT, DiaChi, MatKhau, MaCV)\n"
			+ "VALUES(?, ?, ?, ?, ?, ?)";
	private static final String Q_SIGN_IN = 
			  "SELECT MaNV " + Employee.ID + ",\n"
			+ "       TenNV" + Employee.NAME + ",\n"
			+ "       Email" + Employee.PHONE + ",\n"
			+ "       SDT" 	 + Employee.ADDRESS + "\n"
			+ "FROM NhanVien\n"
			+ "WHERE email = ?\n"
			+ "AND MatKhau = ?";
	@Override
	public Employee signup(String email, String password) {
		int affectedRows = 0;
		String encryptedPassword = DigestUtils.md5Hex(password);
		try {
			// get generated key
			pst = connection.prepareStatement(Q_SIGN_UP, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, DEFAULT_STRING);
			pst.setString(2, email);
			pst.setString(3, DEFAULT_STRING);
			pst.setString(4, DEFAULT_STRING);
			pst.setString(5, encryptedPassword);
			pst.setString(6, DEFAULT_INT);

			affectedRows = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(pst);
		}
		if (affectedRows > 0) {
			int generatedKey = SqlUtils.getGeneratedKey(pst);
			return new Employee(generatedKey, DEFAULT_STRING, email, DEFAULT_STRING, DEFAULT_STRING, encryptedPassword);
		}
		return null;
	}

	@Override
	public Employee signin(String email, String password) {
		Employee result = null;
		try {
			pst = connection.prepareStatement(Q_SIGN_IN);
			pst.setString(1, email);
			pst.setString(2, DigestUtils.md5Hex(password));
			rs = pst.executeQuery();
			if (rs.next()) {
				result = Employee.addResultTransformer(rs, email, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(pst);
		}
		return result;
	}

}
