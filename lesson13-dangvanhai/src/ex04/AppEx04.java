package ex04;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


import static utils.FileUtils.*;

public class AppEx04 {
	public static void main(String[] args) {
		// Create table
		int cols = 5;
		int rows = 7;
		int[][] arr = new int[rows][cols];
		Random rd = new Random();
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = rd.nextInt(10);
			}
		}
		
		// Write file
		List<String> lines = Arrays.asList(arr).stream()
			.map(e -> {
				StringBuilder line = new StringBuilder();
				for(int number : e) {
					line.append(number).append(" ");
				}
				return line.toString().trim();
			})
			.collect(Collectors.toList());
		lines.add(0, "rows:" + rows + "| cols:" + cols);
		writeFile(Paths.get("readme.txt"), lines);
		
		// ReadFile
		List<String> data =  readFile(new File("readme.txt"));
		data.forEach(System.out::println);
	}
}
