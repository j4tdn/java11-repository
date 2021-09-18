package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import common.Extension;
import common.Extension2;

public class FileUtils {
	private static final Random rd = new Random();

	public FileUtils() {

	}

	public static File create(String path) {
		boolean isvalid = true;
		File file = new File(path);
		if (!file.exists()) {
			File parent = file.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdir();
			}
			try {
				isvalid = file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return isvalid ? file : null;
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
	public static boolean[] create(String dirPath, int nof, Extension2[] exts) {
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

	public static void move(String pathOld, String pathNew, Extension extension) {
		File newFile = new File(pathOld);
		File[] files = newFile.listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				return pathname.isFile() && pathname.getName().endsWith(extension.val());
			}
		});
		for (File file : files) {

			if (file.renameTo(new File(pathNew + file.getName()))) {
				System.out.println("File is moved successful!");
			} else {
				System.out.println("File is failed to move!");
			}
		}
	}

	public static void delete(String folder, Extension ext) {
		File dir = new File(folder);
		File[] files = dir.listFiles(new FileFilter() {

			@Override
			public boolean accept(File name) {
				return name.isFile() && name.getName().endsWith(ext.val());
			}
		});
		for (File file : files) {
			boolean isdeleted = file.delete();
			System.out.println(" is deleted : " + isdeleted);
		}
	}
	
	public static void copy(String pathOld, String pathNew, Extension ext) {
		File dir = new File(pathOld);
		File[] files = dir.listFiles(new FileFilter() {

			@Override
			public boolean accept(File name) {
				return name.isFile() && name.getName().endsWith(ext.val());
			}
		});
		for (File file : files) {
			Path souce = Paths.get(pathOld+ "/" + file.getName());
			Path target = Paths.get(pathNew+ "/" +file.getName());
			
			try {
				Files.copy(souce, target,StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	public static void rename(File[] files, Extension2 e) {

		for (int i = 0; i < files.length; i++) {
			String path = files[i].getParent();
			if (files[i].renameTo(new File(path, i + e.val()))) {
	            System.out.println("Rename succesful");
	        } else {
	            System.out.println("Rename failed");
	        }
		}
	}
	public static void write(String path, int n, int m) {
		BufferedWriter bw = null;
        FileWriter fw = null;
        int[][] data = new int[n][m];
 
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            for(int i = 0; i <n; i++) {
            	for(int j =0; j<m; j++) {
            		data[i][j] = rd.nextInt(10);
            		bw.write(data[i][j]);
            	}
            	System.out.println();
            }
            System.out.println("Success...");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
	}
	
}
;