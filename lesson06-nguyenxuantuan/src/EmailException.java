
public class EmailException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Email không hợp lệ!";
	}

}
