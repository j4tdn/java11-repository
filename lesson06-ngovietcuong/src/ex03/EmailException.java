package ex03;

public class EmailException extends RuntimeException {
	
	private static final long serialVersionUID = -1903387717660732646L;
	
	public EmailException(String message) {
		super(message);
	}

}
