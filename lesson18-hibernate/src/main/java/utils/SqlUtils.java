package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SqlUtils {

	private SqlUtils() {
	}

	public static void breakLine(String text) {
		System.out.println("\n=========/" + text + "/==========\n");
	}

	public static void close(AutoCloseable... autoCloseables) {
		try {
			for (AutoCloseable closeable : autoCloseables) {
				if (closeable != null) {
					closeable.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static <Element> void print(List<Element> elements) {
		for (Element element : elements) {
			System.out.println(element);
		}
	}

	public static <Element> void print(String prefix, Element element) {
		System.out.println(prefix + " >>> " + element);
	}

	public static int getGeneratedKey(PreparedStatement pst) {
		int generatedKey = -1;
		ResultSet rs;
		try {
			rs = pst.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return generatedKey;
	}
}