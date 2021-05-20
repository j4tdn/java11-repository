package bai04;

abstract class People {
	private String hoten;
	private int namsinh;
	private int hsluong;

	public People() {
		
	}

	public People(String hoten, int namsinh, int hsluong) {
		super();
		this.hoten = hoten;
		this.namsinh = namsinh;
		this.hsluong = hsluong;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public int getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(int namsinh) {
		this.namsinh = namsinh;
	}

	public int getHsluong() {
		return hsluong;
	}

	public void setHsluong(int hsluong) {
		this.hsluong = hsluong;
	}
	
	abstract double getLuong();
}
