package demo;

import bean.Rectangle;

public class Ex01 {
	public static void main(String[] args) {
		// r1: w8 h4
		Rectangle r1 = new Rectangle();
		r1.setWidth(12);
		r1.setHeight(6);

		// dùng hàm toString để trả về toàn bộ giá trị cho r1 sau đó bỏ .toString đi
		// có thể in: r1.with + r1.height nhưng dài dòng
		System.out.println("r1: " + r1);

		// r2: w9 h7
		Rectangle r2 = new Rectangle(9, 7);
		System.out.println("r2: " + r2);
	}
}
