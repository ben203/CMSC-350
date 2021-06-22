package project4;

/**
 * 
 * File: CycleException.java 
 * Author: Bedemariam Degef 
 * Date: December 13, 2019 
 * Purpose: User defined exception for a graph with cycle 
 * 
 */

/**
 * This exception is thrown if the graph contains a cycle among the Java classes
 * 
 */

public class GraphCycleException extends Exception {

	public GraphCycleException() {

		super();
	}

	public GraphCycleException(String token) {

		super(token);
	}

}
