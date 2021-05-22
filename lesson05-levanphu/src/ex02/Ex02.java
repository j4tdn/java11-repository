package ex02;
public class Ex02 {
	public static void main(String[] args) {
	int n = 6;
    int[] A = {3,2,1,6,5}; 
	System.out.println("Gia tri can tim la : " + getMissingNumber(A, n));
    }
     private static int getMissingNumber(int[] a , int n) {
	 int value = 1;
	 sort(a, n);
		for(int i = 0; i < n; i++ ) {
		if(a[i] == value) {
			value ++;
			}
	 }	
      	return value;
 }
		
		private static void  sort(int[] a, int n) {
		int tmp = 0;
		for(int i = 0; i < n - 1 ;i++) {
		  for(int j = i +1 ; j < n ; j++) {
			if(a[i] > a[j]) {
			 tmp = a[j];
				a[j] = a[i];
				a[i] = tmp;
		       }
			}
		}	
	}
}
