package Interfacee.java08;

// extend Class
// implements Interface

public class child implements Father,Mother{

	@Override
	public void adn() {
		System.out.println("Child ADN");
		
	}

	@Override
	public void playSport() {
		
		Mother.super.playSport();
		Father.super.playSport();
	}

	

	

}
