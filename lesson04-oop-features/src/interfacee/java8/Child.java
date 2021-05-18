package interfacee.java8;

//extends Class
//implements Interface
public class Child implements Father, Mother{

	@Override
	public void adn() {
		System.out.println("Child ADN");
		
	}

	@Override
	public void playSport() {
		Father.super.playSport();
		Mother.super.playSport();
		System.out.println("Play game!!!");
	}


}
