package ex04;

import java.text.DecimalFormat;

public class People {
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

	public float getHsl() {
		return hsl;
	}

	public void setHsl(float hsl) {
		this.hsl = hsl;
	}

	public float getHscv() {
		return hscv;
	}

	public void setHscv(float hscv) {
		this.hscv = hscv;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###,###,##0.00");
		return this.getClass().getSimpleName() + " :  id = " + id + ", name = " + name + ", hsl = " + hsl + ", hscv = "
				+ hscv + ", salary = " + df.format(salary());
	}

	public double salary() {
		return 0;
	}

}
