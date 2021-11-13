package inheritance.java8;

public interface KeyEvent {
	void keyPress();

	void keyEnter();

	void keyClick();

	// JAVA 8: Default , static methods with body
	default void keyExit() {
		System.out.println("KeyExit");
	}

	static void keyReleased() {
		System.out.println("KeyReleased");
	}

	// JAVA 9
	private void keyShift() {

	}
}
