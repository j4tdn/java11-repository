package bt02;

import utils.FileUtils;
import static utils.FileUtils.*;

import common.Extension;

public class Bt02 {

	private static final String path = "images";
	
	public static void main(String[] args) {
		// create file image
		createFileImages(path, 30, Extension.values());
		
		// rename file 
		renameFiles(path, Extension.png);
		renameFiles(path, Extension.jpg);
		
	}
}
