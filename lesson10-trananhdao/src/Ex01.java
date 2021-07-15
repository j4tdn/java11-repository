import java.util.Arrays;

public class Ex01 {
	 public static void main(String[] args) {
	        int[] a = {1, 2,21, 3, 4,12,15,15, 3, 1};
	        
	        
	        System.out.println("Mang sau khi loai bo nhung phan tu trung nhau");
	        Utils.printf(removeDuplicateElements(a));
	        System.out.println("compare: ");
	        System.out.println(Compare1(a));
	        max3(sort(a), 2);

	    }

	    private static int[] remove(int[] a) {
	        int length = a.length;
	        for (int i = 0; i < length; i++) {
	            for (int j = i + 1; j < length; j++) {
	                if (a[i] == a[j]) {

	                    for (int k = j; k < length; k++) {
	                        a[j] = a[k];
	                    }
	                    length--;
	                }
	            }
	        }
	        return Arrays.copyOfRange(a, 0, length);

	    }

	    private static int count(int[] a, int n) {

	        int count = 0;
	        for (int i = 0; i < a.length; i++) {
	            if (a[i] == n) {
	                count++;
	            }
	        }
	        return count;
	    }

	    private static int[] removeDuplicateElements(int[] a) {
	        int[] a1 = new int[a.length];
	        int n = 0;
	        int j = 0;

	        for (int i = 0; i < a.length; i++) {
	            if (count(a, a[i]) == 1) {
	                a1[j++] = a[i];
	                n++;
	            }

	        }
	        return Arrays.copyOfRange(a1, 0, n);
	    }


	    private static String Compare1(int[] a) {

	        int[] a1 = new int[a.length];

	        int s1 = 0;
	        int s2 = 0;

	        for (int i = 0; i < a.length / 2; i++) {
	            s1 += a[i];
	            s2 += a[a.length - 1 - i];
	        }

	        if (s1 == s2) {
	            return "s1 = s2";
	        }
	        if (s1 > s2) {
	            return "s1 > s2";
	        }
	        if (s1 < s2) {
	            return "s1 < s2";
	        }
	        return null;
	    }

	    private static int[] sort(int[] a) {
	        int[] a1 = remove(a);
	        int temp;

	        for (int i = 0; i < a1.length; i++) {
	            for (int j = 0; j < a1.length; j++) {
	                if (a1[j] < a1[i]) {
	                    temp = a1[i];
	                    a1[i] = a1[j];
	                    a1[j] = temp;
	                }
	            }
	        }
	        return a1;
	    }
	    private static void max3(int[] a, int n){
	        
	        for (int i = 0; i < a.length; i++) {
	            if(i == n){
	                System.out.println(a[i]);
	            }
	        }
	    }

}
