package persistence;

public class DepartmentDto {
	
	public static final String DEPT_NAME = "deptName";
	public static final String PRO_DETAIL = "proDetail";
	public static final String DEPT_TOTAL = "totalBudget";
	
	
	private String deptName;
	private String proDetail;
	private Double totalBudget;
	
	public DepartmentDto() {
	}

	public DepartmentDto(String deptName, String proDetail, Double totalBudget) {
		this.deptName = deptName;
		this.proDetail = proDetail;
		this.totalBudget = totalBudget;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getProDetail() {
		return proDetail;
	}

	public void setProDetail(String proDetail) {
		this.proDetail = proDetail;
	}

	public Double getTotalBudget() {
		return totalBudget;
	}

	public void setTotalBudget(Double totalBudget) {
		this.totalBudget = totalBudget;
	}

	@Override
	public String toString() {
		return "DepartmentDto [deptName=" + deptName + ", proDetail=" + proDetail + ", totalBudget=" + totalBudget
				+ "]";
	}
}
