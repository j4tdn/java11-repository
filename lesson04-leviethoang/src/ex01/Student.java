package ex01;

public class Student {
	private int id;
	private String name;
	private float LT;
	private float TH;
	
	public Student() {
	}

	public Student(int id, String name, float lT, float tH) {
		super();
		this.id = id;
		this.name = name;
		LT = lT;
		TH = tH;
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

	public float getLT() {
		return LT;
	}

	public void setLT(float lT) {
		LT = lT;
	}

	public float getTH() {
		return TH;
	}

	public void setTH(float tH) {
		TH = tH;
	}

	@Override
	public String toString() {
		return "" + this.id + "\t" + this.name + "\t\t" + this.LT + "\t" +
				 + this.TH + "\t" + StudentUtils.score(this) ;
	}
	
	
}
