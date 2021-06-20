package interfacee.java08;

public interface Mother {
	void adn();
	
	static void drinkAlcohol(int qty) {
		System.out.println(qty > 10 ? "Drunk" : "continue");
	}
	
	default void playSports() {
		System.out.println("Badminton");
	}
}
