package interfacee.java08;

public class Child implements Father,Mother {
	@Override
	public void adn() {
		System.out.println("Child ADN");
	}

	@Override
	public void playSports() {
		Mother.super.playSports();
		Father.super.playSports();
		System.out.println("play game");
	}
	
	
}
