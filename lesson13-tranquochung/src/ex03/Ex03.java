package ex03;

import static utils.FileUtils.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;

public class Ex03 {
	private static final String OUT = "output.txt";
	private static final String IN = "input.txt";

	public static void main(String[] args) {
		List<Integer> listNumbers = numberInFile(IN);

		File file = create(OUT);
		writeFile(file, listNumbers);
	}

	private static List<Integer> numberInFile(String path) {
		File file = new File(path);
		List<String> lines = readFile(file);
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i < lines.size(); i++) {
			String[] listNumbers = lines.get(i).split("[^0-9]+");
			OptionalInt optInt = Arrays.stream(listNumbers).filter(item -> !item.isEmpty()).mapToInt(Integer::parseInt)
					.max();
			if (optInt.isPresent()) {
				result.add(optInt.getAsInt());
			}
		}
		Collections.sort(result);
		return result;
	}
}
