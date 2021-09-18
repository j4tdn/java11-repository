package ex01;


import common.Extension;
import utils.FileUtils;

public class App {
	private static final String Image = "garbage/image";
	private static final String System = "garbage/system";
	
	public static void main(String[] args) {
		
		//boolean[] createFiles = FileUtils.create("garbage", 20, Extension.values());

		Extension[] imageExts = {Extension.jpg, Extension.png, Extension.jpeg};
		Extension[] musicExts = {Extension.mp3, Extension.mp4};
		Extension[] systemExts = {Extension.bat};
		
		
 		FileUtils.moveMultipFile("garbage", Image , imageExts);
		FileUtils.deleteFile("garbage", Extension.txt);
		FileUtils.moveMultipFile("garbage", "garbage/music", musicExts);	
		FileUtils.moveMultipFile("garbage", System, systemExts);	
		FileUtils.copyFile("garbage", "garbage/coding", Extension.java);
		//System.out.println("===End Ex01====");
	}

}
