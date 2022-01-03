package persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Project")
public class Project {
	@Id
	@Column(name = "pro_id")
	private String proId;
	
	@Column(name = "pro_name")
	private String proName;
	
	@Column(name = "budget")
	private Double budget;
	
	@ManyToOne
	@JoinColumn(name = "dept_Id", referencedColumnName = "dept_id")
	private String deptId;
	
	public Project() {
	}

	public Project(String proId, String proName, Double budget, String deptId) {
		this.proId = proId;
		this.proName = proName;
		this.budget = budget;
		this.deptId = deptId;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "Project [proId=" + proId + ", proName=" + proName + ", budget=" + budget + ", deptId=" + deptId + "]";
	}
	
	
}
