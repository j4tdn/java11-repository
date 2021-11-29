package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;

import connection.DbManager;
import persistence.Employee;
import persistence.Item;
import persistence.ItemGroup;
import utils.sqlUtils;

public class EmployeeDaoImpl implements EmployeeDao {
	private final Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	public EmployeeDaoImpl() {
		con = DbManager.getConnection();
	}

	private static final String DEFAULT = "EMPTY";
	private static final int DEFAULT_INT = 1;
	private static final String Q_SIGN_UP = "insert into nhanvien(tennv,email,sdt,diachi,matkhau,macv) values(?,?,?,?,?,?)";
	private static final String Q_SIGN_IN = "select * from nhanvien where email = ? and matkhau = ?";

	@Override
	public Employee signup(String email, String password) {
		boolean isSign = false;

		try {
			pst = con.prepareStatement(Q_SIGN_UP, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, DEFAULT);
			pst.setString(2, email);
			pst.setString(3, DEFAULT);
			pst.setString(4, DEFAULT);
			pst.setString(5, DigestUtils.md5Hex(password));
			pst.setInt(6, DEFAULT_INT);
			isSign = pst.executeUpdate() > 0;
			if (isSign) {
				return isSign ? new Employee(sqlUtils.getGeneratedKey(pst), DEFAULT, email, DEFAULT, DEFAULT, password)
						: null;
			}
		} catch (SQLException e) {
			System.out.println("email already existed !!");
		} finally {
			sqlUtils.close(pst);
		}

		return null;

	}

	@Override
	public Employee signin(String email, String password) {
		Employee employee = null;

		try {
			pst = con.prepareStatement(Q_SIGN_IN);
			pst.setString(1, email);
			pst.setString(2, DigestUtils.md5Hex(password));
			rs = pst.executeQuery();
			if (rs.next()) {

				employee = Employee.addResultTransformer(rs);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlUtils.close(rs, pst);
		}

		return employee;
	}
}
