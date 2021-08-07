package bean;

import java.util.Objects;

public class Employee {
	private int id;
	private String name;
	private double salary;
	private int managerId;
	
	public Employee(int id, String name, double salary, int managerId) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.managerId = managerId;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", managerId=" + managerId + "]";
	}
	
	// hash: Max băm >> Input là data >> Áp dụng một công thức để băm data >> return integer 
	// VD: GIT - 1 commit - SHA256 - hash
	@Override
	public int hashCode() {
		// Boxing
		return Objects.hash(id);
	}
	

	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Employee)) {
			return false;
		}
		Employee that = (Employee) o;
		return this.getId() == that.getId();
	}
	
}
