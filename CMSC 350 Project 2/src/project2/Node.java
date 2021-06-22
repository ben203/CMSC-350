package project2;

import java.io.IOException;

/**
 * Filename:    Node.java
 * Author:      Bedemariam Degef
 * Date:        November 15, 2019 
 * Description: Helps OperandNodes and OperatorNodes to be stored in the binary Tree.
 */

/**
 * 
 * An interface node used to help create the binary Tree.
 *
 */
public interface Node {

	String inOrderWalk(); // <left child> <root> <right child>

	String postOrderWalk() throws IOException; // <left child> <right child> <root>

	void write() throws IOException; // Helper method for postOrderWalk()
}