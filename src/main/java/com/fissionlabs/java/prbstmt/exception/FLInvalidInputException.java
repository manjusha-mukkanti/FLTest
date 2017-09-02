/**
 * 
 */
package com.fissionlabs.java.prbstmt.exception;

/**
 * Signals that an attempt to parse the input is failed.
 * 
 * @author Manjusha Mukkanti
 * 
 */
public class FLInvalidInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7555042771026683465L;

	/**
	 * @param message
	 * @param cause
	 */
	public FLInvalidInputException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public FLInvalidInputException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public FLInvalidInputException(Throwable cause) {
		super(cause);
	}

}
