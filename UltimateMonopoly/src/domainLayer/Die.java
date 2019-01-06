package domainLayer;

import java.io.Serializable;

/**
 * The Die class is a class which has a face value and a roll functionality
 * @author SAWCON
 *
 */
public class Die  implements Serializable{
	
	public static final int MAX = 6;
	private int faceValue;
	
	/**
	 * Creates a die object by initializing a faceValue using roll function
	 */
	public Die() {
		roll();
	}
	
	/**
	 *Rolls the die and sets the faceValue randomly from 1 to 6 
	 */
	public void roll() {
		faceValue = (int) Math.floor(((Math.random() * MAX)+1));
	}
	/**
	 * Gets the faceValue of the die
	 * @return the faceValue of the die object
	 */
	public int getFaceValue() {
		return faceValue;
	}
}
