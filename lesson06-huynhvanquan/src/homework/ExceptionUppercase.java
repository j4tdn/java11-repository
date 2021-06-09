package homework;

public class ExceptionUppercase extends RuntimeException {

	private static final long serialVersionUID = 3637826298846983724L;
	public ExceptionUppercase() {
	}
	public ExceptionUppercase(String message) {
		super(message);
	}
}
