package persistence;

import java.sql.Date;
import java.time.LocalDate;

public class ItemByDate {
	private String matHang;
	private String tenMathang;
	private Date thoiGianDatHang;

	public ItemByDate(String matHang, String tenMathang, Date thoiGianDatHang) {
		super();
		this.matHang = matHang;
		this.tenMathang = tenMathang;
		this.thoiGianDatHang = thoiGianDatHang;
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

	public Date getThoiGianDatHang() {
		return thoiGianDatHang;
	}

	public void setThoiGianDatHang(Date thoiGianDatHang) {
		this.thoiGianDatHang = thoiGianDatHang;
	}

	@Override
	public String toString() {
		return "ItemByDate [matHang=" + matHang + ", tenMathang=" + tenMathang + ", thoiGianDatHang=" + thoiGianDatHang
				+ "]";
	}

}
