package ex03;

import static utils.FileUtils.*;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AppEx03 {
	public static void main(String[] args) {
		// Read file
		File inputFile = new File("input_ex03.txt");
		List<String> texts = readFile(inputFile);

		// Handle texts
		List<Integer> numbers = texts.stream().map(e -> getLargestNumber(e))
			.sorted(Integer::compare)
			.collect(Collectors.toList());

		// Write file
		writeFile(Paths.get("output_ex03.txt"), numbers);
		System.out.println("Done");
	}

	private static Integer getLargestNumber(String line) {
		line = line.replaceAll("[^0-9]+", ",");
		if (line.charAt(0) == ',') {
			line = line.substring(1);
		}
		if(line.charAt(line.length() - 1) == ',') {
			line = line.substring(0, line.length()-1);
		}
		int number = Arrays.asList(line.split(","))
			.stream()
			.map(e -> Integer.parseInt(e))
			.mapToInt(e -> e)
			.max().getAsInt();
		return number;
	}

}
