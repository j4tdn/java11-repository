package multable;

import utils.JvmUtils;

public class Ex01 {
	public static void main(String[] args) {
		//Immutable: String(Literal, Object)
		String i = "Box"; //constant pool 
<<<<<<< HEAD
		JvmUtils.hash("i", i);
		i = i.concat(" Layout");
=======
		JvmUtils.hash("i1", i);
		i = i.concat(" Layout");   //gan lai gia tri o nho moi
>>>>>>> e260eec (lesson08-string 22.06.2021)
		JvmUtils.hash("i2", i);
		
		System.out.println("Value i: " + i);
		//Mutable: StringBuilder, StringBuffer
<<<<<<< HEAD
		StringBuffer m = new StringBuffer("Singleton"); 	//nomarl- heap
		JvmUtils.hash("m", m);
		m =m.append(" Pattern")
=======
		StringBuffer m = new StringBuffer("Singleton"); 	//normal- heap
		JvmUtils.hash("m1", m);
		m =m.append(" Pattern")   //cong vao gia tri o nho cu
>>>>>>> e260eec (lesson08-string 22.06.2021)
			.append(" Java")
			.reverse();
		JvmUtils.hash("m2", m);
		
		System.out.println("Value m: "+ m);
	}
}
