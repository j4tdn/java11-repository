package inheritance;

public class App {
	public static void main(String[] args) {
		//Parent #number(11) #text(Parent) #log(Log in Parent class ! )
		//Child #number(12) #text(Child) #log(Log in Child class ! )
		//override method, no override attribute
		
		ParentIrt p = new ChildIrt();
		System.out.println(p.number);// vi no khong duoc dinh override
		System.out.println(p.text);// nen van sua dung lai lop cha 
		p.log();
		// chi override phuong thuc duoc thoi
		// khong duoc override thuoc tinh
	}

}
