
public class Utils {
private Utils() {
		
	}
	public static void printf(int[] elements) {
		for (int element : elements) {
			System.out.print(element + " ");
		}
		// break line
		System.out.println();
	}
        public static void printf(int[][] a) {
		for(int i = 0; i< a.length; i++){
                    for( int j = 0; j< a[i].length; j++){
                        System.out.print(a[i][j] + " ");
                        
                    }
                    System.out.println("");
                }
	}
        public static void printf(String[] elements) {
		for (String element : elements) {
			System.out.print(element + " ");
		}
		// break line
		System.out.println();
	}
        public static void printf(ObjectSort[] elements) {
		for (ObjectSort element : elements) {
			System.out.println(element );
		}
		// break line
		System.out.println();
	}

}
