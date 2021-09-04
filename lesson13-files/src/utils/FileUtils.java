package utils;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import common.Extension;

public class FileUtils {
	private static final Random rd = new Random();
	private FileUtils() {
		// TODO Auto-generated constructor stub
	}

	public static File create(String path) {
		boolean isValid = false;

		File file = new File(path);

		if (!file.exists()) {
			File parent = file.getParentFile();
			if (!parent.exists()) {
				parent.mkdirs();
			}
			createFile(file);

		}
		return isValid ? file : null;
	}

	private static boolean createFile(File file) {
		boolean isValid = false;
		try {
			isValid = file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isValid;
	}

	public static boolean[] create(String dirPath, int nof, Extension[] exts) {
		boolean[] result = new boolean[nof];
		File dirFile = new File(dirPath);
		
		if(!dirFile.exists()) {
			dirFile.mkdir();
		}
		int length = exts.length;
		for(int i = 0; i< nof; i++) {
			String name = "" + rd.nextInt() + exts[rd.nextInt(length)].val();
			File file = new File(dirFile, name);
			result[i] = createFile(file);
		}
		return result;
	}

	public static void printf(File ...files ) {
		for(File file: files) {
			System.out.println(file.getPath());
		}
	}
	public static void open(File file) {
		try {
			Desktop.getDesktop().open(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(AutoCloseable ...closeables ) {
		for(AutoCloseable closeable:closeables) {
			if(closeable != null) {
				try {
					closeable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void write(File file) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(file);
		 	bw = new BufferedWriter(fw);
			bw.write("Line 1\n");
			bw.write("Line 2");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			FileUtils.close(bw,fw);
		}
	}
	public static void read(File file) {
		//read file >> draft
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br  = new BufferedReader(fr);
			String line;
			if((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			FileUtils.close(br,fr);
		}
		
	}

}