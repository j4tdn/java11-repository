package ex01;

public class Student {
	public int id;
	public String name;
	public float lt;
	public float th;
	
	public Student(int id, String name, float lt, float th) {
		super();
		this.id = id;
		this.name = name;
		this.lt = lt;
		this.th = th;
		
	}
	public Student() {
		// TODO Auto-generated constructor stub
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
	public float getLt() {
		return lt;
	}
	public void setLt(float lt) {
		this.lt = lt;
	}
	public float getTh() {
		return th;
	}
	public void setTh(float th) {
		this.th = th;	
	}

	public float getDiemTb() {
		return (this.lt+this.th)/2;
		
	}
	

	@Override
	public String toString() {
		return  id + "\t" +  name   + "\t\t" + lt + "\t\t" +  th +"\t\t\t" + getDiemTb();
	}
	
	
	
	
	
	
}
