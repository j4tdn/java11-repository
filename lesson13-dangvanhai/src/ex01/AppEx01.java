package ex01;

import static utils.FileUtils.createFiles;
import static utils.FileUtils.deleteFile;
import static utils.FileUtils.moveFiles;
import static utils.FileUtils.ofFormats;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class AppEx01 {
	private static final String PATH_ROOT;
	private static final List<String> PATH_NODES;
	static {
		PATH_ROOT = "garbage";
		PATH_NODES = Arrays.asList("/image", "/music", "/system", "/coding");
		
	}
	public static void main(String[] args) {
		// Create garbage folder & 4 folders (image, music, system, coding)
		File rootFolder = new File(PATH_ROOT);
		rootFolder.mkdir();
		PATH_NODES.forEach(e -> new File(PATH_ROOT + e).mkdir());
		
		// Create 20 random files in RootFolder
		createFiles(rootFolder.toPath(), 20, FileFormat.getAllFormats());
		
		// Handle all files
		moveFiles(rootFolder.toPath(), 
				Path.of(rootFolder.toString(),"music"),
				e -> ofFormats(e, FileFormat.getMusicFormats()));
		
		moveFiles(rootFolder.toPath(), 
				Path.of(rootFolder.toString(),"image"),
				e -> ofFormats(e, FileFormat.getImageFormats()));
		
		moveFiles(rootFolder.toPath(),
				Path.of(rootFolder.toString(),"system"),
				e -> ofFormats(e, FileFormat.getSystemFormats()));
		
		moveFiles(rootFolder.toPath(),
				Path.of(rootFolder.toString(), "coding"),
				e -> ofFormats(e, FileFormat.getCodingFormats()));
		
		deleteFile(rootFolder.toPath(),
				e -> ofFormats(e, FileFormat.getTrashFormats()));
		
		System.out.println("Done");
	}
}
