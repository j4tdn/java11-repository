package immutable;

import bean.Student;

public class Ex05 {
	public static void main(String[] args) {
		String [] lines = {"120130, adam ton, 7.9","125635, kate hence, 8.2"};
		for(String line : lines)
		{
			String [] tokens = line.split(", ");
			Student student = new Student(tokens[0],tokens[1] , Double.parseDouble(tokens[2]));
			System.out.println(student);
		}
		System.out.println("======================");
		String text ="123d87rrrre012f";
		String [] numbers = text.split("\\D+");
		System.out.println("length: "+numbers.length);
		for(String number: numbers)
		{
			if(!number.isEmpty())
				System.out.println(number);
		}
	}
}
