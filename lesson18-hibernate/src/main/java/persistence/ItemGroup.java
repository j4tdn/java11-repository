package persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// Mapped with LoaiHang table
// Entity: Java Class used for mapping properties with table columns
// >> Get from Table >> Table's columns automatically set value into corresponding Class's properties 

@Entity
@Table(name = "LoaiHang")
@NamedQueries({
<<<<<<< HEAD
	@NamedQuery(name= ItemGroup.Q_GET_ALL ,query = "FROM ItemGroup"	)
=======
	@NamedQuery(name = ItemGroup.Q_GET_ALL, query = "FROM ItemGroup")
>>>>>>> 2651c26d (lesson18 - Hibernate 14.12.2021)
})
public class ItemGroup {
	
	public static final String Q_GET_ALL = "Q_GET_ALL";

	@Id
	@Column(name = "MaLH")
	private Integer id;

	@Column(name = "TenLH")
	private String name;
	
	@OneToMany(mappedBy = "itemGroup")
	private List<Item> items;
	
	// fetch type
	// @OneToMany: default LAZY

	/**
	 * Hibernate Empty Constructor
	 */
	
	@OneToMany(mappedBy = "itemGroup")
	
	private List<Item> items;
	
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

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
	
	public List<Item> getItems() {
		return items;
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "ItemGroup [id=" + id + ", name=" + name + "]";
	}
}