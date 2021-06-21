package ex01;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Student sv1 = new Student(1, "Tran Van A", 8.3f, 9.3f);
		Student sv2 = new Student(2, "Tran Van B", 6.5f, 7.2f);
		Student sv3 = AppUtils.insert();
		Student[] svs = {sv1, sv2, sv3};
		AppUtils.print(svs);

	}
}
