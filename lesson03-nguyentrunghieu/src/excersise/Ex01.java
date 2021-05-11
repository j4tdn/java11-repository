package excersise;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		int hoanhDoDiemM, tungDoDiemM, hoanhDoTamO, tungDoTamO, banKinhR;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào hoành độ tâm O: ");
		hoanhDoTamO = sc.nextInt();
		System.out.println("Nhập vào tung độ tâm O: ");
		tungDoTamO = sc.nextInt();
		System.out.println("Nhập vào hoành độ điểm M: ");
		hoanhDoDiemM = sc.nextInt();
		System.out.println("Nhập vào tung độ điểm M: ");
		tungDoDiemM = sc.nextInt();
		System.out.println("Nhập vào bán kính R: ");
		banKinhR = sc.nextInt();
		
		if(check(hoanhDoDiemM, tungDoDiemM, hoanhDoTamO, tungDoTamO, banKinhR)) {
			System.out.println("Điểm M thuộc đường tròn");
		}else 
			System.out.println("Điểm M không thuộc đường tròn");
			
	}

	private static boolean check(int hoanhDoDiemM, int tungDoDiemM, int hoanhDoTamO, int tungDoTamO, int banKinhR) {
		return Math.sqrt(Math.pow(hoanhDoDiemM - hoanhDoTamO, 2) + Math.pow(tungDoDiemM - tungDoTamO, 2)) == banKinhR;
	}

}
