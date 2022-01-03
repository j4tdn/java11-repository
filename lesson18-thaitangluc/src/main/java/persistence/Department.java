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
	private String deptId;
	
	@Column(name = "dept_name")
	private String deptName;
	
	public Department() {
	}

	public Department(String deptId, String deptName) {
		this.deptId = deptId;
		this.deptName = deptName;

	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
}