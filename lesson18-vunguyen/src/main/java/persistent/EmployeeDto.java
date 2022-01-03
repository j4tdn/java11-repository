package persistent;

public class EmployeeDto {
    private String emp_id;
    private String emp_name;
    private Integer age;
    private Double salary;
    private String dept_id;
    private String dept_name;

    public EmployeeDto() {
    }

    public EmployeeDto(String emp_id,
                       String emp_name,
                       Integer age,
                       Double salary,
                       String dept_id,
                       String dept_name) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.age = age;
        this.salary = salary;
        this.dept_id = dept_id;
        this.dept_name = dept_name;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
               "emp_id = " + emp_id + ", " +
               "emp_name = " + emp_name + ", " +
               "age = " + age + ", " +
               "salary = " + salary + ", " +
               "departmentId = " + dept_id + ", " +
               "departmentDeptName = " + dept_name + ")";
    }
}
