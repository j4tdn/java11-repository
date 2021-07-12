package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int index = 10;
		int[] numbers = Work.input(index);
		System.out.println("Mảng ban đầu:");
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
		System.out.println("\n<=================================>");

		Student[] students = new Student[index];
		Work.input(students);
		System.out.println("Danh sách học viên:");
		Arrays.stream(students).forEach(student -> System.out.println(student));
		System.out.println(">=================================<");
		do {
			System.out.println(">=================================<");
			System.out.println(">>>>>>>>>>> Select Sort <<<<<<<<<<<");
			System.out.println("1. Sắp xếp nổi bọt (Buble Sort)");
			System.out.println("2. Sắp xếp chọn (Selection Sort)");
			System.out.println("3. Sắp xếp chèn (Insertion Sort)");
			System.out.println("4. Sắp xếp các đối tượng (Object Sort)");
			System.out.println("5. Shell Sort");
			System.out.println("6. Sắp xếp trộn (Merge Sort)");
			System.out.println("7. Sắp xếp nhanh (Quick Sort)");
			System.out.println("8. Exit");
			System.out.print(" > Enter the selection: ");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int select = Integer.parseInt(sc.nextLine());

			switch (select) {
			case 1:
				System.out.println("<=================================>");
				System.out.println(">>> Sắp xếp nổi bọt (Buble Sort) <<<");
				Work.bubleSort(students, numbers, index);
				System.out.println(">=================================<");
				break;
			case 2:
				System.out.println("<=================================>");
				System.out.println(">>> Sắp xếp chọn (Selection Sort) <<<");
				Work.selectionSort(students, numbers, index);
				System.out.println(">=================================<");
				break;
			case 3:
				System.out.println("<=================================>");
				System.out.println(">>> Sắp xếp chèn (Insertion Sort) <<<");
				Work.insertionSort(students, numbers, index);
				System.out.println(">=================================<");
				break;
			case 4:
				System.out.println("<=================================>");
				System.out.println(">>> Sắp xếp các đối tượng (Object Sort) <<<");
				Work.objectSort(students, numbers, index);
				System.out.println(">=================================<");
				break;
			case 5:
				System.out.println("<=================================>");
				System.out.println(">>> Shell Sort <<<");
				Work.shellSort(numbers, index);
				System.out.println(">=================================<");
				break;
			case 6:
				System.out.println("<=================================>");
				System.out.println(">>> Sắp xếp trộn (Merge Sort) <<<");
				Work.mergeSort(numbers, index);
				System.out.println(">=================================<");
				break;
			case 7:
				System.out.println("<=================================>");
				System.out.println(">>> Sắp xếp nhanh (Quick Sort) <<<");
				Work.quickSort(numbers, index);
				System.out.println(">=================================<");
				break;
			case 8:
				System.exit(0);
			default:
				System.out.println("> Vui lòng nhập vào 1 sô tương ứng với lựa chọn! <");
				break;
			}
		} while (true);
	}
}
