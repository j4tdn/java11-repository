package ex03;

public class EmailException extends RuntimeException {

	private static final long serialVersionUID = -2733163558987818516L;

	public EmailException(String message) {
		super(message);
	}
}
