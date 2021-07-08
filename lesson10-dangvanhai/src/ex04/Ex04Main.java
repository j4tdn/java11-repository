package ex04;

import java.util.Arrays;
import java.util.Comparator;

public class Ex04Main {
	public static void main(String[] args) {
		int[] arr = initDefaultArray();
		print("Original Array", arr);
		bubbleSort(arr);
		print("Bubble Sort", arr);

		arr = initDefaultArray();
		selectionSort(arr);
		print("Selection Sort", arr);

		arr = initDefaultArray();
		insertionSort(arr);
		print("Insertion Sort", arr);

		arr = initDefaultArray();
		shellSort(arr);
		print("Shell Sort", arr);

		Student[] students = new Student[] { 
				new Student("sv01", "Nguyen Huu Nhan", 19),
				new Student("sv02", "Tran Dang Khoa", 18), 
				new Student("sv03", "To Anh Phong", 19),
				new Student("sv04", "Phan Thanh Ngan", 21), 
				new Student("sv05", "Thuc Thieu Huynh", 22),
				new Student("sv06", "Van Nhu Hong", 21), 
				new Student("sv07", "Phan Thanh Ngan", 19), 
				new Student("sv07", "Nguyen Anh Ngan", 19), 
		};
		objectSort(students);
		print("objectSort", students);
	}

	private static int[] initDefaultArray() {
		return new int[] { 16, 1, 12, 17, 4, 16, 15, 8, 5, 14, 3, 1, 15, 13, 17, 12 };
	}

	private static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			boolean isSorted = true;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					isSorted = false;
				}
			}
			if (isSorted) {
				break;
			}
		}
	}

	private static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
		}
	}

	private static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int current = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > current) {
				arr[j + 1] = arr[j--];
			}
			arr[j + 1] = current;
		}
	}

	private static void shellSort(int[] arr) {
		for (int interval = arr.length / 2; interval > 0; interval /= 2) {
			for (int i = interval; i < arr.length; i++) {
				int current = arr[i];
				int j = i - interval;
				while (j >= 0 && arr[j] > current) {
					arr[j + interval] = arr[j];
					j -= interval;
				}
				arr[j + interval] = current;
			}
		}
	}

	private static void objectSort(Student[] students) {
		Arrays.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s2) {
				if (s1 == null) {
					return -1;
				}
				if (s2 == null) {
					return 1;
				}
				if (!s1.getName().equals(s2.getName())) {
					String name1 = s1.getName();
					String name2 = s2.getName();
					String[] split1 = name1.split(" ");
					String[] split2 = name2.split(" ");
					if (split1[split1.length - 1].equals(split2[split2.length - 1])) {
						return name1.compareTo(name2);
					} else {
						return split1[split1.length - 1].compareTo(split2[split2.length - 1]);
					}
				} else {
					return s1.getAge() > s2.getAge() ? 1 : (s1.getAge() == s2.getAge()) ? 0 : -1;
				}
			}
		});
	}

	private static void swap(int[] arr, int firstIndex, int secondIndex) {
		int temp = arr[firstIndex];
		arr[firstIndex] = arr[secondIndex];
		arr[secondIndex] = temp;
	}

	private static void print(String text, int[] arr) {
		System.out.println(text + ":\n" + Arrays.toString(arr));
	}

	private static void print(String text, Student[] students) {
		System.out.println(text + ":");
		for (Student s : students) {
			System.out.println("\t" + s);
		}
	}
}
