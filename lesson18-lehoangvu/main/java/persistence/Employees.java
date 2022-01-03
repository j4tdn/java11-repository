package persistence;


import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employees {

    @Id
    @Column(name = "emp_id")
    private String eId;

    @Column(name = "emp_name")
    private String eName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "salary")
    private double salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id",referencedColumnName = "dept_id")
    private Department department;



    public Employees() {
    }

    public Employees(String id, String name, Integer age, double salary) {
        this.eId = id;
        this.eName = name;
        this.age = age;
        this.salary = salary;
    }


    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "\nEmployees{" +
                "id='" + eId + '\'' +
                "'\t' name='" + eName + '\'' +
                "'\t' age=" + age +
                "'\t'salary=" + salary +'\''+
                "\n";
    }
}
