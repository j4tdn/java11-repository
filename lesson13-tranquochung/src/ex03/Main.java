package ex03;

import static utils.FileUtils.*;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
public class Main {
	private static final String OUT = "output.txt";
	private static final String IN = "input.txt";
	
	public static void main(String[] args) {
		List<Integer> listNumbers = numberInFile(IN);
		listNumbers.forEach(System.out::println);
	}
	
	private static List<Integer> numberInFile(String path) {
		File file = new File(path);
		List<String> lines = readFile(file);
		List<Integer> result = new ArrayList<>();
		List<String> s = new ArrayList<String>();
		for(String line : lines) {
			String[] listNumbers = line.split("[^0-9]+");
//			Optional<Integer> opt = Arrays.stream(listNumbers)
//				  .map(item -> Integer.parseInt(item))
//				  .reduce((a, b) -> a > b ? a : b);
			
			// result.add(opt.get());
			int max = Integer.parseInt(listNumbers[0]);
			for (int i = 1; i < listNumbers.length; i++) {
				if (max < Integer.parseInt(listNumbers[i])) 
					max = Integer.parseInt(listNumbers[i]);
			}
			result.add(max);
		}
		result.sort(Integer::compare);
		return result;
	}
}
