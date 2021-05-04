package demo;

import bean.CarAd;

public class Ex04Static {
	public static void main(String[] args) {
		CarAd.model = "Audi";
		CarAd ad1 = new CarAd("Green");
		CarAd ad2 = new CarAd("Yellow");
		
		ad1.setColor("yellow");
		ad2.model = "madza"; // CarAd.model = "madza"; static thuoc class
		
		System.out.println("ad1 : " + ad1);
		System.out.println("ad2 : " + ad2);
		
	}
}
