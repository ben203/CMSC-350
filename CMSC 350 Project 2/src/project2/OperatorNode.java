package project2;

/**
 * Filename:    OperatorNode.java
 * Author:      Bedemariam Degef
 * Date:        November 15, 2019 
 * Description: Creates the OperatorNodes and assigns OperandNodes as children nodes
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OperatorNode implements Node {

	private String operator;// operator from the input
	private Node right, left;// children nodes for the operands
	private static int countR; // register count

	/**
	 * Initialize the instance variables
	 * 
	 * @param operator the operator used in the expression
	 * @param right    the right child
	 * @param left     the left child
	 */
	public OperatorNode(String operator, Node right, Node left) {
		this.operator = operator;

		this.right = right;

		this.left = left;

	}

	/**
	 * Traverse the tree inOrder walk and return string containing Infix version of
	 * the input
	 * 
	 * <left child> <root> <right child>
	 * 
	 * @return Infix
	 */

	public String inOrderWalk() {

		return "(" + left.inOrderWalk() + " " + operator + " " + right.inOrderWalk() + ")";
	}

	/**
	 * Helper method for postOrderWalk to reset R
	 * 
	 * @throws IOException
	 */
	public void write() throws IOException {
		countR = 0;// Reset R after a new postfix
		postOrderWalk(); // Postorder traversal and write to a file after every postfix input
	}

	/**
	 * Traverse the tree in postOrder walk , then writes each step in the expression
	 * to a file
	 * 
	 * <left child> <right child> <root>
	 * 
	 * @throws IOException
	 * @return result of address count
	 */
	public String postOrderWalk() throws IOException {

		String leftValue = left.postOrderWalk();// left child

		String rightValue = right.postOrderWalk();// right child

		String opValue = operatorEval(this.operator);// the operator

		String result = "R" + countR++;// display register count

		// Creates string with a step in the expression
		String step = opValue + " " + result + " " + leftValue + " " + rightValue;

		writeToFile(step);// writes to file

		return result;
	}

	/**
	 * Assassin a word to each operator
	 * 
	 * @param operator
	 * @return word representation of the operator
	 */
	private String operatorEval(String operator) {
		String o = "";

		switch (operator) {
		case "+":
			o = "Add";
			break;
		case "-":
			o = "Sub";
			break;
		case "*":
			o = "Mul";
			break;
		case "/":
			o = "Div";
			break;
		}

		return o;
	}

	/**
	 * Creates a new file and writes the steps and addresses on it
	 * 
	 * @param A step in the input
	 * @throws IOException
	 */
	private void writeToFile(String step) throws IOException {
		File file = new File("Output.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
		bw.write(step);
		bw.newLine();

		bw.close();

	}
}