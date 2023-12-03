package exceptions;

public class ATendaException extends Exception {

	private static final long serialVersionUID = 1L;

	public ATendaException() {
		super();
	
	}

	public ATendaException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ATendaException(String message) {
		super(message);
	
	}

	public ATendaException(Throwable cause) {
		super(cause);

	}

}
