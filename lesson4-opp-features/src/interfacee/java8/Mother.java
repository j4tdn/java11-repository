package interfacee.java8;

public interface Mother {
	void adn();

	default void playSports() {
		System.out.println("Badminton");
	}
	static void drinkBeer(int qty) {
		System.out.println(qty > 10 ? "Drunk: " : "Continue");
	}
}
