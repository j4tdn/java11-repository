package Ex01;

public class Student {
	private int studentcode;
	private String name;
	private Enum rate;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(int studentcode, String name, Enum rate) {
		
		this.studentcode = studentcode;
		this.name = name;
		this.rate = rate;
	}
	public int getStudentcode() {
		return studentcode;
	}
	public void setStudentcode(int studentcode) {
		this.studentcode = studentcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Enum getRate() {
		return rate;
	}
	public void setRate(Enum rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "Student [studentcode=" + studentcode + ", name=" + name + ", rate=" + rate + "]";
	}
	
	
	

}
