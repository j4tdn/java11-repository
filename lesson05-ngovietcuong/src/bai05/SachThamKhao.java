package bai05;

public class SachThamKhao extends Sach {
	private double thue;

	public SachThamKhao() {

	}

	public SachThamKhao(String maSach, double donGia, String nhaXB, double thue) {
		super(maSach, donGia, nhaXB);
		this.thue = thue;
	}

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}

	@Override
	public String toString() {
		return super.toString() + " " + thue;
	}

}
