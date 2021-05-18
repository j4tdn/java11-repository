package interfacee.java08;

//extend Class
//implements Interface

public class Child implements Father, Mother {

	@Override
	public void adn() {
		System.out.println("child ADN");
	}

	@Override
	public void playSports() {
		Mother.super.playSports();
		Father.super.playSports();
		System.out.println("Play game !!!");
	}

}
