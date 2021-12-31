package persistence;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ChiTietMatHang")
public class ItemDetail {

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

	// Nested class
	public static class Id {

		@Column(name = "MaMH")
		private Integer itemId;
		@Column(name = "MaKC")
		private String sizeId;

		public Id() {
		}

		/**
		 *  
		 */
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
