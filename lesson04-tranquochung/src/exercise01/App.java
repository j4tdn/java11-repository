package exercise01;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Student sv1 = new Student(1, "John", 5f, 7f);
		Student sv2 = new Student(2, "Alice", 7f, 8f);
		Student sv3 = new Student();
		Input(sv3);

		System.out.println(sv1.toString());
		System.out.println(sv2.toString());
		System.out.println(sv3.toString());
	}

	// Enter Student
	public static void Input(Student sv) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(" Enter Student Code: ");
		sv.setMaSV(scanner.nextInt());
		scanner.nextLine();
		System.out.print(" Enter Name: ");
		sv.setTen(scanner.nextLine());
		System.out.print(" Enter theoretical point: ");
		sv.setDiemLT(scanner.nextFloat());
		System.out.print(" Enter practice point: ");
		sv.setDiemTH(scanner.nextFloat());
	}
}
