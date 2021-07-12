package ex01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class App {
	
	/**
	 * Bài 1: Tạo mảng số nguyên ngẫu nhiên gồm n phần tử. Viết các phương thức:
	 * Loại bỏ những phần tử trùng nhau VD: {1,2,3,4,3,1} Kết quả: {2,4}
	 * So sánh giá trị trung bình của n/2 phần tử đầu tiên với n/2 phần tử cuối cùng
	 * Tìm số lớn thứ 3 trong mảng. Lưu ý trường hợp các phần tử lớn nhất trùng
	 * nhau VD: {7 8 8 8 6 2 5 1} Kết quả: 6
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap N: ");
		int N = sc.nextInt();
		int[] before =  randomArray(N);
		int[] result = remove(before);
		
		System.out.println("Mang da random");
		for(int i: before) {
			System.out.print(i + ", ");
		}
		System.out.println("Sau khi loai phan tu trung");
		for(int i: result) {
			if(i!=0) {
				System.out.print(i + ", ");
			}
		}
		System.out.println("\n=== So sánh n/2 phần tử đầu và cuối ===");
		compare(before);
		
		
		System.out.println("\n=== Phần tử lớn thứ n ===");
		System.out.println("Nhập n: ");
		int n = sc.nextInt();
		System.out.println("Phần tử lớn thứ "+ n +": " + large3th(bubbleSort(result), n) );
	}
	// bubble Sort array 
	public static int[] bubbleSort (int[] origin) { 
		int temp = 0;
		int[] tmp = Arrays.copyOfRange(origin, 0, origin.length);
		for(int i = 0; i < tmp.length -1; i++) {
			for(int j = 0; j < tmp.length - 1 - i; j++) {
				if(tmp[j] > tmp[j+1]) {
					temp = tmp[j];
					tmp[j] = tmp[j +1];
					tmp[j+1] = temp;
				}
			}
		}
		return  tmp;
	}
	
	private static int[] randomArray( int N) {
		Random rd = new Random();
		int[] array = new int[N];	
		for(int i = 0; i< N; i++) {
			array[i] = rd.nextInt(15);
		}
		return array;
	}
	
	//remove nhung so trung nhau
	private static int[] remove(int[] origin) {
		int N = origin.length;
		int[] tmp = Arrays.copyOfRange(origin, 0, N);
		int[] ok = new int[N];
		int[] result = new int[N];
		
		int count = 1;
		ok[0] = tmp[0];
		boolean check;
		for(int i = 1; i < N ; i++) {
			check = false;
			for(int j = 0; j < count; j++ ) {
				if(ok[j] == tmp[i]) {
					check = true;
					break;
				}
			}
			if(!check) {
				ok[count] = tmp[i];
				count++;
			}
		}
		
		for(int i = 0; i < ok.length; i++) {
			int bla = 0;
			for(int j : tmp) {
				if(ok[i] == j) {
					bla ++;
				}
			}
			if(bla == 1) {
				result[i] = ok[i];
			}
		}
		return result;
		
	}
	
	
	private static void compare (int[] origin) {
		int n = origin.length;
		int sumFirst = 0;
		int sumLate = 0;
		if(n % 2 != 0) {
			for(int i = 0; i < n/2; i++) {
				sumFirst+= origin[i];				
			}
			for(int j = n-1; j > n/2; j--) {
				sumLate += origin[j];
			}
		}
		if(n % 2 == 0) {
			for(int i = 0; i < n/2; i++) {
				sumFirst+= origin[i];				
			}
			for(int j = n-1; j > n/2 ; j--) {
				sumLate += origin[j];
			}
		}
		if(sumFirst > sumLate) {
			System.out.println("Trung bình cộng của nửa đầu mảng lớn hơn");
		}
		if(sumFirst == sumLate)
			 System.out.println("Bằng nhau");
		if(sumFirst < sumLate)
			System.out.println("Nửa cuối lớn hơn");
		
	}
	private static int large3th(int[] origin, int n) {
		int[] arr = Arrays.copyOfRange(origin, 0, origin.length);
		return arr[arr.length-n];
		
	}

}
