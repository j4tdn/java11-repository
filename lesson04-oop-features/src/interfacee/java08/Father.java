package interfacee.java08;

public interface Father {
	// abstract method
	void adn();

	default void playSports() {
		System.out.println("Football");
	}

	static void drinkAlcohol(int qty) {
		System.out.println(qty > 3 ? "Drunk" : "Continue");
	}
}
