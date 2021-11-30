package persistence;

import java.sql.Date;

public class ItemByQuantity {
	private String matHang;
	private String tenMathang;
	private Integer soLuong;

	public ItemByQuantity(String matHang, String tenMathang, Integer soLuong) {
		super();
		this.matHang = matHang;
		this.tenMathang = tenMathang;
		this.soLuong = soLuong;
	}

	public String getMatHang() {
		return matHang;
	}

	public void setMatHang(String matHang) {
		this.matHang = matHang;
	}

	public String getTenMathang() {
		return tenMathang;
	}

	public void setTenMathang(String tenMathang) {
		this.tenMathang = tenMathang;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "ItemByQuantity [matHang=" + matHang + ", tenMathang=" + tenMathang + ", soLuong=" + soLuong + "]";
	}

}
