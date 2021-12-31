package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDto {
	
	public static final String DEPT_ID   = "id";
	public static final String DEPT_NAME = "name";
	public static final String DEPT_TOTAL = "total";
	
	private String id;
	private String name;
	private Integer total;
	
	public DepartmentDto() {
	}

	public DepartmentDto(String id, String name, Integer total) {
		this.id = id;
		this.name = name;
		this.total = total;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "DepartmentDto [id=" + id + ", name=" + name + ", total=" + total + "]";
	}
	
	public static DepartmentDto addResultTransfomer(ResultSet rs) throws SQLException {
		return new DepartmentDto(
				rs.getString(DepartmentDto.DEPT_ID), 
				rs.getString(DepartmentDto.DEPT_NAME),
				rs.getInt(DepartmentDto.DEPT_TOTAL)
		);
	}
	
}
