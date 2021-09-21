package utils;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import common.Extension;

public class FileUtils {

	private static final Random rd = new Random();

	private FileUtils() {

	}
	
	public static void rename(String path, Extension ex) {
		File file = new File(path);
		File[] files =  file.listFiles(pathname -> pathname.isFile() && pathname.toString().endsWith(ex.val()));
		
		for(int i = 0; i < files.length; i++) {
			files[i].renameTo(new File(path, "" + (i + 1 ) + ex.val()));
		}
	}
	
	
	public static void delete(String path, Extension exts) {
		File fileDelete = new File(path);
		
		File[] files = fileDelete.listFiles(file -> file.isFile() && file.getName().endsWith(exts.val()));
		
		for (File file : files) {
			file.delete();
		}
	}
	
	
	public static void copy(String path, String dirpath, Extension ex) {
		File file = new File(path);
		
		File[] files =  file.listFiles(pathname -> pathname.isFile() && pathname.toString().endsWith(ex.val()));
		
		for(File f : files) {
			Path souce = Paths.get(path+ "/" + f.getName());
			Path target = Paths.get(dirpath+ "/" + f.getName());
			
			try {
				Files.copy(souce, target,StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void move(String path, String dirpath, Extension ex) {
		File file = new File(path);
		
		File[] files =  file.listFiles(pathname -> pathname.isFile() && pathname.toString().endsWith(ex.val()));
	
		for(File f : files) {
			 f.renameTo(new File(dirpath + File.separator + f.getName()));
		}
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> readObject(File file) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
					
			return safeList(ois.readObject());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return Collections.emptyList();
	}
	
	@SuppressWarnings("unchecked")
	private static <T> List<T> safeList(Object object){
		return (List<T>) object;
	}
	
	public static  void writeObject(File file, Object object) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(object);
			oos.close();
			fos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

	public static <R> List<R> readLines(Path path, Function<String, R> func){
		List<String> lines;
		try {
			lines = Files.readAllLines(path);
			return  lines.stream()
					.map(func).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Collections.emptyList();
	}
	
	
	public static void read(File file) {
		FileReader fr = null;
		BufferedReader br = null;
		// read file
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			// iterator
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			FileUtils.close(br, fr);
		}
	}

	public static void write(File file) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		// write file
		try {
			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);

			bw.write("Line 5");
			bw.newLine();
			bw.write("Line 6");
			bw.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			FileUtils.close(bw, fw);
		}
	}

	public static void printf(File... files) {
		for (File file : files) {
			System.out.println(file.getPath());
		}
	}

	public static File create(String path) {
		boolean isValid = true;
		File file = new File(path);
		if (!file.exists()) {
			File parent = file.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs();
			}
			isValid = createFile(file);
		}

		return isValid ? file : null;
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

	public static boolean[] create(String dirpath, int nof, Extension[] exts) {
		boolean[] result = new boolean[nof];

		File dirFile = new File(dirpath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}

		int lenth = exts.length;

		for (int i = 0; i < nof; i++) {
			String name = "" + System.currentTimeMillis() + exts[rd.nextInt(lenth)].val();
			File file = new File(dirFile, name);
			result[i] = createFile(file);
		}

		return result;
	}

	
	
	
	public static void open(File file) {
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void close(AutoCloseable... autoCloseables) {
		for (AutoCloseable autoCloseable : autoCloseables) {
			if (autoCloseable != null) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
