package ifelse.swichcase;

public class Ex01 {
	public static void main(String[] args) {
		int a = 10;
		int b = 2; 
		int c = 42;
		float p = 6.4f;
		System.out.println(getlevel(p));
		
	}
	private static int max(int a, int b, int c) {
		int max = a > b ? a : b;
		if(max<c) {
			max = c;
		}
		return max;
		
	}
	private static Level getlevel(float point) {
		
		if(point<5) {
			return Level.ngu;
		}else if( point < 6.5) {
			return  Level.soso;
		}else if(point < 8 ) {
			return  Level.notok;
		}
		else {
			return  Level.ok;
		}
		
		
	}

}
