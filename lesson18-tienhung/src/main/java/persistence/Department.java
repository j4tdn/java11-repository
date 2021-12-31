package persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// Mapped with LoaiHang table
// Entity: Java Class used for mapping properties with table columns
// >> Get from Table >> Table's columns automatically set value into corresponding Class's properties 

@Entity
@Table(name = "department")
public class Department {

	@Id
	@Column(name = "dept_id")
	private String id;

	@Column(name = "dept_name")
	private String name;
	
	public Department(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Department() {
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

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}


}