package bai01;

public class getUniqueNumber {
	public static void main(String[] args) {
		int arr[] = {3,15,21,0,15,17,21};
		int kq;
		kq = getUniqueNumber(arr);
		System.out.println("so chi xuat hien 1 lan: " + kq);
		
	}
	private static int getUniqueNumber(int arr[]) {
		int kq = 0;
		for (int i = 0; i < arr.length; i++) {
			kq ^= arr[i];
		}
		return kq;
	}
	
}
