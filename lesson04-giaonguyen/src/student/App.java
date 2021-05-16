package student;

public class App {
public static void main(String[] args) {
	Student s1 = new Student("Nguyen Quoc Thanh Giao", 101160132, 9.5f, 9.2f);
	Student s2 = new Student("Ngo van Hoang Phuc", 101160150, 10, 9);
	Student s3 = new Student();
	s3.inputInfo();
	
	System.out.printf("\n%-25s%-20s%20s%20s%20s\n", "Name", "ID", "Theoretical Score", "Practice Score", "Average Score");
	System.out.println("=========================================================================================================");
	System.out.printf("%-25s%-20s%20s%20s%20s\n", s1.getName(), s1.getId(), s1.getTheoreticalScore(), s1.getPracticeScore(), s1.exportScore());
	System.out.printf("%-25s%-20s%20s%20s%20s\n", s2.getName(), s2.getId(), s2.getTheoreticalScore(), s2.getPracticeScore(), s2.exportScore());
	System.out.printf("%-25s%-20s%20s%20s%20s\n", s3.getName(), s3.getId(), s3.getTheoreticalScore(), s3.getPracticeScore(), s3.exportScore());
	
}
}
