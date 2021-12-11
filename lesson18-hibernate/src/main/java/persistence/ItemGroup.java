package persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Mapped with LoaiHang table
// Entity: Java class used for mapping properties with table columns
// >> Get from Table >> Table's properties automatically set into corresponding Class's properties

@Entity
@Table(name = "LoaiHang")
public class ItemGroup {
	
	@Id
	@Column(name = "MaLH")
	private Integer id;
	
	@Column(name = "TenLH")
	private String name;
	
	// Mapping 1-N with Item
	
	/**
	 * Hibernate Empty Constructor
	 */
	public ItemGroup() {
	}

	public ItemGroup(Integer id, String name) {
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
		return "ItemGroup [id=" + id + ", name=" + name + "]";
	}
	
	
}