package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemAndItemGroupDto {
	private int maloai;
	private String tenloai;
	private int mamh;
	private String tenmh;
	private int giaban;
	private int giamua;
	private int soluong;

	public ItemAndItemGroupDto() {
		// TODO Auto-generated constructor stub
	}

	public ItemAndItemGroupDto(int maloai, String tenloai, int mamh, String tenmh, int giaban, int giamua,
			int soluong) {
		super();
		this.maloai = maloai;
		this.tenloai = tenloai;
		this.mamh = mamh;
		this.tenmh = tenmh;
		this.giaban = giaban;
		this.giamua = giamua;
		this.soluong = soluong;
	}

	@Override
	public String toString() {
		return "ItemAndItemGroupDto [maloai=" + maloai + ", tenloai=" + tenloai + ", mamh=" + mamh + ", tenmh=" + tenmh
				+ ", giaban=" + giaban + ", giamua=" + giamua + ", soluong=" + soluong + "]";
	}

	public int getMaloai() {
		return maloai;
	}

	public void setMaloai(int maloai) {
		this.maloai = maloai;
	}

	public String getTenloai() {
		return tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}

	public int getMamh() {
		return mamh;
	}

	public void setMamh(int mamh) {
		this.mamh = mamh;
	}

	public String getTenmh() {
		return tenmh;
	}

	public void setTenmh(String tenmh) {
		this.tenmh = tenmh;
	}

	public int getGiaban() {
		return giaban;
	}

	public void setGiaban(int giaban) {
		this.giaban = giaban;
	}

	public int getGiamua() {
		return giamua;
	}

	public void setGiamua(int giamua) {
		this.giamua = giamua;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public static ItemAndItemGroupDto transformer(ResultSet rs) {
		try {
			return new ItemAndItemGroupDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
					rs.getInt(6), rs.getInt(7));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
