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
import java.util.Collection;
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
		// TODO Auto-generated constructor stub
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
			// TODO: handle exception
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	@SuppressWarnings("unchecked")
	private static <T> List<T> safeList(Object object) {
		return (List<T>) object;
	}

	public static void writeObject(File file, Object object) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(object);
			oos.close();
			fos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static <T extends FileHandler> void writeLines(Path path, List<T> list, OpenOption option) {
		List<String> lines = list.stream().map(T::toLine).collect(Collectors.toList());

		try {
			Files.write(path, lines, option);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Write file successfull !!");

	}

	public static <R> List<R> ReadLines(Path path, Function<String, R> func) {
		try {
			List<String> lines = Files.readAllLines(path);

			return lines.stream().map(func).collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Collections.emptyList();

	}

	public static void read(File file) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println(br.readLine());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileUtils.close(br, fr);
		}
	}

	public static void write(File file) {
		// write file
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(bw);

			bw.write("Transaction: Alan - Milan -25000\n");
			bw.write("Trader: Kyler - Cambridge - 10000\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileUtils.close(bw, fw);
		}
		System.out.println("================");
		FileUtils.open(file);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValid;
	}

	public static void printf(File... files) {
		for (File file : files) {
			System.out.println(file.getPath());
		}
	}

	public static boolean[] create(String dirPath, int nof, Extension[] ex) {
		boolean[] result = new boolean[nof];

		File dirFile = new File(dirPath);

		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		int length = ex.length;

		for (int i = 0; i < nof; i++) {
			String name = "" + System.currentTimeMillis() + ex[rd.nextInt(length)];
			File file = new File(name);
			result[i] = createFile(file);
		}
		return result;
	}

	public static void close(AutoCloseable... closebales) {
		for (AutoCloseable closebale : closebales) {
			if (closebale != null) {
				try {
					closebale.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void open(File file) {
		try {
			Desktop.getDesktop().open(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
