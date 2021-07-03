package bt;

import java.util.Scanner;

public class Bt02 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter Name:");
		String name = ip.nextLine();
		name = name.replaceAll("\\s+", " ");
		String[] splitName = name.split(" ");
		name = "";
		for (int i = 0; i < splitName.length; i++) {
			name += String.valueOf(splitName[i].charAt(0)).toUpperCase() + splitName[i].substring(1).toLowerCase();
			if (i < splitName.length) {
				name += " ";
			}
		}
		System.out.println("Correctly Name: " + name);
	}
}
		
		