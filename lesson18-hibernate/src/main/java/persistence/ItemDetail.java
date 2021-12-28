package persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ChiTietMatHang")
public class ItemDetail {

	@EmbeddedId
	private Id id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaMH", referencedColumnName = "MaMH", insertable = false, updatable = false)
	private Item item;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaKC", referencedColumnName = "MaKC", insertable = false, updatable = false)
	private Size size;

	// Extra columns
	// NN table has extra columns >> cannot use @ManyToMany >> create entity for NN table
	
	@Column(name = "HinhAnh")
	private String image;

	@Column(name = "GiaBan")
	private Double salesPrice;

	@Column(name = "GiaMua")
	private Double originPrice;

	@Column(name = "SoLuong")
	private Integer amount;

	/**
	 * Empty Hibernate constructor
	 */
	public ItemDetail() {
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(Double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public Double getOriginPrice() {
		return originPrice;
	}

	public void setOriginPrice(Double originPrice) {
		this.originPrice = originPrice;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "ItemDetail [id=" + id + ", item=" + item + ", size=" + size + ", image=" + image + ", salesPrice="
				+ salesPrice + ", originPrice=" + originPrice + ", amount=" + amount + "]";
	}

	// Nested class
	@Embeddable
	public static class Id implements Serializable {

		private static final long serialVersionUID = -7774813629925126968L;

		@Column(name = "MaMH")
		private Integer itemId;

		@Column(name = "MaKC")
		private String sizeId;

		public Id() {
		}

		public Id(Integer itemId, String sizeId) {
			this.itemId = itemId;
			this.sizeId = sizeId;
		}

		public Integer getItemId() {
			return itemId;
		}

		public void setItemId(Integer itemId) {
			this.itemId = itemId;
		}

		public String getSizeId() {
			return sizeId;
		}

		public void setSizeId(String sizeId) {
			this.sizeId = sizeId;
		}

	}

}
