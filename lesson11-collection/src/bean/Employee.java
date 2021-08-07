package bean;

import java.util.Objects;

public class Employee {
	private int id;
	private String name;
	private Double salary;
	private Integer managerId;

	public Employee() {
	}

	public Employee(int id, String name, Double salary, Integer managerId) {
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

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getManagerId() {
		return managerId;
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

	// hash >> Input is data >> Ap dung mot cong thuc de bam data >> return integer
	// ex: GIT - 1 commit - hash
	// Map, Set >> HashTable
	@Override
	public int hashCode() {
		// Boxing
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", managerId=" + managerId + "]";
	}

}
