  
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
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;



import common.Extension;
import common.FileHandler;
import common.Trader;

public class FileUtils {

	private static final Random rd = new Random();

	private FileUtils() {

	}
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
	
	private static <T> List<T> safeList(Object object) {
		return (List<T>) object;
	}
	
	public static void writeObject(File file, Object object) {
		FileOutputStream fos = null;
		ObjectOutputStream oos= null;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(object);
			oos.close();fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static <T extends FileHandler> void writeLines(Path path, List<T> list, OpenOption option) {
		List<String> lines = list.stream()
				.map(T::toLine)
				.collect(Collectors.toList());

		try {
			Files.write(path, lines, option);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static <R> List<R> readLines(Path path, Function<String, R> func) {
		List<String> lines;
		try {
			 lines = Files.readAllLines(path);
			 return lines.stream().map(func).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public static void read(File file) {
		// read file >> draft
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			// iterator
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			FileUtils.close(fr, br);
		}
	}

	public static void write(File file) {
		// write file >> draft
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);

			bw.write("Transaction: Alan - Milan 25000 \n"); // "\n" == bw.newLine();
			bw.write("Trader: Kyler >> Cambridge 100000");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			FileUtils.close(bw, fw);
		}

		System.out.println("======== ^.^ ========");
		FileUtils.open(file);
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
			try {
				isValid = file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
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
			String name = "" + System.currentTimeMillis() + exts[rd.nextInt(length)].val();
			File file = new File(dirFile, name);
			result[i] = createFile(file);
		}
		return result;
	}

	public static void open(File file) {
		try {
			Desktop.getDesktop().open(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
}