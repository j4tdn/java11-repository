package interfacee.java8;

public interface Father {
	//ham k co than ham dc goi la abstract method	
	void adn();
	
	default void playSports() {
		System.out.println("Football");
	}
	static void drinkBeer(int qty) {
		System.out.println(qty > 3 ? "Drunk: " : "Continue");
	}
}
