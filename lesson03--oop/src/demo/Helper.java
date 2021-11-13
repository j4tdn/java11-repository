package demo;

public class Helper {
	private int a;
	private int b;
	
	public int sum() {
		return a+b;
	}
	public Helper(int a,int b) {
		
		this.a = a;
		this.b =b;
	}
	public static void main(String[] args) {
		Helper h1 =new Helper(5,7);
		h1.sum();
		Helper h2 = new Helper(5,4);
		h2.sum();
		Helper h3 = new Helper(5,2);
		h3.sum();
	}
	
}
