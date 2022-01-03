package persistent;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @Column(name = "pro_id")
    private String id;

    @Column(name = "pro_name")
    private String pro_name;

    @Column(name = "budget")
    private Double budget;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id", referencedColumnName = "dept_id")
    private Department dept_id;

    public Project() {
    }

    public Project(String id, String pro_name, Double budget, Department dept_id) {
        this.id = id;
        this.pro_name = pro_name;
        this.budget = budget;
        this.dept_id = dept_id;
    }

    public Department getDept_id() {
        return dept_id;
    }

    public void setDept_id(Department dept_id) {
        this.dept_id = dept_id;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Project{" +
               "id='" + id + '\'' +
               ", pro_name='" + pro_name + '\'' +
               ", budget=" + budget +
               ", dept_id=" + dept_id +
               '}';
    }
}