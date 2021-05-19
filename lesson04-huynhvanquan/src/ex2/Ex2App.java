package ex2;
import java.util.Scanner;

public class Ex2App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		System.out.println("How many numbers do you enter?");
		n = sc.nextInt();
		int[] numList = new int[n];
		enterList(numList);
		System.out.print("Original number list: ");
		printList(numList);
		process7(numList);
		process5(numList);
		System.out.print("\nNew number list: ");
		printList(numList);
	}

	private static void enterList(int[] numList) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number list: ");	
		for(int i = 0; i < numList.length; i++) {
			numList[i] = sc.nextInt();
		}
	}
	private static void process7(int[] numList) {
		int left = 0;
		int temp;
		for(int i = 0; i < numList.length; i++) {
			if (numList[i] % 7 == 0 && numList[i] % 5 != 0) {
				temp = numList[left];
				numList[left] = numList[i];
				numList[i] = temp;
				++left;
			}
		}
	}
	private static void process5(int[] numList) {
		int temp;
		int right = numList.length - 1;
		for(int i = numList.length - 1; i >= 0; i-- ) {
			if (numList[i] % 5 == 0 && numList[i] % 7 != 0) {
				temp = numList[right];
				numList[right] = numList[i];
				numList[i] = temp;
				--right;
			}
		}
	}
	private static void printList(int[] numList) {
		for (int i = 0; i < numList.length; i++) {
			System.out.print(numList[i] + " ");
		}
	}
}
