package inheritance.java08;

public interface KeyEvent {
	void keyPress();
	void keyEnter();
	void keyClick();
	
	// JAVA08: Default, Static methods with body
	default void keyExit() {
		System.out.println("KeyExit");
	}
	static void keyReleased() {
		System.out.println("KeyReleased");
	}
	
	private void keyShift() {
		
	}
}
