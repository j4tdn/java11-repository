package company;

public class CompanyUtils {
	public static double exportSalary(People people) {
		double salary = 0.0d;
		
		if (people.getId() == 3) {
			salary = (people.getCoefficientsSalary() + people.coefficientsJob) * 1250000;
		}
		else if (people.getId() == 2) {
			salary = (people.getCoefficientsSalary() + people.coefficientsJob) * 2200000;
		}
		else if (people.getId() == 1) {
			salary = (people.getCoefficientsSalary() + people.coefficientsJob) * 3000000;
		}
		
		return salary;
	}
}
