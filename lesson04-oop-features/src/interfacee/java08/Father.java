package interfacee.java08;

public interface Father {
	void adn();
	void drinkBeer();
	default void playSports() {
		System.out.println("Football");
	}
	static void drinkAlcohol(int qty) {
		System.out.println(qty > 10 ? "Drunk" : "Continue");
	}
}
