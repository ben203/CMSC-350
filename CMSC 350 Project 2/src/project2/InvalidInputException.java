package project2;

/**
* 
* File: InvalidInputException.java 
* Author: Bedemariam Degef 
* Date: November 15, 2019 
* Purpose:This class is a custom exception that is thrown when the user enters invalid input
* 
*/

/**
 * User defined exception that is thrown for invalid inputs
 * 
 */
public class InvalidInputException extends Exception {

	public InvalidInputException(String token) {
		super(token);
	}

	public InvalidInputException() {
		super();
	}

}