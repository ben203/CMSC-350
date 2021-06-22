package project3;

/**
 * 
 * File: BST.java 
 * Author: Bedemariam Degef 
 * Date: November 30, 2019
 * Purpose:Generic class for the binary search tree
 * 
 */
public class BST<T extends Comparable<T>> {

	private Node root;// The root node
	private StringBuilder result = new StringBuilder();// StringBuilder with no characters

	/**
	 * Default Constructor for binary search tree
	 * 
	 * @throws NumberFormatException
	 */
	public BST(String value) throws NumberFormatException {
		root = null;
		result.setLength(0); // Resets result

		if (!(value).matches("[0-9-\\s/]+")) {
			throw new NumberFormatException();// throws an exception for invalid inputs
		}
	}

	/**
	 * Inserts Node into binary search tree, First node becomes the root
	 * 
	 * @param value Integer or Fraction stored in node
	 */
	public void insertNode(T value) {

		if (root == null) { // if there is no root
			root = new Node(value); // current node is root
			return;

		}

		insertNodeRecursive(value, root); // else call insertNodeRecursive(current node, root node)
	}

	/**
	 * Determines where each node should be placed in binary search tree
	 * 
	 * @param value Integer or Fraction stored in node
	 * @param node  Node that current value is compared to, determines location in
	 *              tree
	 */
	public void insertNodeRecursive(T value, Node node) {

		if (value.compareTo(node.value) <= 0) { // if current node is <= previous node
			if (node.left != null) { // and left node is not null
				insertNodeRecursive(value, node.left); // recurse with new values (current node, left node)
			} else { // else insert current node on left
				node.left = new Node(value);
			}
		} else if (value.compareTo(node.value) > 0) { // if current node is > previous node
			if (node.right != null) { // and right node is not null
				insertNodeRecursive(value, node.right); // recurse with new values (current node, right node)
			} else { // else insert current node on right
				node.right = new Node(value);
			}
		}
	}

	/**
	 * Gets Ascending Sort Order of List
	 * 
	 * @return List of ordered elements
	 */
	public String getAscending() {
		inorderTraversal(root);
		return result.toString();
	}

	/**
	 * Reverses Order of getAscending()
	 * 
	 * @return List of ordered elements
	 */
	public String getDescending() {
		getAscending();

		// Splits Ascending into array of numbers
		String[] nums = result.toString().split(" "); // result string is put into an array
		result.setLength(0); // resets result String
		int len = nums.length; // gets length of array

		// iterates over array to reverse order of numbers
		for (int i = len - 1; i >= 0; i--) {
			result.append(nums[i]).append(" ");
		}
		return result.toString();
	}

	/**
	 * Builds a String of the inorder traversal of the binary search tree
	 * 
	 * @param root Root value of each subtree within binary search tree
	 */
	public void inorderTraversal(Node root) {
		if (root.value != null) {
			if (root.getLeft() != null)
				inorderTraversal(root.getLeft()); // Checks for child on the left
			String res = (root.value).toString(); // Get toString for root/parent node
			result.append(res).append(" ");
			if (root.getRight() != null)
				inorderTraversal(root.getRight()); // Checks for child on the right
		}
	}

	/**
	 * Defines the nodes in the binary search tree
	 */
	private class Node {

		private T value; // key
		private Node left, right;// children nodes

		// Creates a node with specified vale
		Node(T value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

		// Returns the left child
		Node getLeft() {
			return left;
		}

		// Returns the right child
		Node getRight() {
			return right;
		}
	}
}