package bt5;

public class SachGiaoKhoa extends MotherBook {
	private String maSGK;
	private String tinhTrang;

	public SachGiaoKhoa() {

	}

	public SachGiaoKhoa(String maSGK, String tinhTrang) {
		super();
		this.maSGK = maSGK;
		this.tinhTrang = tinhTrang;
	}

	public String getMaSGK() {
		return maSGK;
	}

	public void setMaSGK(String maSGK) {
		this.maSGK = maSGK;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public String toString() {
		return "SachGiaoKhoa [maSGK=" + maSGK + ", tinhTrang=" + tinhTrang + "]";
	}


	@Override
	void stc() {
		System.out.println(this.getNXB()=="Nhi Dong");
		
	}
}
