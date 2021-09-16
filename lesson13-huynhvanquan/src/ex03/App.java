package ex03;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class App {
	public static void main(String[] args) {
		List<String> lines = null;
		try {
			lines = Files.readAllLines(Paths.get("data/ex03-input.txt"));
			String line = lines.get(0);
			if (!line.matches("[0-9]+") || 1 > Integer.parseInt(line) && Integer.parseInt(line) > 100) {
				return;
			}
			List<Integer> numList = getResult(lines);
			FileWriter fw = new FileWriter("data/ex03-output.txt", true);
			PrintWriter pw = new PrintWriter(fw);
			for (Integer num : numList) {
				pw.write(num.toString() + "\n");
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<Integer> getResult(List<String> lines) {
		List<Integer> numList = new ArrayList<Integer>();
		int count = 1;
		for (String line : lines) {
			Matcher matcher = Pattern.compile("[0-9]+").matcher(line);
			while (matcher.find() && count <= 500) {
				numList.add(Integer.parseInt(matcher.group()));
				++count;
			}
		}
		numList.remove(0);
		numList = numList.stream().sorted().collect(Collectors.toList());
		return numList;
	}
}
