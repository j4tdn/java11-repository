package Ex04;

public class App04 {
	public static void main(String[] args) {
		Person director = new Director();
		Person manager = new Manager();
		Person employee1 = new Employee();
		Person employee2 = new Employee();

		// Input
		PersonUtils.inputDirector((Director) director);
		PersonUtils.inputManager((Manager) manager);
		PersonUtils.inputEmployee((Employee) employee1);
		PersonUtils.inputEmployee((Employee) employee2);

		// Show info and salary
		System.out.println();
		System.out.println(director.toString() + ": " + director.calSalary() + "vnd");
		System.out.println(manager + ": " + manager.calSalary() + "vnd");
		System.out.println(employee1 + ": " + employee1.calSalary() + "vnd");
		System.out.println(employee2 + ": " + employee2.calSalary() + "vnd");
	}

}
