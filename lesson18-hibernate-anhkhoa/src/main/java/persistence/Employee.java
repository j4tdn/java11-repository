package persistence;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "emp_id",length = 10)
    private String id;

    @Column(name="emp_name",length = Integer.MAX_VALUE,columnDefinition = "Text",nullable = false)
    private String name;

    @Column(name = "age",nullable = false)
    private Integer age;

    @Column(name="salary",nullable = false)
    private Double salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id",referencedColumnName = "dept_id",insertable = false,updatable = false)
    private Department department;

    @OneToMany(mappedBy = "employee")
    private List<Project_Employee> project_employees;

    public Employee() {
    }

    public List<Project_Employee> getProject_employees() {
        return project_employees;
    }

    public void setProject_employees(List<Project_Employee> project_employees) {
        this.project_employees = project_employees;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
