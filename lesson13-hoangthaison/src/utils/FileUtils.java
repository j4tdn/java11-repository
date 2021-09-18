package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;

import common.Extension;

public class FileUtils {

	private static final Random RD = new Random();
	public FileUtils() {
		// TODO Auto-generated constructor stub
	}
	public static void createFolder(String ...names) {
		File dir;
		for(String name : names) {
			dir = new File(name);
			if(!dir.exists()) {
				dir.mkdir();
			}
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
	
	public static boolean[] create(String dirPath, int nof, Extension[] exts) {
		boolean[] result = new boolean[nof];
		int length = exts.length;
		
		File parent = new File(dirPath);
		if(!parent.exists()) {
			parent.mkdir();
		}
		for(int i = 0; i < nof; i++) {
			String fileName = ""+System.currentTimeMillis() + exts[RD.nextInt(length)].val();
			File file = new File(parent, fileName);
			result[i] = createFile(file);
		}
		return result;
	}
	// move 1 file
	public static void moveFile(String oldPath, String newPath, Extension extension) {
		File newFile = new File(oldPath);
		File[] files = newFile.listFiles( p -> p.isFile() && p.getName().endsWith(extension.val()));
		for(File file: files) {
			file.renameTo(new File(newPath, file.getName()));
		}


	}
	// move multiple file
	public static void moveMultipFile(String oldPath, String newPath, Extension... extensions) {
		for(Extension extension : extensions) {
			moveFile(oldPath,newPath, extension);
		}
	}
	// delete file
	public static void deleteFile(String dirPath, Extension extension) {
		File source = new File(dirPath);
		File[] files = source.listFiles( p -> p.isFile() && p.getName().endsWith(extension.val()));
		for(File file: files) {
			file.delete();
		}
	}
	// copy file
	public static void copyFile(String sourcePath, String targetPath, Extension extension ) {
		File source = new File(sourcePath);
		File[] files = source.listFiles( p -> p.isFile() && p.getName().endsWith(extension.val()));
		for(File file: files) {
			Path sourcePt = Paths.get(sourcePath + "/" +file.getName());
			Path targetPt = Paths.get(targetPath + "/" + file.getName());
			try {
				Files.copy(sourcePt, targetPt, StandardCopyOption.REPLACE_EXISTING);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
