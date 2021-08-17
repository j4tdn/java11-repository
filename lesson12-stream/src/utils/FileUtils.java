package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import bean.Trader;

public class FileUtils {
	private FileUtils() {
		
	}
	
	public static List<String> readLines(String path){
		List<String> lines = null;
		try {
			lines = Files.readAllLines(Path.of(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lines;
	}
	
	public static<T> List<T> convert(List<String> lines, Function<String, T> func){
		List<T> result = new ArrayList<>();
		
		for(String line : lines) {
			T t = func.apply(line);
			if(t != null) {
				result.add(t);
			}
		}
		
		return result;
	}
}
