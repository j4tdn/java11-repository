package persistent;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Department")
public class Department {
    @Id
    @Column(name = "dept_id")
    private String id;

    @Column(name = "dept_name", nullable = false)
    private String deptName;

    @OneToMany(mappedBy = "dept_id")
    List<Project> projects;

    public Department() {
    }

    public Department(String id, String deptName) {
        this.id = id;
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Department{" +
               "id='" + id + '\'' +
               ", deptName='" + deptName + '\'' +
               '}';
    }
}