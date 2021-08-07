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

	// List # contains # remove
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

	// hash: mã BAM >> input là data >> áp dụng 1 công thức để băm data >> return Integer
	// VD: GIT - 1 commit -SHA256 - hash
	// default: địa chỉ
	// Map, Set >> HashTable
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", managerId=" + managerId + "]";
	}

}
