package bai_01;



public class Bai_01 {

	public static void main(String[] args) {
		int[] a = {3,15,21,0,15,17,21};
		
		
		System.out.println("ta co day so :");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+"  ");
		}
		System.out.println("");
		for(int i =0; i<a.length; i++) {
			
		}

		
		}
		public static int count(int a[], int n) {
			int cout =0;
			for(int i =0; i<=a.length; i++) {
				if(a[i] == n) {
					cout++;
				}
			}
			return cout;
		}


	

}
