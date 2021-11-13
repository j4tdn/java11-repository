package data;

public class Ex04 {
	public static void main(String[] args) {
		
		//ddoituongthiluutru o heap
		//HEAP
		
		//constant pool
		Integer oa =20;
		Integer ob =20;
		Integer oc =50;
		Integer od =30;
		Integer oa1 =50;
		Integer oa2 =20;

		//Store at nomal heap
		Integer oaa = new Integer(20);
		Integer obb = new Integer(20);
		Integer occ = new Integer(40);
		//Array
//		hash("oa: ",oa);
//		hash("ob: ",ob);
//		hash("oc: ",oc);
//		hash("od: ",od);
//		hash("oa1: ",oa1);
//		hash("oa2: ",oa2);
//		hash("oaa: ",oaa);
		System.out.println(Character.isDigit('a'));

	}
	
	private static void hash(String text, Integer value)
	{
		System.out.println( text + System.identityHashCode(value));
	}

}