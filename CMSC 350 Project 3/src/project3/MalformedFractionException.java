package project3;

/**
 * 
 * File: MalformedFractionException.java 
 * Author: Bedemariam Degef 
 * Date: November 30, 2019 
 * Purpose: User defined exception for improper fractions
 * 
 */

/**
 * User defined exception that is thrown for improper fractions
 * 
 */
public class MalformedFractionException extends Exception {
	public MalformedFractionException() {
		super();
	}

	public MalformedFractionException(String token) {
		super(token);
	}

}