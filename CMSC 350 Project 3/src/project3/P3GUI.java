package project3;

import java.awt.GridLayout;

/**
 * 
 * File: P3GUI.java 
 * Author: Bedemariam Degef 
 * Date: November 30, 2019 
 * Purpose:This class is used to design and implement the GUI
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class P3GUI extends JFrame {
	private JPanel panel = new JPanel(); // A Jpanel for the GUI
	private JPanel p1 = new JPanel();// A panel to be added at the bottom left
	private JPanel p2 = new JPanel();// A panel to be added at the bottom right
	private JLabel lable1 = new JLabel("Original List"); // A label to be added to the left of the input
	private JTextField input = new JTextField("", 20);// Text field with 20 columns for the input
	private JLabel lable2 = new JLabel("Sorted List");// A label to be added to the left of the output
	private JTextField output = new JTextField("", 20); // Text field with 20 columns for the output

	private JButton perform_Sort_Button = new JButton("Perform Sort"); // The perform sort button
	private JRadioButton ascending_RB = new JRadioButton("Ascending");// Radio button for ascending values
	private JRadioButton descending_RB = new JRadioButton("Descending");// Radio button for descending values
	private JRadioButton integer_RB = new JRadioButton("Integer");// Radio button for integer values
	private JRadioButton fraction_RB = new JRadioButton("Fraction");// Radio button for fraction values

	private ButtonGroup group1 = new ButtonGroup();// Grouping the Radio buttons
	private ButtonGroup group2 = new ButtonGroup();// Grouping the Radio buttons

	/**
	 * A constructor with no parameters
	 * 
	 */
	public P3GUI() {
		super("Binary Search Tree Sort");// title of the GUI
		getContentPane().add(panel);// use the custom panel
		setSize(545, 450);// Set the size of the frame
		setLocationRelativeTo(null); // Set the frame in the middle
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Exit after close button clicked
		panel.setLayout(null);// Set to null in oder to arrange the components
		setVisible(true); // Set the frame visible
		output.setEditable(false); // Set the output uneditable

		// Add the buttons in a button group
		group1.add(ascending_RB);
		group1.add(descending_RB);
		group2.add(integer_RB);
		group2.add(fraction_RB);

		// Select the buttons by default
		ascending_RB.setSelected(true);
		integer_RB.setSelected(true);

		// Adding and positioning the components
		panel.add(lable1);
		lable1.setBounds(100, 5, 100, 20);
		panel.add(input);
		input.setBounds(200, 5, 300, 20);
		panel.add(lable2);
		lable2.setBounds(100, 100, 100, 20);
		panel.add(output);
		output.setBounds(200, 100, 300, 20);

		panel.add(perform_Sort_Button);
		perform_Sort_Button.setBounds(250, 180, 150, 50);

		GridLayout experimentLayout = new GridLayout(2, 0);
		p1.setBorder(BorderFactory.createTitledBorder("Sort Order"));
		p1.setLayout(experimentLayout);
		p1.setBounds(5, 315, 200, 110);
		p1.add(ascending_RB);
		p1.add(descending_RB);
		panel.add(p1);

		p2.setBorder(BorderFactory.createTitledBorder("Numeric Type"));
		p2.setLayout(experimentLayout);
		p2.setBounds(340, 315, 200, 110);
		p2.add(integer_RB);
		p2.add(fraction_RB);
		panel.add(p2);

		perform_Sort_Button.addActionListener(actionListener);// Action listener for the perform sort button

	}

	/**
	 * 
	 * Action listener for the construct tree button
	 * 
	 * @param a
	 * 
	 */
	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

			String userInput = input.getText();
			try {
				// Ensures List has a value
				if (userInput.isEmpty()) {
					throw new NullPointerException();
				}

				// Tokenize String
				String[] tokens = userInput.split(" ");

				// Check for duplicate values

				int duplicates = 0;
				for (int i = 0; i < tokens.length; i++) {

					for (int j = i + 1; j < tokens.length; j++) {

						if (tokens[i].equals(tokens[j])) {
							duplicates++;

						}
					}
				}
				// JOptionPane window to display a message on duplicates
				if (duplicates > 0) {

					JOptionPane.showMessageDialog(null, "Duplicates found");

				} else {

					JOptionPane.showMessageDialog(null, "No duplicates found");
				}

				// Integer binary search tree
				if (integer_RB.isSelected()) {

					// Creates Integer binary search tree instance

					BST<Integer> bst = new BST<>(input.getText());
					// Tokenize and add to binary search tree
					for (String token : tokens) {

						bst.insertNode(Integer.parseInt(token));
					}

					// Outputs Integer binary search tree in either Ascending or Descending Order
					if (ascending_RB.isSelected()) {
						output.setText(bst.getAscending());
					} else if (descending_RB.isSelected()) {
						output.setText(bst.getDescending());
					}
				}

				// Fraction binary search tree
				if (fraction_RB.isSelected()) {

					// Creates String binary search tree instance
					BST<Fraction> bst = new BST<>(userInput);

					// Tokenize and add to binary search tree
					for (String token : tokens) {
						Fraction fraction = new Fraction(token);
						bst.insertNode(fraction);
					}

					// Outputs Fraction binary search tree in either Ascending or Descending Order
					if (ascending_RB.isSelected()) {
						output.setText(bst.getAscending());
					} else if (descending_RB.isSelected()) {
						output.setText(bst.getDescending());
					}
				}

				// Outputs the caught exceptions

			} catch (NullPointerException e1) {
				JOptionPane.showMessageDialog(null, "Please enter your input", "", JOptionPane.ERROR_MESSAGE);
			} catch (MalformedFractionException e2) {
				JOptionPane.showMessageDialog(null, "Improper fraction format is used", "",
						JOptionPane.ERROR_MESSAGE);
			} catch (NumberFormatException e3) {
				JOptionPane.showMessageDialog(null, "Please enter a valid input", "", JOptionPane.ERROR_MESSAGE);
			}
		}
	};

	/**
	 * A main method to create and run the GUI
	 * 
	 * @param args
	 * 
	 */
	public static void main(String args[]) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new P3GUI();
			}
		});

	}

}
