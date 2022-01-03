package persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
/*
 * @NamedQueries({
 * 
 * @NamedQuery(name = Department.Q_GET_ALL, query = ) })
 */
public class Department {
	//public static final String Q_GET_ALL = "Q_GET_ALL";
	@Id
	@Column(name = "dept_id")
	private String idDepartment;
	
	@Column(name = "dept_name")
	private String nameDepartment;
	
	@OneToMany(mappedBy = "department")
	private List<Employee> employees;
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Department() {
	}
	
	public String getIdDepartment() {
		return idDepartment;
	}

	public void setIdDepartment(String idDepartment) {
		this.idDepartment = idDepartment;
	}

	public String getNameDepartment() {
		return nameDepartment;
	}

	public void setNameDepartment(String nameDepartment) {
		this.nameDepartment = nameDepartment;
	}


	public Department(String idDepartment, String nameDepartment, List<Employee> employees) {
		super();
		this.idDepartment = idDepartment;
		this.nameDepartment = nameDepartment;
	}

	@Override
	public String toString() {
		return "Department [idDepartment=" + idDepartment + ", nameDepartment=" + nameDepartment + ", employees="
				+"]";
	}


	
	

}
