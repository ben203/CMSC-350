package project2;

import java.io.IOException;

/**
 * Filename: OperandNode.java 
 * Author: Bedemariam Degef 
 * Date: November 15, 2019
 * Description: Creates the OperandNodes used in the Expression Tree
 */

public class OperandNode implements Node {

	private String value;

	/**
	 * Initialize the instance variable
	 * 
	 * @param The number value in the expression
	 */
	public OperandNode(String value) {
		this.value = value;

	}

	/**
	 * Used for creating the Infix Expression
	 * 
	 * @return value of operand
	 */
	public String inOrderWalk() {
		return String.valueOf(value);
	}

	/**
	 * Used for creating the postfix expression
	 * 
	 * @return value of operand
	 */
	public String postOrderWalk() {
		return String.valueOf(value);
	}

	/**
	 * Helper method for postOrderWalk
	 * 
	 * @throws IOException
	 */
	public void write() throws IOException {

	}

}