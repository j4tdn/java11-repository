package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import ex01.Extension01;
import ex02.Extension02;

public class FileUtils {
	private FileUtils() {
	}
	public static void createFolder(String... names) {
		File dir;
		for (String name : names) {
			dir = new File(name);
			if (!dir.exists()) {
				dir.mkdir();
			}
		}
	}
	public static void create(String dirPath, int nof, Object[] exts) {
		File dirFile = new File(dirPath);
		Random rd = new Random();
		int count = 1;
		if (dirFile.exists()) {
			dirFile.mkdirs();
		}
		int length = exts.length; 
		while(count <= 20) {
			String name = dirPath + "/" + System.currentTimeMillis() + "." + exts[rd.nextInt(length)];
			File file = new File(name);
			count = createFile(file) ? ++count : count;
		}
	}
	
	private static boolean createFile(File file) {
		boolean isValid = false;
		try {
			isValid = file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isValid;
	}
	
	public static <R> List<R> readLines(Path path, Function<String, R> func) {
		try {
			List<String> lines = Files.readAllLines(path);
			return lines.stream()
						.map(func)
						.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	

}
