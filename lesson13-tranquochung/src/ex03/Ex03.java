package ex03;

import static utils.FileUtils.create;
import static utils.FileUtils.readFile;
import static utils.FileUtils.writeFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Function;

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
			result.add(optInt.getAsInt());
		}
		result.sort(Comparator.comparing(Function.identity()));
		return result;
	}
}
