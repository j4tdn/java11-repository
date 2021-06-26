package ex01;

public class Student {
	private String id;
	private String name;
	private KDL_Enum level;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}	
	public Student(String id, String name, KDL_Enum level) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
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
	public KDL_Enum getLevel() {
		return level;
	}
	public void setLevel(KDL_Enum level) {
		this.level = level;
	}
	
	
}
