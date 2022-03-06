package persistence;

import java.io.Serializable;

import javax.persistence.Column;
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
	
	@ManyToOne
	@JoinColumn(name = "MaKC", referencedColumnName = "MaKC", insertable = false, updatable = false)
	private Size size;

	@Column(name = "HinhAnh")
	private String image;

	@Column(name = "GiaBan")
	private Double salesPrice;

	@Column(name = "GiaMua")
	private Double originPrice;

	@Column(name = "SoLuong")
	private Integer amount;

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

	// Nested class
	public static class Id implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = -3699105038427090280L;

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
	}

	@Override
	public String toString() {
		return "ItemDetail [id=" + id + ", item=" + item + ", size=" + size + ", image=" + image + ", salesPrice="
				+ salesPrice + ", originPrice=" + originPrice + ", amount=" + amount + "]";
	}

}
