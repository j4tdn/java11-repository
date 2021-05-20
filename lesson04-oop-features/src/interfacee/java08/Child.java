package interfacee.java08;

// extends Class
// implement Interface
public class Child implements Mother, Father {

	@Override
	public void adn() {
		System.out.println("Child ADN");
	}

	@Override
	public void playSports() {
		// TODO Auto-generated method stub
		Mother.super.playSports();
		Father.super.playSports();
		System.err.println("Play game ");
	}

}
