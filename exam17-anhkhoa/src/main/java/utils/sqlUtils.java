package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class sqlUtils {
	private sqlUtils() {

	}

	public static void close(AutoCloseable... autoCloseables) {
		for (AutoCloseable item : autoCloseables) {
			if (item != null)
				try {
					item.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

	public static <element> void print(List<element> list) {
		for (element item : list) {
			System.out.println(item);
		}
	}

	public static Integer getGeneratedKey(PreparedStatement pst) {
		ResultSet rs;
		try {
			rs = pst.getGeneratedKeys();
			if (rs.next())
				return rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}
}
