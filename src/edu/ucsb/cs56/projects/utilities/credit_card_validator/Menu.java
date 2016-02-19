package edu.ucsb.cs56.projects.utilities.credit_card_validator;

import java.util.Scanner;
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/** Class displays a GUI that allows users to 
* generate a Visa, Amex, Discover, or MasterCard
* credit card number. Users can also validate a number
* @author Jonathan Easterman Ishi Von Meier
* @version  Winter 2015, CS 56
*/

public class Menu extends JFrame{
	// String attribute that holds card type of current selection
	// in ComboBox
	private String cardType = new String();

	// Textfield where user can enter cardNumberField
	private JTextField cardNumberField;

        //Global instance variable for user input
        private String TextFieldInput = "";

        //Global instance variable for JTextField input
        private String cardFieldContents = ""; //new
        //Global instance variable for KeyListener
        private int keyType = 0;
	
	// User presses this button when ready to validate CC number
	private JButton validateButton;

	// User presses this button to generate card numbers
	private JButton generateButton;

	//Simple Label to explain to user what is held in the comboBox
	private JLabel cardTypeLabel;
	
	//Simple JLabel to tell user if card number is valid or not
	private JLabel cardValidLabel;

    //ComboBox to hold all of the different card options
	private JComboBox cardTypeComboBox = new JComboBox();

    // Constructor for Menu calls the initUI() method
	public Menu() {
		initUI();
	}


	class ValidateListener implements ActionListener {
		// sometimes generates bad cards (when last number is 10)
		// Gotta change this to verify if the vard is validated or not
		public void actionPerformed (ActionEvent ae) {
		    if(TextFieldInput == ""){
		        cardFieldContents = new String(cardNumberField.getText());
		    }
	       	else{
		    String cardFieldContents = TextFieldInput; //changed new String(cardNumberField.getText())
		    }
			if (CCValidator.isValid(cardFieldContents)){
			    //set card type variable, print to label
				cardTypeLabel.setText("Card Type: " + CCValidator.getCardType(cardFieldContents));
			    cardValidLabel.setText("This is a valid card number!");
			}
			else
			    cardValidLabel.setText("This is an invalid card number!");
		}
	}



	// Sets the cardType and generates corresponding card number when
	// generate button is clicked
	class GenerateListener implements ActionListener {
		public void actionPerformed (ActionEvent ae) {
		    TextFieldInput = ""; //Need to empty in case there was some previous input
			Menu.this.cardType = (String)Menu.this.cardTypeComboBox.getSelectedItem();
			switch (Menu.this.cardType) {
				case "Visa":
					cardNumberField.setText(Visa.generateCard());
					break;
				case "Amex":
					cardNumberField.setText(AmericanExpress.generateCard());
					break;
				case "Discover":
					cardNumberField.setText(Discover.generateCard());
					break;
				case "MasterCard":
					cardNumberField.setText(MasterCard.generateCard());
					break;
				default:
					cardNumberField.setText("Please select a card type!");
					break;
			//also print card type to label to keep label current
			}
		}
	}
    
	// creates the text field and buttons and adds them to JFrame
	public void initUI() {
		cardNumberField = new JTextField(20);
		validateButton = new JButton("Validate");
		generateButton = new JButton("Generate");

		cardValidLabel = new JLabel("");
        cardTypeLabel = new JLabel("Card Type:");
	
		cardNumberField.setText("Enter credit card number here");
		cardTypeComboBox = new JComboBox();
		
		
		this.setTitle("Credit Card Validator");
		this.setSize(500,150);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		String[] description = { "Pick a card type","Visa", "MasterCard","Amex","Discover"};
		for (int i = 0; i < 5; i++){cardTypeComboBox.addItem(description[i]);}
      	
 
        //create new grouplayout and set contentpane to this layout
        GroupLayout layout = new GroupLayout(this.getContentPane());
    	this.getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
 
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(LEADING)
                .addComponent(cardNumberField)
            	.addGroup(layout.createParallelGroup()
                    .addComponent(cardValidLabel)
			  .addComponent(cardTypeLabel)
                    .addComponent(cardTypeComboBox)))
            .addGroup(layout.createParallelGroup(LEADING)
                .addComponent(validateButton)
                .addComponent(generateButton))
        );
        
        layout.linkSize(SwingConstants.HORIZONTAL, validateButton, generateButton);
 
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(BASELINE)
                .addComponent(cardNumberField)
                .addComponent(validateButton))
            .addGroup(layout.createParallelGroup(LEADING)
            	.addComponent(cardValidLabel)
                .addComponent(generateButton))
            .addComponent(cardTypeLabel)
        	.addComponent(cardTypeComboBox));

        pack();
     	this.setVisible(true);

		validateButton.addActionListener(new ValidateListener());
		generateButton.addActionListener(new GenerateListener());
		//adding listener for keyboard input from user
		cardNumberField.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent keyEvent){
			    keyType = keyEvent.getKeyCode();
			    System.out.println(keyType);
			    //Backspace is value 8, check for if backspace was pressed
			    if(keyType == 8){
				if(!(TextFieldInput.isEmpty())){
				    //if there was one asterisk, now should be cleared.
				    if(TextFieldInput.length() == 1){
					TextFieldInput = "";
				    }
				    else{
					//otherwise if the length is greater than 1, subtract one digit from input
					TextFieldInput = TextFieldInput.substring(0,TextFieldInput.length()-1);
				    }   
				return;
				}
			    }
			    //checks if the key typed is enter
			    if(keyType == KeyEvent.VK_ENTER){
				int checkLength = TextFieldInput.length();
				try{
				    if (CCValidator.isValid(TextFieldInput)){
					//set card type variable, print to label
					cardTypeLabel.setText("Card Type: " + CCValidator.getCardType(TextFieldInput));
					cardValidLabel.setText("This is a valid card number!");
				    }
				}catch(ArrayIndexOutOfBoundsException ex){
				    if(checkLength < 16){
					cardValidLabel.setText("Not enough digits");
				        TextFieldInput = "";
				        return;
				    }
				}
				    if(checkLength > 16){
					cardValidLabel.setText("Too many digits");
				    }
				    else{
				       cardValidLabel.setText("This is an invalid card number!");
				    }
				       TextFieldInput = "";
				return;
			    }
			}
			public void keyTyped(KeyEvent keyEvent) {
			    keyEvent.consume(); //http://stackoverflow.com/questions/7525154/jtextfields-settext-method-doesnt-work-from-a-keylistener
			    if(!((keyType == 8) || (keyType == KeyEvent.VK_ENTER))){
				TextFieldInput += keyEvent.getKeyChar();
				System.out.println(TextFieldInput);
			    }
			    String asteriskString = "";
			    for(int i=0; i < TextFieldInput.length(); ++i){
				asteriskString += "*";
			    }
			    cardNumberField.setText(asteriskString);
			    return;
			}
		  public void keyReleased(KeyEvent keyEvent){}
		}); 
	}

	// Main function calls constructor for a Menu instance
	// Program logic is handled in initUI() method, which is
	// called by Menu constructor
    public static void main(String args[]) {
        Menu gui = new Menu();
	}
}
