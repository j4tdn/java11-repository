package ex02;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import ex01.FileFormat;

import static utils.FileUtils.*;

public class AppEx02 {
	public static void main(String[] args) {
		// Create images folder
		File imagesFolder = new File("images");
		if (!imagesFolder.exists()) {
			imagesFolder.mkdirs();
		}
		createFiles(imagesFolder.toPath(), 30, new FileFormat[]{FileFormat.jpg, FileFormat.png});


		// Rename png files
		int fileName = 1;
		List<File> pngFiles = Arrays.asList(imagesFolder.list())
			.stream().map(e -> new File(imagesFolder.toString(), e))
			.filter(e -> "png".equals(getExtension(e)))
			// bug sorted
			.collect(Collectors.toList());
		pngFiles.sort((a,b) -> a.getName().compareTo(b.getName()));
		
		for(File file : pngFiles) {
//			System.out.println(file.getName());
			rename(file, "" + fileName++);
		}
		
		// Rename jpg files
		List<File> jpgFiles = Arrays.asList(imagesFolder.list())
				.stream().map(e -> new File(imagesFolder.toString(), e))
				.filter(e -> "jpg".equals(getExtension(e)))
				// bug sorted
				.sorted((a,b) -> a.getName().compareTo(b.getName()))
				.collect(Collectors.toList());
			
		for(File file : jpgFiles) {
			rename(file, "" + fileName++);
		}
		System.out.println("Done");
	}
}
