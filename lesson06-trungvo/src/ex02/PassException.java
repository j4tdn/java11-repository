package ex02;

public class PassException extends RuntimeException {

	private static final long serialVersionUID = 6168750759757079245L;
	
	public PassException(String message) {
		super(message);
	}
}
