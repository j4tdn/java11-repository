package exam02;

public class Ex02 {
	public static void main(String[] args) {
		String[] st = {"01a2b3456cde478", "aa6b546c6e22h"};
		int[] results = new int[st.length];
		int a = 0;
		for(int i = 0; i < st.length; i++) {
			results[a] = getLargestNumber(st[i]);
			a++;
		}
//		for(int result : results) {
//			System.out.println(result);
//		}
		int t = getLargestNumber(st[0]);
		System.out.println(t);
	}
	
	private static int getLargestNumber(String s) {
		String[] nums = s.split("[a-z]+");
		int[] n = new int[nums.length];
		
		int max = 0;
		
		for (int i = 0; i < n.length; i++) {
			n[i] = Integer.parseInt(nums[i]); 
		}
		for (int i = 0; i < n.length; i++) {
			if(n[i] > max) {
				max = n[i];
			}
		}
		return max;
	}
	
}
