package interfacee.java08;

public interface Father {
	void adn();
	default void playSports() {
		System.out.println("Football");
	}
	
	static void drinkAhocol(int qty) {
		System.out.println(qty > 3 ? "Drunk" : "Continue");
	}

}
