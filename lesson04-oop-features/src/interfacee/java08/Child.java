package interfacee.java08;

public class Child implements Father, Mother {

	@Override
	public void adn() {
		System.out.println("Child");

	}

	@Override
	public void playSport() {
		Father.super.playSport();
		Mother.super.playSport();
		System.out.println("Play game !!!");
	}

}
