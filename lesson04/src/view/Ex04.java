package view;

import java.util.Scanner;

import bean.Director;
import bean.Employee;
import bean.Manager;
import bean.People;

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		People gd = new Director(sc.nextLine(), Integer.parseInt(sc.nextLine()), Float.parseFloat(sc.nextLine()), Float.parseFloat(sc.nextLine()));
		
		System.out.println(gd.tinhLuong());
		
		People tp = new Manager(sc.nextLine(), Integer.parseInt(sc.nextLine()), Float.parseFloat(sc.nextLine()), Integer.parseInt(sc.nextLine()));
		
		System.out.println(tp.tinhLuong());
		
		People nv1 = new Employee(sc.nextLine(), Integer.parseInt(sc.nextLine()), Float.parseFloat(sc.nextLine()), sc.nextLine());
		
		System.out.println(nv1.tinhLuong());
		
		People nv2 = new Employee(sc.nextLine(), Integer.parseInt(sc.nextLine()), Float.parseFloat(sc.nextLine()), sc.nextLine());
		
		System.out.println(nv2.tinhLuong());
		
		
		
		
		

}
	
}