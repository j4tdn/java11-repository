package bean;

import java.util.Objects;

public class Employee {
	private int Id;
	private String name;
	private double salary;
	private Integer managerId;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, double salary, Integer managerId) {
		super();
		Id = id;
		this.name = name;
		this.salary = salary;
		this.managerId = managerId;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		
		if (!(o instanceof Employee)) {
			return false;
		}
		
		Employee that = (Employee)o;
		return getId() == that.getId();
	}
	
	// hash: mã băm >> Input là data >> áp dụng một công thức để băm data >> return integer 
	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", name=" + name + ", salary=" + salary + ", managerId=" + managerId + "]";
	}
}
