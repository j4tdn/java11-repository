package demo;

import bean.Rectangle;

public class Ex01 {
	// toSTRING
	// classe, objectt => instance, entity
	public static void main(String[] args) {
		// r1: w8 h4
		Rectangle r1 = new Rectangle();
		r1.setWidth(12);
		r1.setHeight(6);
		System.out.println("r1: " + r1.toString()); // toString được gọi mặc định nên có thể bỏ
													// toString mặc định sẽ gọi địa chỉ của class, object -> override
													// lại
		// r2:w9 h7
		Rectangle r2 = new Rectangle(9, 7);
		System.out.println("r2: " + r2);

		// ktra xem r1 có phải là thự thể của rectangle k
		System.out.println(r1 instanceof Rectangle);
	}

}
