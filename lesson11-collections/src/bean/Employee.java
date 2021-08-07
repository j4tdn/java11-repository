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
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.managerId = managerId;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee that = (Employee) obj;
		return getId() == that.getId();
	}

// hash: mã băm >> Input is data >> áp dụng một công thức để băm data >> return integer
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", managerId=" + managerId + "]";
	}

}
