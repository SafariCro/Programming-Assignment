import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/** 
 * This class is for creating a GUI for Craps. It features two images representing the players rolls, as well as other components that inform the user of other 
 * game information.
 * 
 * @author James Crocker s4914680
 * @version 1.1
 */
public class CrapsGui {

	private JLabel moneyTitle;
	private JLabel money;
	private JLabel resultTitle;
	private JLabel result;
	private JLabel betTitle;
	
	private JTextField bet;
	private JTextField saveField;
	
	private JButton roll;
	private JButton saveButton;
	
	private JFrame frame;
	private JPanel panel;
	
	//These are used to display the two dice images
	private JLabel dice1;
	private JLabel dice2;
	
	private ImageIcon iconDice1;
	private ImageIcon iconDice2;
	
	private Craps craps;
	private JTable table;
	

	public static void main(String[] args) {
		new CrapsGui();
	}
	
	/**
	 * This is the constructor for the CrapsGui object. It creates all the components for the GUI and then adds it to a panel, then onto a frame. It also initialises
	 * the game by setting the players money.
	 * 
	 * It takes no inputs.
	 */
	public CrapsGui(){
		
		//Load the GUI
		frame();
		panel();
		rollButton();
		diceImages("one.png","one.png");
		labels();
		betField();
		playerSave();
		

		//Create a craps object
		craps = new Craps();
		
		scoreboard();

		
		//Set the money the player has to 10 and have it displayed.
		money.setText("10");
		craps.setMoney(Integer.parseInt(money.getText()));
		
		//add to frame and make visible.
		frame.add(panel);
		frame.setVisible(true);
		
	}
	
	/**
	 * This method creates a frame for the GUI.
	 */
	public void frame(){
		frame = new JFrame("Craps");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	/**
	 * This method creates a panel to hold the components of the GUI. It also colours it green.
	 */
	public void panel(){
		panel = new JPanel();
		panel.setBackground(new Color(0,153,0));
		panel.setLayout(null);
	}
	
	/**
	 * This method is for creating two dice images and adding them to the panel. It takes in two strings that act as the file location of the images wanted to be
	 * displayed. It then adds them to the panel
	 *  
	 * @param first The file location for the first image
	 * @param second The file location for the second image
	 */
	public void diceImages(String first, String second){
		iconDice1 = new ImageIcon(getClass().getResource(first));
		dice1 = new JLabel(iconDice1);
		dice1.setBounds(20, 20, 100, 100);
		panel.add(dice1);
		
		iconDice2 = new ImageIcon(getClass().getResource(second));
		dice2 = new JLabel(iconDice2);
		dice2.setBounds(140, 20, 100, 100);
		panel.add(dice2);
	}
	
	/**
	 * This method creates the roll button that the user will click on to play the game. It makes use of the RollHandler() actionListener to add functionality. It 
	 * then adds it to the panel. 
	 */
	public void rollButton(){	
		roll = new JButton();
		roll.setVisible(true);
		roll.setBounds(20, 150, 220, 100);
		roll.setText("ROLL");
		roll.setFont(new Font("Arial", Font.PLAIN, 40));
		roll.addActionListener(new RollHandler());
		panel.add(roll);
	}
	
	/**
	 * This method creates the labels for the GUI and adds them to the panel.
	 */
	public void labels(){
		moneyTitle = new JLabel("Money:");
		moneyTitle.setBounds(280, 20, 50, 20);
		panel.add(moneyTitle);
		
		money = new JLabel("");
		money.setBounds(330, 20, 50, 20);
		panel.add(money);
		
		resultTitle = new JLabel("Result:");
		resultTitle.setBounds(280, 60, 50, 20);
		panel.add(resultTitle);
		
		result = new JLabel("");
		result.setBounds(330, 60, 50, 20);
		panel.add(result);
		
		betTitle = new JLabel("Bet:");
		betTitle.setBounds(280, 100, 50, 20);
		panel.add(betTitle);
		
	}
	
	/**
	 * This method creates the text field for the GUI and adds it to the panel.
	 */
	public void betField(){
		
		bet = new JTextField();
		bet.setBounds(330, 100, 100, 25 );
		panel.add(bet);
	}	
	
	/**
	 * This method is for resolving an inputted number (1-6) to its corresponding image location. e.g. an inputted 1 will
	 * result in an outputted string "one.png". This String refers to an image file and is meant to be used to change the
	 * dice images. 
	 * 
	 * If a number outside of the range 1-6 is inputted it will output "one.png".
	 * 
	 * @param num The inputted int to be resolved to a file location string.
	 * @return returns "one.png" when a 1 is inputted, "two.png" for 2, "three.png" for 3, and so on and so forth up to 6.
	 *  
	 */
	public String resolveDiceImage(int num){
		switch(num){
		case 1:
			return "one.png";
		case 2:
			return "two.png";
		case 3:
			return "three.png";
		case 4: 
			return "four.png";
		case 5:
			return "five.png";
		case 6:
			return "six.png";
		default:
			return "one.png";
		}
	}
	
	/**
	 * This is the actionlistener that adds functionality to the Roll button. It takes the user inputted bet from the textbox and sets the Craps bet variable to 
	 * it. 
	 * 
	 * @author James Crocker s4914680
	 * @Version 1.0
	 *
	 */
	class RollHandler implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			int betInt = 0;
			try {
				betInt = Integer.parseInt(bet.getText());	
			}
			catch (java.lang.NumberFormatException ex){
				JOptionPane.showMessageDialog(frame, "Bet must be a whole number that is between 0 and your money.", "WARNING", JOptionPane.WARNING_MESSAGE); 
			}
			
			if (betInt> craps.getMoney() || betInt<=0){
				JOptionPane.showMessageDialog(frame, "Bet must be a whole number that is between 0 and your money.", "WARNING", JOptionPane.WARNING_MESSAGE); 
			}
			else{
				craps.setBet(betInt);
				craps.play();
				result.setText(craps.gameResult());
				money.setText(Integer.toString(craps.getMoney()));
				
				panel.remove(dice1);
				panel.remove(dice2);
				panel.revalidate();
				panel.repaint();
				
				Dice dice1Obj = craps.getDice1();
				Dice dice2Obj = craps.getDice2();
				
				diceImages(resolveDiceImage(dice1Obj.getFaceValue()),resolveDiceImage(dice2Obj.getFaceValue()));
				
				if (craps.getMoney() == 0){
					JOptionPane.showMessageDialog(frame, "Sorry but this is game over. No further actions can be taken. Close the game and start it again to play again.", "Game Over", JOptionPane.ERROR_MESSAGE); 
				}
			}
		}
	}
	
	/**
	 * This method is for creating the scoreboard and applying it to the GUI.
	 * 
	 * At the moment it does not display scores ordered by the highest, instead by most recent. 
	 * Unless there are five saves in the file already the scoreboard will not appear. 
	 */
	public void scoreboard(){
		ArrayList<String> scores = craps.loadFile("src/scores.txt"); 			//Get arraylist of each line from file
		ArrayList<String> arrList = new ArrayList<String>();	//Create an arraylist that will hold each name and score seperatly, but one after another
				
		for(int i = 0 ; i < scores.size() ; i++ ){				//For each line in the file it will split it along the comma into two Strings, those are then stored in arrList
			String str = scores.get(i);
			String[] strArr = str.split(",");
			try{
				arrList.add(strArr[0]);
				arrList.add(strArr[1]);
			}
			catch(java.lang.ArrayIndexOutOfBoundsException ex){
				//This line was causing issues when the game launched. It would cause an error box to appear when not needed.
				//JOptionPane.showMessageDialog(frame, "There is not enough scores in the file. Either add more manually, or click the save button multiple times.", "WARNING", JOptionPane.WARNING_MESSAGE); 
			}
		}
		
		String[] columnNames = {"Score", "Name"};				//Create the table
		try{
			arrList.get(9);
			Object[][] data = {{arrList.get(0),arrList.get(1)},	//This loads in the most recent five scores. Not particularly elegant
							   {arrList.get(2),arrList.get(3)},
							   {arrList.get(4),arrList.get(5)},
							   {arrList.get(6),arrList.get(7)},
							   {arrList.get(8),arrList.get(9)}};
				
			table = new JTable(data, columnNames);								//adding table to panel
	        table.setPreferredScrollableViewportSize(new Dimension(400, 100));
	        table.setBounds(20,300,400,100);
	        panel.add(table);
		}
		catch(java.lang.IndexOutOfBoundsException ex){
			JOptionPane.showMessageDialog(frame, "There is not enough scores in the file. Either add more manually, or click the save button multiple times.", "WARNING", JOptionPane.WARNING_MESSAGE); 
		}
		
	}
	
	/**
	 * This method is for creating the saveField and saveButton. The field takes the players name, and the button saves
	 * that and their money to a file using SaveHandler()
	 */
	public void playerSave(){
		saveField = new JTextField();
		saveField.setBounds(20, 270, 200, 20 );
		panel.add(saveField);
		
		saveButton = new JButton();
		saveButton.setVisible(true);
		saveButton.setBounds(240, 270, 80, 20);
		saveButton.setText("Save");
		saveButton.addActionListener(new SaveHandler());
		panel.add(saveButton);
	}
	
	/**
	 * This is the action listener that adds functionality to the save button. It saves the players money and name to
	 * a file to be stored.
	 * @author James
	 * @version 0.8
	 */
	class SaveHandler implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter("src/scores.txt", true));
				String str = (craps.getMoney() + ","+ saveField.getText());		//Preparing String that will be written to new line in the file
				writer.newLine();		//Writing info to file
				writer.write(str);
				writer.close();
				try{					//Removing old table
					panel.remove(table);
					panel.revalidate();
					panel.repaint();
				}
				catch(java.lang.NullPointerException e){
					
				}
				scoreboard();			//Creating a new table with the updated score
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
