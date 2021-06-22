package immutable;

import java.util.Scanner;

import utils.JvmUtils;

public class Ex01 {
	public static void main(String[] args) {
		//String: co 2 dang Immutable & Mutable
		//Immutable (bat bien): Literal , Object 
		
		String o1 = new String( "welcome");
		JvmUtils.hash("o1: ",o1);  //hash la dia chi mac dinh (cua may ao Java) cap cho vung nho de luu tru doi tuong	
		System.out.println("o1: " + o1);
		o1 = new String( "weareone");
		JvmUtils.hash("o1",o1);
		System.out.println("o1: " + o1);
		//k cap nhat dc gia tri
		//java garbage collection instrumentation
		
		
	}
		
	
}

