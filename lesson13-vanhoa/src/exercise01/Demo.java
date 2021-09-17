package exercise01;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;

public class Demo {
	private static final String dirPath = "garbage";

	public static void main(String[] args) {
		// create folders, create files
		createFolder(dirPath);
		String[] folders = { "garbage/image", "garbage/music", "garbage/system", "garbage/coding" };
		for (String folder : folders) {
			createFolder(folder);
		}
		create(dirPath, 20, Extention.values());
		
		// action files, folder
		
		// move files: .png, .jpg, .jpeg to folder image
		move(dirPath, "garbage/image", Extention.PNG);
		move(dirPath, "garbage/image", Extention.JPEG);
		move(dirPath, "garbage/image", Extention.JPG);
		
		// move files: .mp3 .mp4 to folder music
		move(dirPath, "garbage/music", Extention.MP3);
		move(dirPath, "garbage/music", Extention.MP4);
		
		// move files: .bat to folder system
		move(dirPath, "garbage/system", Extention.BAT);
		
		// copy files: .java to folder coding
		copy(dirPath, "garbage/coding", Extention.JAVA);
		
		// delete files: .txt
		delete(dirPath, Extention.TXT);
		
	}

	public static void createFolder(String path) {

		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}

	}

	public static boolean createFile(File file) {
		boolean isValid = false;

		try {
			isValid = file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return isValid;
	}

	public static boolean[] create(String dirPath, int n, Extention[] exts) {

		Random rd = new Random();
		boolean[] result = new boolean[n];

		File dirFile = new File(dirPath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}

		for (int i = 0; i < n; i++) {
			String name = "" + System.currentTimeMillis() + exts[rd.nextInt(exts.length)].val();
			File file = new File(dirFile, name);
			result[i] = createFile(file);
		}

		return result;

	}
	
	public static void move(String source, String desk, Extention ext) {
		File moveFile = new File(source);
		
		File[] files = moveFile.listFiles(pathname -> pathname.isFile() && pathname.getName().endsWith(ext.val()));
		for (File file : files) {
			file.renameTo(new File(desk, file.getName()));
		}
		
		
	}
	
	public static void copy(String source, String desk, Extention ext) {
		File copyfile = new File(source);

		File[] files = copyfile.listFiles(pathname -> pathname.isFile() && pathname.getName().endsWith(ext.val()));
		
		for (File file : files) {
			Path sourcePath = Paths.get(source + "/" + file.getName());
			Path targetPath = Paths.get(desk + "/" + file.getName());
			try {
				Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void delete(String source, Extention ext) {
		
		File deleteFile = new File(source);
		File[] files = deleteFile.listFiles(pathname -> pathname.isFile() && pathname.getName().endsWith(ext.val()));
		
		for (File file : files) {
			file.delete();
		}
		
	}

}
