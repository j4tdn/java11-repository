package ex04;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import utils.ArrayUtils;
import utils.FileUtils;

public class App {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("m  = ");
		int m = Integer.parseInt(sc.nextLine());
		System.out.println("n = ");
		int n = Integer.parseInt(sc.nextLine());
		
		int[][] arrs = new int[m][n];
		for(int i = 0; i < m; i++ ) {
			for(int j = 0; j< n; j++) {
				System.out.print("arrs[" + i +"][" + j + "] = " );
				arrs[i][j] = Integer.parseInt(sc.nextLine());
			}
		}
		ArrayUtils.printfArrays(arrs);
		File file = new File("mode/readme.txt");
		FileUtils.writeObject(file,arrs);
		
		
		System.out.println("===================");
	
		int [][] output = readArrays();
		ArrayUtils.printfArrays(output);
	}
	private static int[][] readArrays(){
		
		try {
			List<String> lines = Files.readAllLines(Paths.get("mode/readme.txt"));
			for(String line : lines) {
			
			}
			
			int m = lines.size();
			int n = lines.get(0).trim().split(" ").length;
			int [][] arrs = new int[m][n];
			System.out.println(m +"  " + n);
			for(int i = 0; i < m; i++) {
				String[] s = lines.get(i).trim().split(" ");

				for(int j = 0; j < n; j++) {
					arrs[i][j] = Integer.parseInt(s[j]);
				}
			}
			return arrs;
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}

}
