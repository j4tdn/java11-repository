package interfacee.java08;

public class Child implements Father, Mother{

	@Override
	public void adn() {
		System.out.println("child ADN");
	}

	@Override
	public void playSports() {
		// TODO Auto-generated method stub
		Father.super.playSports();
		Mother.super.playSports();
		System.out.println("play game");
	}