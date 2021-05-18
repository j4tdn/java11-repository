package interfacee.java8;


//extends la ke thua tu Class
//implements tu Interface
public class Child implements Father, Mother  {

	@Override
	public void adn() {
		System.out.println("Child ADN");

	}

	@Override
	public void playSports() {
		// TODO Auto-generated method stub
		//ham nonstatic moi dung ke thua, con static lay class cham
		Father.super.playSports();
		Mother.super.playSports();
	}

	 
}
