import java.util.Random;

/**
 * This class represents a dice that has a number of faces and can be rolled to generate a random number based on that.
 * 
 * @author James Crocker s4914680
 * @version 1.0
 */
public class Dice {

	private int faceValue;
	private int numOfFaces;
		
	/**
	 * This is the constructor for Dice objects. It sets faceValue to 0, and numOfFaces to the inputted value. This is so
	 * that if needed a Dice with more faces can be made.
	 * 
	 * @param num The value which numOfFaces will be set to.
	 */
	public Dice(int num){
		numOfFaces = num;
	}
	
	/**
	 * This method performs the action of rolling the dice. It generates a random number between 1 and the 
	 * numOfFaces, then sets faceValue to that value and returns it.
	 * 
	 * @return faceValue
	 */
	public int roll(){
		Random rand = new Random();
		faceValue = rand.nextInt(numOfFaces)+1;
		return faceValue;
	}
	
	/**
	 * This method is used to get the faceValue from the Dice. 
	 * 
	 * @return faceValue
	 */
	public int getFaceValue(){
		return faceValue;
	}
}
