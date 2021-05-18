package Interfacee.java08;

public interface Mother {
	void adn();

	static void drinkAlocol(int qty) {
		System.out.println(qty >10 ?"drunk":"continue");
	};
	default void playSport() {
		System.out.println("Badminton");
	}
}
