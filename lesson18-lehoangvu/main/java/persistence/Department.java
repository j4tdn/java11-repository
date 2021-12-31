package persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "dept_id")
    private String dId;

    @Column(name = "dept_name")
    private String dName;




    public Department() {
    }

    public Department(String deId, String dName) {
        this.dId = deId;
        this.dName = dName;
    }

    public String getDId() {
        return dId;
    }

    public void setDId(String deId) {
        this.dId = deId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deId='" + dId + '\'' +
                ", dName='" + dName + '\'' +
                '}';
    }
}
