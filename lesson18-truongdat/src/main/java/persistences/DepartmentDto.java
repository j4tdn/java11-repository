package persistences;

public class DepartmentDto {
	public static final String PRO_NAME = "proName";
	public static final String DEPT_NAME = "deptName";
	public static final String DEPT_TOTAL = "total";

	private String proName;
	private String deptName;
	private Double total;

	public DepartmentDto() {

	}

	public DepartmentDto(String proName, String deptName, Double total) {
		super();
		this.proName = proName;
		this.deptName = deptName;
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "DepartmentDto [proName=" + proName + ", deptName=" + deptName + ", total=" + total + "]";
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	
}
