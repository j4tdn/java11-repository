package ex01;

public class Ex01 {
	public static void main(String[] args) {
		String[] sts = { "102-Nam-C ", "104-Hoang-D ", "109-Lan-A ", "103-Bao-F ", "105-Nguyen-B ", "107-Vu-F ",
				"103-Bao-F ", "202-Dat-C", "107-Vu-C ", "193-Bao-B ", "199-Tai-A " };
		for (String st : sts) {
			Student student = transformer(st);
			getA(student);
			getF(student);
		}
	}

	private static Student transformer(String array) {
		Student student = null;
		String[] elements = array.split("-");
		if (elements.length == 3) {
			student = new Student(elements[0], elements[1],  Classification.A);
			// Em không biết truyền cái elements[3] :((
		}
		return student;
	}
	
	private static void getA(Student student) {
		System.out.println("DS dat diem A");
		if(student.getCf() == Classification.A) {
			System.out.println(student);
		}
	}
	
	private static void getF(Student student) {
		System.out.println("DS dat diem F");
		if(student.getCf() == Classification.F) {
			System.out.println(student);
		}
	}

}
