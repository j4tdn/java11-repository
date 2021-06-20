ppackage interfacee.java08;

public interface Father {
	void adn();
	
	static void drinkAlcohol(int qty) {
		System.out.println(qty > 3 ? "Drunk" : "continue");
	}
	
	default void playSports() {
		System.out.println("Football");
	}
}