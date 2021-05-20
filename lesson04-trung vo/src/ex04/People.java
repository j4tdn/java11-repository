package ex04;

abstract class People {
	private String name;
	private int yearOfBirth;
	private float coEffiencts;
	
	abstract float getSalary(); 
	
	public People() {
		// TODO Auto-generated constructor stub
	}

	public People(String name, int yearOfBirth, float coEffiencts) {
		super();
		this.name = name;
		this.yearOfBirth = yearOfBirth;
		this.coEffiencts = coEffiencts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public float getCoEffiencts() {
		return coEffiencts;
	}

	public void setCoEffiencts(int coEffiencts) {
		this.coEffiencts = coEffiencts;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", yearOfBirth=" + yearOfBirth + ", coEffiencts=" + coEffiencts + "]";
	}
	
	
}
