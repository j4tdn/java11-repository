package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;

import bean.Extension;

public class FileUtils {
	
	private static final Random rd = new Random();
	
	public FileUtils() {
	}
	
	public static File createFile(String pathFile) {
		 try {
			Path path = Files.createFile(Paths.get(pathFile));
			return path.toFile();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static File createDir(String pathDir) {
		 try {
			Path path = Files.createDirectories(Paths.get(pathDir));
			return path.toFile();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static File[] createFile(String source, int nof, Extension[] exts) {
		File[] result = new File[nof];
		File dirFile = new File(source);
		
		if(!dirFile.exists()) {
			FileUtils.createDir(source);
		}
		
		int count = 0;
		
		while(count != nof) {
			String name = "" + System.currentTimeMillis() 
									+ exts[rd.nextInt(exts.length)].val();
			File file = FileUtils.createFile(source + File.separator + name);
			
			if(file != null) {
				result[count] = file;
				count++;
			}
		}
		return result;
	}
	
	public static File[] createFileImages(String source, int nof, Extension[] exts) {
		File[] result = new File[nof];
		File dirFile = new File(source);
		
		if(!dirFile.exists()) {
			FileUtils.createDir(source);
		}
		
		int count = 0;
		
		while(count != nof) {
			String name = "" + System.currentTimeMillis() 
						 + exts[rd.nextInt(2)].val();
			File file = FileUtils.createFile(source + File.separator + name);
			
			if(file != null) {
				result[count] = file;
				count++;
			}
		}
		return result;
	}
	
	public static String move(File source,  File target, Extension exts) {
		
		File[] files = source.listFiles(file ->
						file.isFile() && file.getName().endsWith(exts.val()));
		
		if(files.length == 0) {
			return "Move fail !";
		}
		
		for(File file : files) {
			try {
				Files.move(Paths.get(source.getName() + File.separator + file.getName()),
						   Paths.get(source.getName() + File.separator + target.getName() + File.separator + file.getName()),
						   StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				System.out.println("Move " + file.getName() + " fail !");
				e.printStackTrace();
			}
		}
		return "Move successful !";
	}
	
    public static String copy(File source,  File target, Extension exts) {
		
		File[] files = source.listFiles(file ->
						file.isFile() && file.getName().endsWith(exts.val()));
		
		if(files.length == 0) {
			return "Copy fail !";
		}
		
		for(File file : files) {
			try {
				Files.copy(Paths.get(source.getName() + File.separator + file.getName()),
						   Paths.get(source.getName() + File.separator + target.getName() + File.separator + file.getName()),
						   StandardCopyOption.COPY_ATTRIBUTES);
			} catch (IOException e) {
				System.out.println("Copy " + file.getName() + " fail !");
				e.printStackTrace();
			}
		}
		return "Copy successful !";
	}
    
    public static String delete(File source, Extension exts) {
    	
    	File[] files = source.listFiles(file ->
    				file.isFile() && file.getName().endsWith(exts.val()));
    	
    	if(files.length == 0) {
    		return "Delete fail !";
    	}
    	
    	for(File file : files) {
    		file.delete();
    	}
    	return "Delete successful !";
    }
    
    public static String rename(File source, Extension exts) {
    	
    	File[] files = source.listFiles(file ->
    				file.isFile() && file.getName().endsWith(exts.val()));
    	
    	if(files.length == 0) {
    		return "Rename fail !";
    	}
    	
    	boolean result;
    	int count = 1;
    	
    	for(int i = 0; i < files.length; i++) {
    		try {
				result = files[i].renameTo(new File(source.getCanonicalPath() + File.separator + count + exts.val()));
				
				if(result) {
					count++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	return "Rename successful !";
    }
	
}
