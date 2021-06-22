package project3;

/**
 * 
 * File: P3GUI.java 
 * Author: Bedemariam Degef 
 * Date: November 30, 2019 
 * Purpose:This class is used to define the fractions
 * 
 */
import java.text.DecimalFormat;

public class Fraction implements Comparable<Fraction> {

	private double numerator;
	private double denominator;
	private double value;

	/**
	 * Default Fraction Constructor
	 * 
	 * @param fraction takes String of a fraction and assigns the value of
	 *                 numerator, denominator, and value.
	 * @throws MalformedFractionException, NumberFormatException
	 *                                     
	 */
	public Fraction(String fraction) throws MalformedFractionException, NumberFormatException {
		String[] convert = fraction.split("/");// converts fraction string to array
		if (convert.length != 2) {
			throw new MalformedFractionException();// throws an exception improper fraction
		}
		numerator = Double.parseDouble(convert[0]);// set numerator
		denominator = Double.parseDouble(convert[1]);// set denominator
		this.value = numerator / denominator; // set value to numerator/denominator
	}

	/**
	 * Gets the value of the Fraction
	 * 
	 * @return numerator/denominator = value
	 */
	public Double getValue() {
		return this.value;
	}

	/**
	 * toString Method for Fraction
	 * 
	 * @return Returns the String representation of the Fraction
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat();
		return df.format(numerator) + "/" + df.format(denominator);
	}

	/**
	 * Is used to determine how fractions are compared for binary search tree
	 * 
	 * @param frac fraction that is being compared
	 * @return -1,0,1 depending if o is <,=,>
	 */
	@Override
	public int compareTo(Fraction frac) {
		if (this.value == frac.getValue()) {
			return 0;
		}
		return this.value > frac.value ? 1 : -1;
	}
}