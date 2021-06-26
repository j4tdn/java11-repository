package exam01;

public class DemoEx01 {
	public static void main(String[] args) {
		String[] students = { "102-Nam-C", "104-Hoàng-D", "109-Lan-A", "103-Bảo-F", "105-Nguyên-B", "107-Vũ-F",
				"103-Bảo-F", "202-Đạt-C", "107-Vũ-C", "193-Bảo-B", "104-Hoàng-B" };
		Student[] stds = new Student[students.length];
		for (int i = 0; i < students.length; i++) {
			stds[i] = transform(students[i]);
		}
		Condition c = (x) -> {
			return x.getLevel().equals(Level.A);
		};
		Student[] r = find(stds, c);
		for (int i = 0; i < r.length; i++) {
			System.out.println(r[i]);
		}
		System.out.println("===========================");
		Condition c1 = (x) -> {
			return x.getLevel().equals(Level.F);
		};
		Student[] s = find(stds, c1);
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}

	private static Student transform(String s) {
		Student st = new Student();
		String[] elements = s.split("-");
		if (elements.length == 3) {
			st = new Student(elements[0], elements[1], Level.valueOf(elements[2]));
		}
		return st;
	}

	private static Student[] find(Student[] st, Condition c) {
		int count = 0;

		for (int i = 0; i < st.length; i++) {
			if (c.test(st[i])) {
				count++;
			}
		}
		Student[] result = new Student[count];
		int a = 0;
		for (int i = 0; i < st.length - 1; i++) {
			if (c.test(st[i])) {
				result[a] = st[i];
				a++;
			}
		}
		return result;
	}

}
