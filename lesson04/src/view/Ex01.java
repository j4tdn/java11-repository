package view;

import bean.Student;

public class Ex01 {

	public static void main(String[] args) {
		Student st1 = new Student(1, "Tracy", 8, 9);
		Student st2 = new Student(2, "Kate", 9, 10);
		Student st3 = new Student();
		st3.setId(3);
		st3.setName("Tony");
		st3.setMarkLT(9);
		st3.setMarkTH(8);
		System.out.format("%-20s %-30s %20s %20s %20s\n", "mssv", "Họ tên", "điểm LT", "điểm TH", "Điểm TB");
		System.out.format("%-20d %-30s %20f %20f %20f\n", st1.getId(), st1.getName(), st1.getMarkLT(), st1.getMarkTH(), st1.getAverageMark());
		System.out.format("%-20d %-30s %20f %20f %20f\n", st2.getId(), st2.getName(), st2.getMarkLT(), st2.getMarkTH(), st2.getAverageMark());
		System.out.format("%-20d %-30s %20f %20f %20f\n", st3.getId(), st3.getName(), st3.getMarkLT(), st3.getMarkTH(), st3.getAverageMark());
	}

}