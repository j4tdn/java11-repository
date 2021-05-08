package demo;

import bean.CarAd;

public class Ex04Static {
	public static void main(String[] args) {
		CarAd.model = "Audi";
		CarAd ad1 = new CarAd("Yellow");
		CarAd ad2 = new CarAd("Gray");
		
		ad1.setColor("Red");
		ad2.model = "Mazda"; // == CarAd.model = "Mazda";
		
		System.out.println(ad1);
		System.out.println(ad2);
	}
}
