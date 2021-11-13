package demo274;

//cmd+shift+f

public class Ex01 {
	static int age=20;
	public static void main()
	{
		  System.out.println("2nd main");	
	}
	public static void main(String[] args)
	{
	  main();	
	}
	public static void Publicstaticmethod()
	{
		  System.out.println("Public static methor");	
	}
	public static void Privatestaticmethod()
	{
		  System.out.println("private static methor");	
	}

	public void Publicmethod()
	{
		  System.out.println("Public methor");	
	}
	public void Privatemethod()
	{
		  System.out.println("private methor");	
	} 

}
class Ex01TestVM1{
	public static void main(String[] args)
	{
		
		//static
		//ham co static co the dung class.tenmethod
		Ex01.Publicstaticmethod();
		
		//ham k co static public tao tham chieu tro ve doi tuong
		//non_static
		Ex01 that= new Ex01();
		that.Privatemethod();
	
	}
}