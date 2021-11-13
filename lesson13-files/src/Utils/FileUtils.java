package Utils;

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
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import common.Extension;
import common.FileHandler;

public class FileUtils {
	private static final Random rd = new Random();
	private FileUtils() {
		// TODO Auto-generated constructor stub
	}
	public static <E extends FileHandler> void writeLines(Path path, List<E> list,OpenOption option) {
		
		List<String> lines = list.stream()
							.map(E::toLine)
							.collect(Collectors.toList());
		
		
		try {
			Files.write(path,lines,option);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Write file successfull");
	}
	public static <E> List<E> readLines(Path path, Function<String, E> func) {
		try {
			List<String> lines = Files.readAllLines(path);
			return lines.stream().map(func)
					.collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	public static File create(String path) {
		boolean isValid = true;
		File file = new File(path);
		if(!file.exists()) {
			File parent = file.getParentFile();
			if(parent!=null && !parent.exists()) {
				parent.mkdirs();
			}
			isValid = createFile(file);
		}
		return isValid? file : null;
	}
	public static boolean createFile(File file) {
		boolean isValid= false;
		try {
			isValid= file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isValid;
	}
	public static boolean[] create(String dirPath, int nof, Extension[] exts) {
		boolean[] rs = new boolean[nof];
		
		File dirFile = new File(dirPath);
		if(!dirFile.exists()) {
			dirFile.mkdirs();
		}
		int lenghth = exts.length;
		for(int i=0;i< nof;i++) {
			String name = "file" + i+ exts[rd.nextInt(lenghth)].value();
			File file = new File(dirFile,name);
			rs[i] = createFile(file);
		}
		return rs;
	}
	public static void read(File file) {
		//read file >> draft
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			//iterator
			String line = null;
			while((line = br.readLine())!=null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error readfile: " + e);
		} 
	}
	public static void write(File file) {
		//write file >> draft
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(file,true);
			bw = new BufferedWriter(fw);

			bw.write("Line3\n");
			bw.write("Line4\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			FileUtils.close(bw, fw);
		}
	}
	public static void print(File ...files) {
		for(File file: files) {
			System.out.println(file.getPath());
		}
	}
	public static void open (File file) {
		try {
			Desktop.getDesktop().open(file);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void close(AutoCloseable...closeables) {
		for(AutoCloseable clo:closeables) {
			try {
				clo.close();
			} catch (Exception e) {
				System.out.println("error:" + e);
			}
		}
	}
	@SuppressWarnings("resource")
	public static <T> List<T> readObject(File file){
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			
			return safeList(ois.readObject());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Collections.emptyList();
	}
	@SuppressWarnings("unchecked")
	private static <T> List<T> safeList(Object o){
		return(List<T>) o;
	}
	public static void writeObject(File file, Object o) {
		FileOutputStream fos= null;
		ObjectOutputStream oos=null;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(o);
			oos.close();
			fos.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}