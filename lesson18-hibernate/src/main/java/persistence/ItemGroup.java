package persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Mapped with Loaihang table
//Entity: Java Class used to mapping properties with table columns
//	>>Get from table >> Table's column automatically set into corresponding

@Entity
@Table(name="LoaiHang")
public class ItemGroup {
	
	@Id
	@Column(name="MaLH")
	private Integer id;
	
	@Column(name="TenLH")
	private String name;
	
	//private List<Item> items;
	
	/*
	 * Hibernate Empty Constructor
	 */
	public ItemGroup() {
		// TODO Auto-generated constructor stub
	}
	public ItemGroup(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
		return "ItemGroup [id=" + id + ", name=" + name  + "]";
	}
	
	
	
	
	
	
}
