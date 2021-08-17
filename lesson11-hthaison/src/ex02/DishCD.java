package ex02;

public class DishCD {
	private int maCD;
	private String loaiCD;
	private String singer;
	private int number;
	private double price;
	
	public DishCD() {
		// TODO Auto-generated constructor stub
	}

	public int getMaCD() {
		return maCD;
	}

	public void setMaCD(int maCD) {
		this.maCD = maCD;
	}

	public String getLoaiCD() {
		return loaiCD;
	}

	public void setLoaiCD(String loaiCD) {
		this.loaiCD = loaiCD;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public DishCD(int maCD, String loaiCD, String singer, int number, double price) {
		super();
		this.maCD = maCD;
		this.loaiCD = loaiCD;
		this.singer = singer;
		this.number = number;
		this.price = price;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof DishCD)) {
			return false;
		}
		DishCD that = (DishCD)obj;
		return this.getMaCD() == that.getMaCD();
	}
	
	@Override
	public String toString() {
		return  maCD + ", " + loaiCD + ", " + singer + ", " + number + ", "
				+ price;
	}	
	
	
}
