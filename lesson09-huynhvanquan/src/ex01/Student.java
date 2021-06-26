package ex01;

public class Student {
	private int id;
	private String name;
	private Level level;
	
	public Student() {}
	public Student(int id, String name, Level level) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
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
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	@Override
	public String toString() {

		return "Id: " + this.id + " - " + "Name: " + this.name +  " - " + "Level: " + this.level;
	}
	
}
