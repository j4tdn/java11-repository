package sorting;

public class App {
	public static void main(String[] args) {
		int[] arr = { 12, 5, 100, 99, 17, 77, 45, 32, 69, 78, 14, 33 };
		Sort.sort(arr, 0, arr.length - 1, 1);
		printArray(arr);

		Student[] students = { new Student(1, "John", 20), new Student(2, "Kenny", 22), new Student(3, "Kara", 21),
				new Student(4, "Nick", 24) };
		Sort.sortStudentByName(students, -1);
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].toString());
		}
	}

	public static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
