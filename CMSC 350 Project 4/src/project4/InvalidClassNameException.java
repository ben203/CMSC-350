package project4;

/**
 * 
 * File: InvalidClassNameException.java 
 * Author: Bedemariam Degef 
 * Date: December 13, 2019 
 * Purpose: User defined exception for invalid class name
 * 
 */

/**
 * This exception is thrown for an invalid class name
 * 
 */

public class InvalidClassNameException extends Exception {

	public InvalidClassNameException() {

		super();
	}

	public InvalidClassNameException(String token) {

		super(token);
	}

}
