package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SqlUtils {

	private SqlUtils() {
	}

	public static void close(AutoCloseable... closeables) {
		for (AutoCloseable closeable : closeables) {
			if (closeable != null) {
				try {
					closeable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static <E> void print(List<E> elements) {
		elements.forEach(System.out::println);
	}

	public static <E> void print(String prefix, E e) {
		System.out.println(prefix + ">>>" + e);
	}

	public static int getGeneratedKey(PreparedStatement pst) throws SQLException {
		int generatedKey = -1;
		ResultSet rs = pst.getGeneratedKeys();
		if(rs.next()) {
			generatedKey = rs.getInt(1);
		}
		return generatedKey;
	}
}
