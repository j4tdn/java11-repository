package inheritance.java8;

public class Child implements Father, Mother {
	@Override
	public void adn() {

	}

	@Override
	public void playSports() {
		Father.super.playSports();
		Mother.super.playSports();
		System.out.println("Game");
	}

}
