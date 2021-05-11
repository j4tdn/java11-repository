package bai02;

public class Vehicle {
	private String loaiXe;
	private double dungTich;
	private long triGia;

	public Vehicle() {

	}

	public Vehicle(String loaiXe, double dungTich, long triGia) {
		super();
		this.loaiXe = loaiXe;
		this.dungTich = dungTich;
		this.triGia = triGia;
	}

	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}

	public double getDungTich() {
		return dungTich;
	}

	public void setDungTich(double dungTich) {
		this.dungTich = dungTich;
	}

	public long getTriGia() {
		return triGia;
	}

	public void setTriGia(long triGia) {
		this.triGia = triGia;
	}

	@Override
	public String toString() {
		return loaiXe + "\t " + dungTich + "\t\t" + triGia + "\t " + tienThue();
	}

	public double tienThue() {
		double thue;
		if (dungTich < 100)
			return thue = 0.01 * triGia;
		if (dungTich >= 100 && dungTich <= 200)
			return thue = 0.03 * triGia;
		return thue = 0.05 * triGia;
	}

}
