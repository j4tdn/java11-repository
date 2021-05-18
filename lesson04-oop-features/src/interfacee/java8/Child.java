package interfacee.java8;

public class Child implements Father, Mother {
	
	public void adn() {
		System.out.println("Child ADN");
	}

	@Override
	public void playSport() {
		Father.super.playSport();
		Mother.super.playSport();
		System.out.println("Play game !!!");
	}

	

}
