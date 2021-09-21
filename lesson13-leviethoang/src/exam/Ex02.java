package exam;

import static utils.FileUtils.*;

import common.Extension;

import static common.Extension.*;
public class Ex02 {
	private static final String Path = "garbage/image";
	private static final Extension[] extensions = {png , jpg};
	
	public static void main(String[] args) {
//		create(Path, 30, extensions);
		
		// rename file .png , .jpg 
		rename(Path, png);
		rename(Path, jpg);
		
	}

}
