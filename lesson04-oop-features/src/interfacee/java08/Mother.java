package interfacee.java08;

public interface Mother {
	void adn();
	default void playSports() {
		System.out.println("Badminton");
	}
	
	static void drinkAhocol(int qty) {
		System.out.println(qty > 10 ? "Drunk" : "Continue");
	}

}
