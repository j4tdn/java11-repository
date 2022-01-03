package persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//entity
@Entity
@Table(name = "project")
public class Project {
	@Id
	@Column(name = "pro_id")
	private String id;

	@Column(name = "pro_name")
	private String name;

	@Column(name = "budget")
	private Double budget;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id", referencedColumnName = "dept_id")
	private Department department;

	public Project() {
	}

	public Project(String id, String name, Double budget, Department department) {
		this.id = id;
		this.name = name;
		this.budget = budget;
		this.department = department;
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
		return "Project [id=" + id + ", name=" + name + ", budget=" + budget + ", department=" + department + "]";
	}
}