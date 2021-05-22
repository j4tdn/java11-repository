package bt5;

public  abstract class MotherBook {
	private int donGia;
	private String NXB;

	public MotherBook() {
		// TODO Auto-generated constructor stub
	}

	public MotherBook(int donGia, String nXB) {
		super();
		this.donGia = donGia;
		NXB = nXB;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public String getNXB() {
		return NXB;
	}

	public void setNXB(String nXB) {
		NXB = nXB;
	}

	@Override
	public String toString() {
		return "motherbook [donGia=" + donGia + ", NXB=" + NXB + "]";
	}
	abstract void stc();
}
