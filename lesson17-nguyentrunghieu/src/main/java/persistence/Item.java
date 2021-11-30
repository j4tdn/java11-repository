package persistence;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mathang")
public class Item {
	@Id
	@Column(name = "MaMH")
	private Integer idItem;

	@Column(name = "TenMH")
	private String nameItem;

	@Column(name = "Size")
	private String sizeItem;

	@Column(name = "GiaMua")
	private Double priceBuyItem;

	@Column(name = "GiaBan")
	private Double priceSellItem;

	@Column(name = "SoLuong")
	private Integer numberItem;

	@Column(name = "MauSac")
	private String colorItem;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "MaLoai")
	private Set<ItemGroup> itemGroups = new HashSet<>();

	public Item() {

	}

	public Item(Integer idItem, String nameItem, String sizeItem, Double priceBuyItem, Double priceSellItem,
			Integer numberItem, String colorItem, Set<ItemGroup> itemGroups) {
		super();
		this.idItem = idItem;
		this.nameItem = nameItem;
		this.sizeItem = sizeItem;
		this.priceBuyItem = priceBuyItem;
		this.priceSellItem = priceSellItem;
		this.numberItem = numberItem;
		this.colorItem = colorItem;
		this.itemGroups = itemGroups;
	}

//	public Item(Integer idItem, String nameItem, String sizeItem, Double priceBuyItem, Double priceSellItem,
//			Integer numberItem, String colorItem) {
//		super();
//		this.idItem = idItem;
//		this.nameItem = nameItem;
//		this.sizeItem = sizeItem;
//		this.priceBuyItem = priceBuyItem;
//		this.priceSellItem = priceSellItem;
//		this.numberItem = numberItem;
//		this.colorItem = colorItem;
//	}

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public String getNameItem() {
		return nameItem;
	}

	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
	}

	public String getSizeItem() {
		return sizeItem;
	}

	public void setSizeItem(String sizeItem) {
		this.sizeItem = sizeItem;
	}

	public Double getPriceBuyItem() {
		return priceBuyItem;
	}

	public void setPriceBuyItem(Double priceBuyItem) {
		this.priceBuyItem = priceBuyItem;
	}

	public Double getPriceSellItem() {
		return priceSellItem;
	}

	public void setPriceSellItem(Double priceSellItem) {
		this.priceSellItem = priceSellItem;
	}

	public Integer getNumberItem() {
		return numberItem;
	}

	public void setNumberItem(Integer numberItem) {
		this.numberItem = numberItem;
	}

	public String getColorItem() {
		return colorItem;
	}

	public void setColorItem(String colorItem) {
		this.colorItem = colorItem;
	}


	public Set<ItemGroup> getItemGroups() {
		return itemGroups;
	}

	public void setItemGroups(Set<ItemGroup> itemGroups) {
		this.itemGroups = itemGroups;
	}

	@Override
	public String toString() {
		return idItem + " " + nameItem + " " + numberItem;
	}
}