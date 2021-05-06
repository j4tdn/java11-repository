package baitap;

public class bai06 {
	public static void main(String[] args) {
		SoNguyenTo();
	}
	
	private static boolean laSoNguyenTo(int n) {
		if(n<2) {
			return false;
		}
		for(int i=2;i<n;i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	
	private static void SoNguyenTo() {
		int max=10000;
		int s=0;
		for(int i=2;i<max;i++) {
			if(laSoNguyenTo(i)) {
				s++;
				if(s==200) {
					System.out.println("Số nguyên tố thứ 200 là: " +i);
					break;
				}
			}
		}
		
	}

}
