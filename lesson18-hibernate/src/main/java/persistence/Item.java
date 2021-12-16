package persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

<<<<<<< HEAD


=======
>>>>>>> 2651c26d (lesson18 - Hibernate 14.12.2021)
@Entity
@Table(name = "MatHang")
public class Item {
	
	@Id
	@Column(name = "MaMH")
	private Integer id;
	
<<<<<<< HEAD
	@Column(name= "TenMH")
=======
	@Column(name = "TenMH")
>>>>>>> 2651c26d (lesson18 - Hibernate 14.12.2021)
	private String name;
	
	@Column(name = "MauSac")
	private String color;
	
	@ManyToOne(fetch = FetchType.LAZY)
<<<<<<< HEAD
	@JoinColumn(name = "MaLH",referencedColumnName ="MaLH")
	private ItemGroup itemGroup;
	
	
	// fetch type
	// @ManyToOne : EAGER FETCH
=======
	@JoinColumn(name = "MaLH", referencedColumnName = "MaLH")
	private ItemGroup itemGroup;
	
	// fetch type
	// @ManyToOne: EAGER FETCH
>>>>>>> 2651c26d (lesson18 - Hibernate 14.12.2021)
	
	public Item() {
	}
	
<<<<<<< HEAD
	
	
	public Item(Integer id, String name, String color) {
		super();
=======
	public Item(Integer id, String name, String color) {
>>>>>>> 2651c26d (lesson18 - Hibernate 14.12.2021)
		this.id = id;
		this.name = name;
		this.color = color;
	}

<<<<<<< HEAD


	public Item(Integer id, String name, String color, ItemGroup itemGroup) {
		super();
=======
	public Item(Integer id, String name, String color, ItemGroup itemGroup) {
>>>>>>> 2651c26d (lesson18 - Hibernate 14.12.2021)
		this.id = id;
		this.name = name;
		this.color = color;
		this.itemGroup = itemGroup;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public ItemGroup getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(ItemGroup itemGroup) {
		this.itemGroup = itemGroup;
	}

<<<<<<< HEAD


	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", color=" + color + ", itemGroup=" + itemGroup + "]";
	}
	
	
	
	
	
	

=======
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", color=" + color + ", itemgroup=" + itemGroup+ "]";
	}
>>>>>>> 2651c26d (lesson18 - Hibernate 14.12.2021)
}