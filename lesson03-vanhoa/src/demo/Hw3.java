package demo;

import java.util.Scanner;

import bean.Matrix;

public class Hw3 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		Matrix m1 = new Matrix();
		
		System.out.println("Enter column length of board: ");
		int n = ip.nextInt();
		m1.setColumnLength(n);
		System.out.println("Enter cow length of board: ");
		int m = ip.nextInt();
		m1.setRowLength(m);
		
		m1.randomMatrix(m1.getColumnLength(),m1.getRowLength());
		System.out.println(m1.isSaddle());
	}

}
