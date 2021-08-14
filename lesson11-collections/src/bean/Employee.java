package bean;

import java.util.Objects;

public class Employee {
	private int id;
	private String name;
	private double salary;
	private Integer managerId;
	
	public Employee() {
	}

	public Employee(int id, String name, double salary, Integer managerId) {
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

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", managerId=" + managerId + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if(!(o instanceof Employee)) return false;
		Employee that = (Employee) o;
		return this.getId() == that.getId();
	}
}
