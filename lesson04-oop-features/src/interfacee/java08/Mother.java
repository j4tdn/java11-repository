package interfacee.java08;

public interface Mother {
	// abstract method
		void adn();

		default void playSport() {
			System.out.println("Badminton");

		}

		static void drinlAlcohok(int qty) {
			System.out.println(qty > 10 ? "Drunk" : "Continue");
		}
}
