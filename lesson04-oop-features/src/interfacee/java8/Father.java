package interfacee.java8;

public interface Father {


	void adn();
	default void playSport() {
		System.out.println("Football");
	}
	
	static void drinkAlcohol(int qty) {
		System.out.println(qty > 3 ? "Drunk" : "Continue" );
	}
	
	
}
