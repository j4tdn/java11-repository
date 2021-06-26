package exam01;

public class Student {

	private String id;
	private String name;
	private Level level;

	public Student() {
	}

	public Student(String id, String name, Level level) {
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

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", level=" + level + "]";
	}

}
