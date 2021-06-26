package ex01;

public class Student {
	private String id;
	private String name;
	private Rank rank;
	
	public Student() {
	}
	
	public Student(String id, String name, Rank rank) {
		this.id = id;
		this.name = name;
		this.rank = rank;
	}

	public String getId() {
		return id;
	}

	public void setId(String mssv) {
		this.id = mssv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", rank=" + rank + "]";
	}
	
}
