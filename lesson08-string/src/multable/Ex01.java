package multable;

import utils.JvmUtils;

public class Ex01 {
	public static void main(String[] args) {
		//Immutable: String(Literal, Object)
		String i = "Box"; //constant pool 
		JvmUtils.hash("i", i);
		i = i.concat(" Layout");
		JvmUtils.hash("i2", i);
		
		System.out.println("Value i: " + i);
		//Mutable: StringBuilder, StringBuffer
		StringBuffer m = new StringBuffer("Singleton"); 	//nomarl- heap
		JvmUtils.hash("m", m);
		m =m.append(" Pattern")
			.append(" Java")
			.reverse();
		JvmUtils.hash("m2", m);
		
		System.out.println("Value m: "+ m);
	}
}