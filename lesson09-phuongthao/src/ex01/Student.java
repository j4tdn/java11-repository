package ex01;

public class Student {
	private String id;
	private String name;
	private Mark mark;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String id, String name, Mark mark) {
		super();
		this.id = id;
		this.name = name;
		this.mark = mark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Mark getMark() {
		return mark;
	}

	public void setMark(Mark mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mark=" + mark + "]";
	}
	
	
	

}
