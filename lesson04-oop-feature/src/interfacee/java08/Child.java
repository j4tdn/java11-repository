package interfacee.java08;

// extends Class
// implements Interface


public class Child implements Father, Mother {

	@Override
	public void adn() {
		System.out.println("Child ADN");
	}

	@Override
	public void playSports() {
		Father.super.playSports();
		Mother.super.playSports();
		System.out.println("Play game !!!");
	}






}
