package project4;

/**
 * *
 * File: P3GUI.java 
 * Author: Bedemariam Degef 
 * Date: December 13, 2019 
 * Purpose:This class is used to design and implement the GUI
 * 
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class P4GUI extends JFrame {

	private Graph<String> directed_Graph; // Graph object

	private JPanel panel = new JPanel(); // A Jpanel for the GUI

	private JPanel p1 = new JPanel();// The panel with label text field and buttons
	private JPanel p2 = new JPanel();// The panel right below to show the recompilation order
	private JTextField file_Input = new JTextField(20);// Text field with 20 columns for the file name
	private JTextField class_Input = new JTextField(20);// Text field with 20 columns for the class name
	private JTextArea output = new JTextArea(9, 48);// Text Area to display the output
	private JLabel lable1 = new JLabel("Input file name:");// A label to be added to the left file_Input
	private JLabel lable2 = new JLabel("Class to recompile:");// A label to be added to the left class_Input
	private JButton build_Button = new JButton("Build Directed Graph");// Build directed graph button
	private JButton order_Button = new JButton("Topological Order");// Topological order button

	public P4GUI() {
		super("Class Dependency Graph");// Title of the GUI
		getContentPane().add(panel);// Returns the contentPane object for this frame
		setVisible(true); // Set the frame visible
		setSize(600, 400);// Set the size of the frame
		setLocationRelativeTo(null); // Set the frame in the middle
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Exit after close button clicked
		panel.setLayout(null);// Set to null in oder to arrange the components
		p1.setLayout(null); // Set to null in order to arrange the components

		// Adding and positioning the components
		p1.setBorder(BorderFactory.createTitledBorder(""));
		p1.add(lable1);
		lable1.setBounds(40, 40, 100, 20);
		p1.add(lable2);
		lable2.setBounds(40, 90, 150, 20);

		p1.add(file_Input);
		file_Input.setBounds(200, 40, 180, 25);
		p1.add(class_Input);
		class_Input.setBounds(200, 90, 180, 25);

		p1.add(build_Button);
		build_Button.setBounds(400, 40, 180, 25);
		p1.add(order_Button);
		order_Button.setBounds(400, 90, 180, 25);
		p1.setBounds(2, 5, 598, 190);

		p2.setBorder(BorderFactory.createTitledBorder("Recompilation Order "));
		p2.add(output);
		output.setEditable(false);
		p2.setBounds(2, 195, 598, 185);

		panel.add(p1);
		panel.add(p2);

		build_Button.addActionListener(build_ActionListener);// ActionListener for the graph building button
		order_Button.addActionListener(order_ActionListener);// ActionListener for the topological order button
	}

	/**
	 * 
	 * Action listener for the build directed graph button
	 * 
	 * @param e
	 * 
	 */
	ActionListener build_ActionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

			// Create a new graph
			directed_Graph = new Graph<>();

			try {

				// Build a directed graph from a file
				directed_Graph.buildDirectedGraph(directed_Graph.tokenizeFile(file_Input.getText()));

				JOptionPane.showMessageDialog(null, "Graph Built Successfully", "", JOptionPane.INFORMATION_MESSAGE);

			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "File Did Not Open", "", JOptionPane.ERROR_MESSAGE);

			}
		}
	};

	/**
	 * 
	 * Action listener for the topological order button
	 * 
	 * @param a
	 * 
	 */

	ActionListener order_ActionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent a) {

			try {

				// Output the topological order for the recommendation list
				output.setText(directed_Graph.generateTopologicalOrder(class_Input.getText()));

			} catch (InvalidClassNameException e1) {
				JOptionPane.showMessageDialog(null, "Invalid Class Name: " + class_Input.getText(), "",
						JOptionPane.ERROR_MESSAGE);
			} catch (GraphCycleException e2) {
				JOptionPane.showMessageDialog(null, "The graph contains a Cycle", "", JOptionPane.ERROR_MESSAGE);
			}
		}
	};

	/**
	 * A main method to create and run the GUI
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new P4GUI();
			}
		});

	}

}
