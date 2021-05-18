package polymorphism.object;

public class App {
	public static void main(String[] args) {
		Shape shape = new Shape();
		shape.drawing(); // Shape >>drawing
		
		Rectangle rectangle = new Rectangle();
		rectangle.drawing(); // Rectangle >> drwaing
		rectangle.setBackground(); //Rectangle >>setting background
		
		Square square = new Square();
		square.drawing(); //Squre >>drawing
		
		System.out.println("=====================");
		Shape s1 = new Rectangle();
		s1.drawing(); // Rectangle >> drawing
		
		//muon biet luc runtime tro den ai thi goi ham:
				System.out.println("RTS1: " + s1.getClass().getName());
		
		Shape s2 = new Square();
		s1.drawing(); //Square >> drawing
		System.out.println("RTS1: " + s1.getClass().getName());
		
		s1 =s2;
		s2 = s1; 
		
		//khong the lay child new parent 
//		Rectangle r1 = new Shape();
//		r1.setBackground(); error
		
		//Conclusion (Tom lai): Goal of polymorphism with object
			//1. easy modify (ep kieu) date type of object
			//2. Hide the way create object >> factory pattern (khoi tao doi tuong ma khong phoi bay ra cach khoi tao, chi biet luc CP)
		
		
		//factory-pattern: initial design pattern
		//hide object creation
			
		//Collections: fix-size, list
		//List<Student>
		//Max 10Students. int[] students = new int[10]; //fixed-size
		//     30students		students
		
		//rectangle = square; no-relationship (cac class con k co moi quan he vs nhau)
		
		
		//trong qua trinh code co 2 qua trinh
		//Compile time: CT
		//Runtime: RT
		//luc compile s1 la Shape
		//luc RT thi tham chieu no tro den doi tuong vd nhu (new Rectangle) [doi tuong ma minh new ra hoac null
		//RT thi s1 se la Rectangle
		
		
	}
	
}
