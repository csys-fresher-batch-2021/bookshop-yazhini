package in.yazhini.exception;

public class DBException extends RuntimeException {
	/**
	 * This Exception is used to DBException
	 **/
	private static final long serialVersionUID = 1L;

	public DBException(String message) {
		super(message);
	}
}
