package factory;

//abstraction: truu tuong (luc la hinh nay, luc la hinh kia)
public class Shape {
	//mac dinh la ham defaut
	void drawing() {
		System.out.println("Shape >> drwaing.....");
	}
	

	private void clear() {
		System.out.println("Shape >> clearing....");
	}
}
