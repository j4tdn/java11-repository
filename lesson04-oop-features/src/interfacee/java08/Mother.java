package interfacee.java08;

public interface Mother {
	void adn();
	default void playSport() {
		System.out.println("Badminton");
	}
	

	static void drinkAlcohol(int qty) {
		System.out.println(qty > 10 ? "Drunk" : "Continue");
	}
}
