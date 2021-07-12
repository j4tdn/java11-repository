package ex04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		Student[] arr = { new Student(1,"A",11), new Student(2,"B",15), new Student(3,"C",13)};
		
		for(int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		for(Student i : list) {
			System.out.println(i);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Sort by name");
		System.out.println("2.Sort by age");
		int mode = sc.nextInt();
		sc.close();
		if(mode == 1) {
			Sorting.bubleSort(arr);
		}
		
	}
}
