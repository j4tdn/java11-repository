package ex01;


public class Ex01 {
	private String id;
	private String name;
	private String score;
	
public Ex01() {
	// TODO Auto-generated constructor stub
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
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Ex01 [id=" + id + ", name=" + name + ", score=" + score + "]";
	}
	
	
	
	
	
}