package persistences;

public class ProjectDto {
	public static final String DEPT_NAME = "dept_name";
	public static final String PRO_NAME = "pro_name";
	public static final String BUDGET = "budget";
	
	
	private String dept_name;
	private String pro_name;
	private Double budget;

	public ProjectDto() {

	}
	

	public ProjectDto(String deptName, String projName, Double budget) {
		this.dept_name = deptName;
		this.pro_name = projName;
		this.budget = budget;
	}


	public String getDeptName() {
		return dept_name;
	}

	public void setDeptName(String deptName) {
		this.dept_name = deptName;
	}

	public String getProjName() {
		return pro_name;
	}

	public void setProjName(String projName) {
		this.pro_name = projName;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "ProjectDto [deptName=" + dept_name + ", projName=" + pro_name + ", budget=" + budget + "]";
	}
	
}
