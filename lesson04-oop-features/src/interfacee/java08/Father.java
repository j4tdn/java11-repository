package interfacee.java08;

public interface Father {

	// abstract method
	void adn();

	default void playSport() {
		System.out.println("Football");

	}

	static void drinlAlcohok(int qty) {
		System.out.println(qty > 4 ? "Drunk" : "Continue");
	}

}
