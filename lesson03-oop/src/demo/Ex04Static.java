package demo;

import bean.CarAd;

public class Ex04Static {
	public static void main(String[] args) {
		CarAd.model = "Audi";
		
		CarAd ad1 = new CarAd("green");
		CarAd ad2 = new CarAd("blue");
		
		ad1.setColor("yellow");
		CarAd.model = "Mazda";
		
		System.out.println("ad1: " + ad1);
		System.out.println("ad2: " + ad2);
		
		int a = 10;
		int b = 5;
		Ex04Static.sum(a, b);
		Ex04Static that = new Ex04Static();
		that.sub(a, b);
	}
	
	private void test() {
		sub(10, 20);
		sum(10, 20);
	}
	
	private static int sum(int a, int b) {
		// test();
		return a + b;
	}
	
	private int sub(int a, int b) {
		return a - b;
	}
}
