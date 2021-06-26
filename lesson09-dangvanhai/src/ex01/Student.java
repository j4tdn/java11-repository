package ex01;

public class Student {
	private String idStudent;
	private String fullName;
	private Equivalent equivalent;

	public Student() {
	}

	public Student(String idStudent, String fullName, Equivalent equivalent) {
		this.idStudent = idStudent;
		this.fullName = fullName;
		this.equivalent = equivalent;
	}

	public String getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(String idStudent) {
		this.idStudent = idStudent;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Equivalent getEquivalent() {
		return equivalent;
	}

	public void setEquivalent(Equivalent equivalent) {
		this.equivalent = equivalent;
	}

	@Override
	public String toString() {
		return "Student [idStudent=" + idStudent + ", fullName=" + fullName + ", equivalent=" + equivalent + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Student student = (Student) obj;
		if (this.idStudent.equals(student.getIdStudent())) {
			return true;
		}
		return false;
	}

}
