package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;


public class DepartmentDto {
	
	public static final String DEPT_ID   = "deptId";
	public static final String DEPT_NAME = "deptName";
	public static final String DEPT_TOTAL = "total";
	
	private String deptId;
	private String deptName;
	private Integer total;
	
	public DepartmentDto() {
	}
	
	
	public DepartmentDto(String deptId, String deptName, Integer total) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.total = total;
	}


	public String getDeptId() {
		return deptId;
	}


	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public Integer getTotal() {
		return total;
	}


	public void setTotal(Integer total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "DepartmentDto [deptId=" + deptId + ", deptName=" + deptName + ", total=" + total + "]";
	}


	public static DepartmentDto addResultTransfomer(ResultSet rs) throws SQLException {
		return new DepartmentDto(
				rs.getString(DepartmentDto.DEPT_ID), 
				rs.getString(DepartmentDto.DEPT_NAME),
				rs.getInt(DepartmentDto.DEPT_TOTAL)
		);
	}
	
}