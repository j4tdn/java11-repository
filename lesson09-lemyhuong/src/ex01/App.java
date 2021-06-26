package ex01;

public class App {
	public static void main(String[] args) {
		Student[] students1 = {new Student("102", "Nam", Level.C),
							 new Student("104", "Hoàng", Level.D),
							 new Student("109", "Lan", Level.A),
							 new Student("103", "Bảo", Level.F),
							 new Student("105", "Nguyên", Level.B),
							 new Student("107", "Vũ", Level.F),
							 new Student("103", "Bảo", Level.F),
							 new Student("202", "Đạt", Level.C),
							 new Student("107", "Vũ", Level.C),
							 new Student("193", "Bảo", Level.B),
							 new Student("104", "Hoàng", Level.B)
							};
		
		String[] students = {"102-Nam-C", "104-Hoàng-D", "109-Lan-A", "103-Bảo-F", "105-Nguyên-B"
							,"107-Vũ-F", "103-Bảo-F", "202-Đạt-C", "107-Vũ-C", "193-Bảo-B"
							, "104-Hoàng-B"};
		
		for (String student: students) {
			String lvl = student.substring(student.lastIndexOf('-') + 1);
			
			System.out.println(lvl);
//			if (lvl.equals("A")) {
//				System.out.println(lvl);
//			}
		}
	}
	
		
}
