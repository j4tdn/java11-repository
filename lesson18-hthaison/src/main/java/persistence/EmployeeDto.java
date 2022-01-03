package persistence;

public class EmployeeDto {
	public static final String DEPT_ID = "dept_id";
	public static final String DEPT_NAME = "dept_name";
	public static final String EMPL_ID = "empl_id";
	public static final String EMPL_NAME = "empl_name";
	public static final String EMPL_AGE = "age";
	public static final String EMPL_SALARY = "salary";
	
	private String dept_id;
	private String dept_name;
	private String empl_id;
	private String empl_name;
	private String age;
	private String salary;
	
	public EmployeeDto() {
	}

	public String getDept_id() {
		return dept_id;
	}

	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getEmpl_id() {
		return empl_id;
	}

	public void setEmpl_id(String empl_id) {
		this.empl_id = empl_id;
	}

	public String getEmpl_name() {
		return empl_name;
	}

	public void setEmpl_name(String empl_name) {
		this.empl_name = empl_name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeDto [dept_id=" + dept_id + ", dept_name=" + dept_name + ", empl_id=" + empl_id + ", empl_name="
				+ empl_name + ", age=" + age + ", salary=" + salary + "]";
	}
	
}
