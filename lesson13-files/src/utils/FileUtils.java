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

	private static final Random RD = new Random();

	private FileUtils() {

	}

	public static void read(File file) {
		// read file >> draft
		// write file
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file); // Charset.forName("utf8")
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
		// write file >> draft
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(file, true); // Charset.forName("utf8")
			bw = new BufferedWriter(fw);
			bw.write("Transaction: Alan - Milan 25000 \n");
			bw.write("Trader: Keyler >> Cambridge 10000\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			FileUtils.close(bw, fw);
		}
		FileUtils.open(file);
	}

	public static void printf(File... files) {
		for (File file : files) {
			System.out.println(file.getPath());
		}
	}

	public static File create(String path) {
		// create file
		boolean isValid = false;
		File file = new File(path);
		if (!file.exists()) {
			File parent = file.getParentFile();
			if (!parent.exists()) {
				parent.mkdir();
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
			String name = "" + RD.nextInt() + exts[RD.nextInt(length)].val();
			File file = new File(dirFile, name);
			result[i] = createFile(file);
		}

		return result;
	}

	public static void close(AutoCloseable... closeables) {
		for (AutoCloseable closeable : closeables) {
			if (closeable != null) {
				try {
					closeable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void open(File file) {
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
