package inheritance.java8;

public interface Father {
	void adn();
	
	default void playSports()
	{
		System.out.println("Football");
	}
	static void drinkAlcohol(int qty)
	{
		System.out.println("Father drink "+qty+" as max !");
	}
}
