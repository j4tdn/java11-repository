package persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loaihang")
public class ItemGroup {
	@Id
	@Column(name = "MaLoai")
	private Integer idItemGroup;

	@Column(name = "TenLoai")
	private String nameItemGroup;

	@ManyToOne
	private Item item;

	public ItemGroup() {

	}

	public ItemGroup(Integer idItemGroup, String nameItemGroup) {
		super();
		this.idItemGroup = idItemGroup;
		this.nameItemGroup = nameItemGroup;
	}

	public Integer getIdItemGroup() {
		return idItemGroup;
	}

	public void setIdItemGroup(Integer idItemGroup) {
		this.idItemGroup = idItemGroup;
	}

	public String getNameItemGroup() {
		return nameItemGroup;
	}

	public void setNameItemGroup(String nameItemGroup) {
		this.nameItemGroup = nameItemGroup;
	}

	@Override
	public String toString() {
		return idItemGroup + " " + nameItemGroup;
	}
}