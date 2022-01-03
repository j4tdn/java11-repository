package persistence;

public class DepartmentBudget {
	public final static String DEPARTMENT_NAME = "dept_name";
	public final static String PROJECT_NAME = "pro_name";
	public final static String SUM_BUDGET = "sum_budget";
	
	private String dept_name;
	private String pro_name;
	private Double sum_budget;
	
	public DepartmentBudget() {
		// TODO Auto-generated constructor stub
	}

	public String getDept_name() {
		return dept_name;
	}
	
	public DepartmentBudget(String dept_name, String pro_name, Double sum_budget) {
		super();
		this.dept_name = dept_name;
		this.pro_name = pro_name;
		this.sum_budget = sum_budget;
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

	public Double getSum_budget() {
		return sum_budget;
	}

	public void setSum_budget(Double sum_budget) {
		this.sum_budget = sum_budget;
	}

	@Override
	public String toString() {
		return "DepartmentBudget [dept_name=" + dept_name + ", pro_name=" + pro_name + ", sum_budget=" + sum_budget
				+ "]";
	}
	

}
