package utils;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import common.Extension;
import common.FileHandler;

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
	public static void renameFile(String sourcePath, Extension extension) {
		File source = new File(sourcePath);
		File[] files = source.listFiles( p -> p.isFile() && p.getName().endsWith(extension.val()));
		int count = 1; 
		for(File file: files) {
			file.renameTo(new File(sourcePath+"/" + count + extension.val() + ""));
			count++;
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	private static <T> List<T> safeList(Object object) {
		return (List<T>) object;
	}
	@SuppressWarnings("resource")
	public static <T> List<T> readObject(File file) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			return safeList(ois.readObject());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	public static void writeObject(File file, int[][] arrs) {
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);

			for(int i = 0; i < arrs.length; i++) {
				for(int j = 0; j < arrs[i].length; j++) {
					bw.write(arrs[i][j]+ " ");
				}
				bw.write("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			close(bw,fw);
		}

	}
	public static <T> List<T> readLine(Path path, Function<String, T> func){
		List<String> lines = null;
		try {
			lines = Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return lines.stream().map(func).collect(Collectors.toList());
			
	}
	public static <T extends FileHandler> void writeLines(Path path, List<T> list, OpenOption option) {
		List<String> lines = list.stream().map(T::toLine).collect(Collectors.toList());
		try {
			Files.write(path, lines, option);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void close(AutoCloseable... closeables) {
		for (AutoCloseable closeable : closeables) {
			if (closeable != null) {
				try {
					closeable.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}


}
