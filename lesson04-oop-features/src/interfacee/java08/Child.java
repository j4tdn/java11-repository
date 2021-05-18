package interfacee.java08;

// extends Class
// implements Interface
public class Child implements Father, Mother {

	@Override
	public void playSports() {
		Mother.super.playSports();
		Father.super.playSports();
		System.out.println("Play game !!!");
	}

	@Override
	public void adn() {
	}

}
