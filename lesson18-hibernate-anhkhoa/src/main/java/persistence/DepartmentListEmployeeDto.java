package persistence;

public class DepartmentListEmployeeDto {

    public static final String DEPARTMENT_ID = "d_id";
    public static final String DEPARTMENT_NAME = "d_name";
    public static final String EMPLOYEE_ID = "e_id" ;
    public static final String EMPLOYEE_NAME = "e_name";
    public static final String EMPLOYEE_AGE = "age";
    public static final String EMPLOYEE_SALARY = "salary";


    private String d_id;
    private String d_name;
    private String e_id;
    private String e_name;
    private Integer age;
    private Double salary;

    public DepartmentListEmployeeDto() {
    }

    public String getD_id() {
        return d_id;
    }

    public void setD_id(String d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
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

    @Override
    public String toString() {
        return "DepartmentDto{" +
                "d_id='" + d_id + '\'' +
                ", d_name='" + d_name + '\'' +
                ", e_id='" + e_id + '\'' +
                ", e_name='" + e_name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
