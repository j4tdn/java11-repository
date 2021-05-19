package bai4;

public abstract class People {
	private int id;
	private String name;
	private float hsl;
	private float hscv;

	public People() {
	}

	public People(int id, String name, float hsl, float hscv) {
		super();
		this.id = id;
		this.name = name;
		this.hsl = hsl;
		this.hscv = hscv;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHsl() {
		return hsl;
	}

	public void setHsl(float hsl) {
		this.hsl = hsl;
	}

	public double getHscv() {
		return hscv;
	}

	public void setHscv(float hscv) {
		this.hscv = hscv;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", " + "Tên: " + name + ", " + "Hệ số lương: " + hsl + ", " + "Hệ số chức vụ: " + hscv;
	}

	abstract double Luong();

	abstract void input();

}
