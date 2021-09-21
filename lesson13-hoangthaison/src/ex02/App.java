package ex02;



import common.Extension;
import utils.FileUtils;

public class App {
	public static void main(String[] args) {
		
		Extension[] extensionsImage = {Extension.jpg, Extension.png};
		
		boolean[] createFiles =  FileUtils.create("garbage/image", 30, extensionsImage);
 		FileUtils.renameFile("garbage/image", Extension.jpg);
 		FileUtils.renameFile("garbage/image", Extension.png);
		
		
	}

}
