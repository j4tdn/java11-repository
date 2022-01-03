package persistence;

public class DepartmentBudgetYear {
	public static final String DEPARTMENT_NAME = "dept_name";
	public static final String PROJECT_NAME = "pro_name";
	public static final String BUDGET  = "budget";
	
	private String dept_name;
	private String pro_name;
	private Double budget;
	
	public DepartmentBudgetYear() {
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public DepartmentBudgetYear(String dept_name, String pro_name, Double budget) {
		super();
		this.dept_name = dept_name;
		this.pro_name = pro_name;
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "DepartmentBudgetYear [dept_name=" + dept_name + ", pro_name=" + pro_name + ", budget=" + budget + "]";
	}
	
	
}
