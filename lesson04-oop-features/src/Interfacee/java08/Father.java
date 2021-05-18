package Interfacee.java08;

public interface Father {
	void adn();
	static void drinkAlocol(int qty) {
		System.out.println(qty >3 ?"drunk":"continue");
	};
	default void playSport() {
		System.out.println("Football");
	}

}
