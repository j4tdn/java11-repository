package baitap04;

public class Ex01 {
	public static void main(String[] args) {
		int [] a = {1,2,3,4};
		int k = getLeastCommonMultiple(a,4);
		System.out.println(k);
		
	
	}
	public static int UCLN(int a, int b) {
		
		    if(a==b) return a;
		    if(a>b) 
		        return UCLN(a-b,b);
		    else
		       return  UCLN(a,b-a);
		    
		
	}
	private static int BCNN(int a, int b) {
		return (a*b/UCLN(a,b));
	}
	private static int getLeastCommonMultiple(int a[],int n) {
		
		int temp = BCNN(a[0],a[1]);
		for(int i = 2; i< n; i++) {
			temp = BCNN(temp, a[i]);
		}
		return temp;
		
	}


}
