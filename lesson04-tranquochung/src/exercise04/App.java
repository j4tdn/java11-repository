package exercise04;

public class App {
	public static void main(String[] args) {
		// Enter Data
		People d1 = new Director("Elon Musk", "1988", 2d, 2d);
		People m1 = new Manager("John Devic", " 1998", 1.5d, 5);
		People e1 = new Employee("John wick", "1999", 1.5d, "Tuyen Dung");
		People e2 = new Employee("John wick", "1999", 1.5d, "Tuyen Dung");
		People[] P = new People[4];
		P[0] = d1;
		P[1] = m1;
		P[2] = e1;
		P[3] = e2;

		// Show Infor
		for (int i = 0; i < P.length; i++) {
			System.out.println(P[i] + ", Salary =  " + P[i].salary());
		}
	}
}
