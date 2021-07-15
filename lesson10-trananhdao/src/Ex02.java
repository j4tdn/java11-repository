
public class Ex02 {
	public static void main(String[] args) {
        
	       int[][] a = {{1,0,3,4},{5,0,8,7},{1,9,4,9},{2,4,0,5},{1,2,4,5}};
	        System.out.println("before");
	       Utils.printf(a);
	        System.out.println("after");
	       int[][] a1 = zero(a);
	        Utils.printf(a1);
	        

	    }

	    public static int[][] zero(int[][] numbers) {

	        int[] zr = new int[numbers.length];
	        int[] zc = new int[numbers[0].length];

	        for (int i = 0; i < numbers.length; i++) {
	            for (int j = 0; j < numbers[i].length; j++) {
	                if (numbers[i][j] == 0) {
	                    zr[i] = 1;
	                    zc[j] = 1;
	                }
	            }
	        }
	        for (int i = 0; i < zr.length; i++) {
	            for (int j = 0; j < zc.length; j++) {
	                if((zr[i]== 1) || (zc[j] == 1)){
	                    numbers[i][j] = 0;
	                }
	            }
	        }
	        return numbers;

	    }

}
