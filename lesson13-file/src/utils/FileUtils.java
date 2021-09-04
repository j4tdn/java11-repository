package utils;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

import common.Extension;

public class FileUtils {
	
	private static final Random rd = new Random();
	
	public FileUtils() {
	
	}
	
	public static void read(File file) {
		FileReader fr = null;
		BufferedReader br = null;
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
		// write file .. draft
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);
			
			bw.write("Transaction: Alan - Milan 25000"); bw.newLine();
			bw.write("Trader: Kyler >> Cambridge 100000\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			FileUtils.close(bw, fw);
		}
		
		System.out.println("==== ^-^ ====");
		FileUtils.open(file);
	}
	
	public static void printf(File ...  files) {
		for (File file : files) {
			System.out.println(file.getPath());
		}
	}
	
	public static File create(String path) {
		boolean isValid = false;
		File file = new File(path);
		if (!file.exists()) {
			File parent = file.getParentFile();
			if (!parent.exists()) {
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

	public static boolean[] create(String dirPath, int nof, Extension[] exts) {
		boolean[] result = new boolean[nof];
		
		File dirFile = new File(dirPath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		
		int length = exts.length;
		for (int i = 0; i < nof; i++) {
			String name = "" + System.currentTimeMillis() + exts[rd.nextInt(length)];
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
	
	public static void close(AutoCloseable ... closeables ) {
		for (AutoCloseable closeable: closeables) {
			if (closeable != null) {
				try {
					closeable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} 
	}
}