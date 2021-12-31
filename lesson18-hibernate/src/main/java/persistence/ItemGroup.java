package persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

//Mapped with loaihang table
//Entity : from javax.oersistence libbrary
@Entity
@Table(name="LoaiHang")
@NamedQueries({
	@NamedQuery(name=ItemGroup.Q_GET_ALL,query = "FROM ItemGroup")
})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ItemGroup {
	
	public static final String Q_GET_ALL = "Q_GET_ALL";
	
	@Id
	@Column(name="MaLH")
	private Integer id;
	
	@Column(name="TenLH")
	private String name;
	
	@OneToMany(mappedBy = "itemGroup")
	private List<Item> items;
	
	/*
	 * Hibernate Emty constructor
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

	public List<Item> getItems() {
		return this.items;
	}
	@Override
	public String toString() {
		return "ItemGroup [id=" + id + ", name=" + name+"]";
	}
}