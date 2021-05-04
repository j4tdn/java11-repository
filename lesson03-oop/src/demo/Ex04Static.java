package demo;

import bean.CarAd;

public class Ex04Static {
	public static void main(String[] args) {
		CarAd.model = "Audi";
		CarAd ad1 = new CarAd("Green");
		CarAd ad2 = new CarAd("Blue");

		ad1.setColor("yellow");
		CarAd.model = "Mazda";

		System.out.println("ad1: " + ad1);
		System.out.println("ad2: " + ad2);
	}
}
