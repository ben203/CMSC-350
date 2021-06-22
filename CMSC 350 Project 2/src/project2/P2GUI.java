package project2;

/**
 * 
 * File: P2GUI.java 
 * Author: Bedemariam Degef 
 * Date: November 15, 2019 
 * Purpose:This class creates the GUI and handles the exceptions 
 * 
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.EmptyStackException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class P2GUI extends JFrame implements ActionListener {

	private JFrame frame = new JFrame("Three Address Generator"); // A frame for the GUI
	private JLabel lable1 = new JLabel("Enter Postfix Expression"); // A label to be added to the left of the input
	private JTextField input = new JTextField("", 20);// Text field with 20 columns for the input
	private JButton consTree_Button = new JButton("Construct Tree"); // The evaluation button
	private JLabel lable2 = new JLabel("Infix Expression");// A label to be added the left of the output
	private JTextField output = new JTextField("", 20); // Text field with 20 columns for the output

	/**
	 * A constructor with no parameters
	 * 
	 */
	public P2GUI() {
		frame.setVisible(true); // Set the frame visible
		frame.setSize(500, 250);// Set the size of the frame
		frame.setLocationRelativeTo(null); // Set the frame in the middle
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Exit after close button clicked
		output.setEditable(false);// Set the output text not editable

		JPanel panel1 = new JPanel();// Create a new panel
		panel1.add(lable1); // Add the label the left of the text field
		panel1.add(input); // Add the input text field

		JPanel panel2 = new JPanel();// Create a second panel
		panel2.add(consTree_Button);// Add the button to the second panel

		JPanel panel3 = new JPanel();// Create a third panel
		panel3.add(lable2);// Add the label the left of the text field
		panel3.add(output); // Add the output text field

		frame.add(panel1, BorderLayout.NORTH); // Set the first panel to the top of the frame
		frame.add(panel2, BorderLayout.CENTER);// Set the second panel to the center of the frame
		frame.add(panel3, BorderLayout.SOUTH);// Set the third panel to the bottom of the frame
		consTree_Button.addActionListener(this);// Action listener for the construct tree button

	}

	/**
	 * 
	 * Action listener for the construct tree button
	 * 
	 * @param a
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent a) {
		PostfixEval pe = new PostfixEval();

		try {

			output.setText(pe.evaluate(input.getText()));// Evaluate the input and display the result

		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Please enter a postfix expression.", "", JOptionPane.ERROR_MESSAGE);
		} catch (InvalidInputException e2) {
			JOptionPane.showMessageDialog(null, "Invalid token " + e2.getMessage(), "", JOptionPane.ERROR_MESSAGE);
		} catch (EmptyStackException e3) {
			JOptionPane.showMessageDialog(null, "Invalid postfix expression. ", "", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e4) {
			JOptionPane.showMessageDialog(null, "Error writing on the file.", "", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	/**
	 * A main method to create and run the GUI
	 * 
	 * @param args
	 * 
	 */
	public static void main(String args[]) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new P2GUI();
			}
		});

	}
}
