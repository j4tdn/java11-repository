package ex04;

public class Sorting {
	
	
	public static Student[] bubleSort(Student[] list){
		Student temp;
		for(int i = 0; i < list.length; i++) {
			for(int j = i + 1; i < list.length; j++) {
				if(list[i].getName().compareTo(list[j].getName()) > 0) {
					temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
		for(Student i : list) {
			System.out.println(i);
		}
		return list;
	}
	public static void output(Student[] list) {
		for(Student i : list) {
			i.toString();
		}
	}

}
