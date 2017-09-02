/**
 * 
 */
package com.fissionlabs.java.prbstmt.exception;

/**
 * An exception that occurs when operating on solving FL problem statement.
 * 
 * @author Manjusha Mukkanti
 * 
 */
public class FLProcessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8106426105431325978L;

	/**
	 * @param message
	 * @param cause
	 */
	public FLProcessException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public FLProcessException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public FLProcessException(Throwable cause) {
		super(cause);
	}

}
