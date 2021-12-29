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
public class ItemDetail{
	
	@EmbeddedId
	private Id id;
	
	@Column(name = "HinhAnh")
	private String image;
	
	@Column(name = "GiaBan")
	private Double salesPrice;
	
	@Column(name = "GiaMua")
	private Double originPrice;
	
	@Column(name = "SoLuong")
	private Integer amount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaMH", referencedColumnName = "MaMH", insertable = false, updatable = false)
	private Item item;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaKC", referencedColumnName = "MaKC", insertable = false, updatable = false)
	private Size size;
	
	public Size getSize() {
		return size;
	}
	
	public void setSize(Size size) {
		this.size = size;
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

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


	@Override
	public String toString() {
		return "ItemDetail [id=" + id + ", image=" + image + ", salesPrice=" + salesPrice + ", originPrice="
				+ originPrice + ", amount=" + amount + ", item=" + item + ", size=" + size + "]";
	}


	@Embeddable
	public static class Id implements Serializable{

		private static final long serialVersionUID = 765259206862433758L;

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

		@Override
		public String toString() {
			return "Id [itemId=" + itemId + ", sizeId=" + sizeId + "]";
		}
	}
}
