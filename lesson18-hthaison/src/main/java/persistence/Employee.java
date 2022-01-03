package persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@Column(name = "emp_id")
	private String idEmpl;
	
	@Column(name = "emp_name")
	private String nameEmpl;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "salary")
	private Double salary;
	

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id", referencedColumnName = "dept_id")
	private Department department;
	
	public Employee() {
	}
	
	public Employee(String idEmpl, String nameEmpl, Integer age, Double salary, String address, Department department) {
		super();
		this.idEmpl = idEmpl;
		this.nameEmpl = nameEmpl;
		this.age = age;
		this.salary = salary;
		this.department = department;
	}

	public String getIdEmpl() {
		return idEmpl;
	}

	public void setIdEmpl(String idEmpl) {
		this.idEmpl = idEmpl;
	}

	public String getNameEmpl() {
		return nameEmpl;
	}

	public void setNameEmpl(String nameEmpl) {
		this.nameEmpl = nameEmpl;
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
		return "Employee [idEmpl=" + idEmpl + ", nameEmpl=" + nameEmpl + ", age=" + age + ", salary=" + salary + ", " + department.getIdDepartment()+ "]";
	}
	
	
}
