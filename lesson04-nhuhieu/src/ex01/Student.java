package ex01;

public class Student {
	private int id;
	private String name;
	private float theoryPoint;
	private float practicalPoint;

	public Student() {
	}

	public Student(int id, String name, float theoryPoint, float practicalPoint) {
		this.id = id;
		this.name = name;
		this.theoryPoint = theoryPoint;
		this.practicalPoint = practicalPoint;
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

	public float getTheoryPoint() {
		return theoryPoint;
	}

	public void setTheoryPoint(float theoryPoint) {
		this.theoryPoint = theoryPoint;
	}

	public float getPracticalPoint() {
		return practicalPoint;
	}

	public void setPracticalPoint(float practicalPoint) {
		this.practicalPoint = practicalPoint;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", theoryPoint=" + theoryPoint + ", practicalPoint="
				+ practicalPoint + "]";
	}

	// tạo hàm tính điểm trung bình
	public float averagePoint() {
		return (theoryPoint + practicalPoint) / 2;
	}


	// hoặc có thể tạo một phương thức khác dùng để hiển thị kết quả
	public void printStudent() {
		System.out.printf("%5s %6s %6s %6s %6s \n", id, name, theoryPoint, practicalPoint, averagePoint());
	}
}
