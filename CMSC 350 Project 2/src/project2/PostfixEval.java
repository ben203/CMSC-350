package project2;

/**
 * Filename: PostfixEval.java 
 * Author: Bedemariam Degef 
 * Date: November 15, 2019 
 * Description: Evaluates and convert the postfix expression into infix expression
 *  
 */

import java.io.IOException;
import java.util.Stack;

public class PostfixEval {

	private Stack<Node> inputStack = new Stack<>();// Stacks for the user input
	private Node nd;// node object

	/**
	 * Evaluates the input postfix expression and returns the postfix expression
	 * 
	 * @param Userinput
	 * @return Infix Expression
	 * @throws InvalidInputException
	 * @throws IOException
	 */
	String evaluate(String input) throws InvalidInputException, IOException {

		// Trims excess white spaces
		input = input.trim().replaceAll(" +", " ");

		// Break the user input into tokens for evaluation
		String[] tokens = input.split(" ");

		// For each loop to analyze each tokens
		for (String token : tokens) {

			// If an input that is not a number or operator is found throw
			// InvalidInputException
			if (!token.matches("[\\d.?]+") && !token.matches("[*/+\\-]")) {
				throw new InvalidInputException(token);
			}

			// If it is a number create an operand node and push it onto the stack
			if (token.matches("[\\d.?]+")) {

				inputStack.push(new OperandNode(token));

				// If it is an operator create an operator node by assigning
				// left and right children to it then push it into the Stack
			} else if (token.matches("[*/+\\-]")) {

				nd = new OperatorNode(token, inputStack.pop(), inputStack.pop());

				inputStack.push(nd);

			}
		}

		// Write to File
		nd.write();

		// Return the Infix Expression
		return inputStack.pop().inOrderWalk();
	}

}