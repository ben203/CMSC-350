package project3;

/**
 * 
 * File: NumberFormatException.java 
 * Author: Bedemariam Degef 
 * Date: November 30, 2019 
 * Purpose: User defined exception for invalid inputs 
 * 
 */

/**
 * User defined exception that is thrown for invalid inputs
 * 
 */
public class NumberFormatException extends Exception {

	public NumberFormatException() {
		super();
	}

	public NumberFormatException(String token) {
		super(token);
	}

}