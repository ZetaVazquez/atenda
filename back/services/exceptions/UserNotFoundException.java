package services.exceptions;

import exceptions.ATendaException;

public class UserNotFoundException extends ATendaException{

	public UserNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

}
