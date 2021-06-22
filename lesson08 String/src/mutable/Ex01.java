package mutable;

import javax.sound.sampled.ReverbType;

import util.jvmUtil;

public class Ex01 {
	public static void main(String[] args) {
		// Immutable:
		String i = "Box";
		jvmUtil.hash("i", i);

		i = i.concat("Layout");
		jvmUtil.hash("i2", i);

		System.out.println("value i: " + i);

		StringBuffer m = new StringBuffer("Singleton");// dung de noi chuoi maf ton it o nho nhat con + tao ra nhieu o nho
		jvmUtil.hash("m1", m);
		m = m.append("Patten")
		     .append("Java")
		     .reverse();
		     
		jvmUtil.hash("m2", m); 
		
		System.out.println("value m: " + m);
	}

}
