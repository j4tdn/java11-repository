package inheritance.java08;

public interface Mother {
	void adn();

	default void playSports() {
		System.out.println("Badminton");
	}

	static void drinkAlcohol(int qty) {
		System.out.println( qty + "glasses are no problem with mother");
	}
}
