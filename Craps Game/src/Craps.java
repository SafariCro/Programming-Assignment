import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents the variables and actions that are done during a game of Craps.
 * 
 * @author James Crocker s4914680
 * @version 1.0
 */
public class Craps {

	private int money;		//represents the players money
	private int bet;		//represents the players bet
	private int sumOfRolls; //represents the sum of dice rolls
	
	Dice dice1;				//represents first dice
	Dice dice2; 			//represents second dice
	
	/**
	 * This method performs the action when a person plays the game. It creates two Dice objects, rolls them, and then 
	 * adds the two rolls together. It does not take any inputs nor does it return anything.
	 */
	public void play(){
		dice1 = new Dice(6);
		dice2 = new Dice(6);
		sumOfRolls = (dice1.roll() + dice2.roll());
	}
	
	/**
	 * This method is used to calculate whether or not the player has won, lost, or drawn based on the sum of their two
	 * rolls.
	 * 
	 * @return "Win" is returned when the sum of the rolls is equal to either 7 or 11. 
	 * "Lose" is returned when the sum of the rolls is equal to either 2, 3, or 11. 
	 * "Draw" is returned when the sum of the rolls is equal to anything else
	 */
	public String gameResult(){
		switch(sumOfRolls){
			case 7: case 11: 
				money  = money + bet;
				return "Win";
			case 2: case 3: case 12:
				money  = money - bet;
				return "Lose";
			default:
				return "Draw";
		}
	}
	
	/**
	 * This is used to set the players bet to the inputted integer.
	 * 
	 * @param num The value that the variable "bet" will be set to.
	 */
	public void setBet(int num){
		bet = num;
	}
	
	/**
	 * This is used to retrieve what the players bet is currently set at.
	 * 
	 * @return The variable bet.
	 */
	public int getBet(){
		return bet;
	}
	
	/**
	 * This is used to set the players money to the inputted integer.
	 * 
	 * @param num The value that money will be set to.
	 */
	public void setMoney(int num){
		money = num;
	}
	
	/**
	 * This is used to retrieve what the players money is currently set at.
	 * 
	 * @return the variable money.
	 */
	public int getMoney(){
		return money;
	}
	
	/**
	 * This is used to get the Dice object dice1 from Craps. This is so that other classes can access the information 
	 * stored in the Dice.
	 * 
	 * @return the Dice object dice1
	 */
	public Dice getDice1(){
		return dice1;
	}
	
	/**
	 * This is used to get the Dice object dice2 from Craps. This is so that other classes can access the information 
	 * stored in the Dice.
	 * 
	 * @return the Dice object dice2
	 */
	public Dice getDice2(){
		return dice2;
	}
	
	/**
	 * This method is mainly to be used for testing. It allows the variable sumOfRolls to be set to an inputted Integer
	 * value.
	 * @param num The value that sumOfRolls will be set to.
	 */
	public void setSumOfRolls(int num){
		sumOfRolls = num;
	}
	
	/**
	 * This method is used for retrieving the variable sumOfRolls.
	 * 
	 * @return The variable sumOfRolls.
	 */
	public int getSumOfRolls(){
		return sumOfRolls;
	}
	
	/**
	 * This method is used to load in the lines of a file that is used to keep track of players scores
	 * @return An arraylist where each part is one line from the file
	 * @param fileLoc The file location of the file that is wanted to be loaded.
	 */
	public ArrayList<String> loadFile(String fileLoc){
		String file = fileLoc;
        String line = "";
        ArrayList<String> scoreList = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((line = br.readLine()) != null) {
                scoreList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.reverse(scoreList);
		return scoreList;
	}
}
