package in.yazhini.exception;

public class ServiceException extends RuntimeException {
	/**
	 * This Exception is used to ServiceException
	 **/
	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
		super(message);
	}
}
