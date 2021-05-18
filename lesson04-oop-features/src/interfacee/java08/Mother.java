package interfacee.java08;

public interface Mother {
	// abstract method
	void adn();

	default void playSports() {
		System.out.println("Badminton");

	}

	static void dringkAlcohol(int qty) {
		System.out.println(qty > 10 ? "Drunk" : "continue");
	}

}
