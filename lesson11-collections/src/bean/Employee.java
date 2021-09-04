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
	
	//List #contains #remove 
	//Map
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if (!(o instanceof Employee)) {
			return false;
		}
		Employee that = (Employee) o; 
		return getId() == that.getId();
	}
	
	//hash: Input la data >> Ap dung cong thuc de hash du lieu va return integer
	//VD: GIT - 1 commit 
	//Map, Set >> HashCode
	//Cùng equals -> bắt buộc cùng hashCode, cùng hashCode -> chưa chắc equals
	@Override
	public int hashCode() {
		//boxing B30: 55:00
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", managerId=" + managerId + "]";
	}

}
