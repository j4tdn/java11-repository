package ex01;

import java.util.Arrays;

public class App  {
	public static void main(String[] args) {
		Students[] students = getStudents();
	}
	
	private static Students[] findAGrade(Students[] students) {
		Students[] result = new Students[students.length];
		int i = 0;
		for (Students s: students) {
			if(s.getClassification() == Classification.A) {
				result[i++] = s;
			}
		}
		return Arrays.copyOfRange(result, 0, i);
	}
	
	private static Students[] getStudents() {
		Students st1 = new Students("102", "Nam", Classification.C);
		Students st2 = new Students("104", "Hoàng", Classification.D);
		Students st3 = new Students("109", "Lan", Classification.A);
		Students st4 = new Students("103", "Bảo", Classification.F);
		Students st5 = new Students("105", "Nguyên", Classification.B);
		Students st6 = new Students("107", "Vũ", Classification.F);
		Students st7 = new Students("103", "Bảo", Classification.F);
		Students st8 = new Students("202", "Đạt", Classification.C);
		Students st9 = new Students("107", "Vũ", Classification.C);
		Students st10 = new Students("193", "Bảo", Classification.B);
		Students st11 = new Students("104", "Hoàng", Classification.B);
		return new Students[] {st1, st2, st3, st4, st5, st6, st7, st8, st9, st10, st11};
	}
}
