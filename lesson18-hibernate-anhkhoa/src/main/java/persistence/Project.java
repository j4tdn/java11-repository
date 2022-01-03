package persistence;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @Column(name = "pro_id",length = 10)
    private String id;

    @Column(name = "pro_name",length = Integer.MAX_VALUE,columnDefinition = "Text",nullable = false)
    private String name;

    @Column(name="budget",nullable = false)
    private Double budget;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id",referencedColumnName = "dept_id",insertable = false,updatable = false)
    private Department department;

    @OneToMany(mappedBy = "project")
    private List<Project_Employee> project_employees;

    public List<Project_Employee> getProject_employees() {
        return project_employees;
    }

    public void setProject_employees(List<Project_Employee> project_employees) {
        this.project_employees = project_employees;
    }

    public Project() {
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

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", budget=" + budget +
                ", department=" + department +
                '}';
    }
}
