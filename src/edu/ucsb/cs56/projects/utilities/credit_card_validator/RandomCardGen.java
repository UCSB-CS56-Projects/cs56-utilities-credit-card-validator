package edu.ucsb.cs56.projects.utilities.credit_card_validator;

import java.util.*; 


// I am pretty sure this is not generating valid cards
public class RandomCardGen {
    /**
       holds a string representing the type of the credit card
    */
    public static String cardType;
    
    /**
       holds a string of the newly constructed credit card number
    */
    public static String cardNumber;

    /**
       generates a credit card number randomly
    */

    public static String RandomCard() {

		String temp = null;
	   
    	String newCard = null;
	
		//making a new card
		int random0 = (int)(9*Math.random()+1);
        temp = Integer.toString(random0);
        newCard = temp;
	
		int random1 = (int)(9*Math.random());
        temp = Integer.toString(random1);
        newCard += temp;
	
		int random2 = (int)(9*Math.random());
        temp = Integer.toString(random2);
        newCard += temp;

		int random3 = (int)(9*Math.random());
        temp = Integer.toString(random3);
        newCard += temp;

		newCard += " ";

		int random4 = (int)(9*Math.random());
        temp = Integer.toString(random4);
        newCard += temp;

		int random5 = (int)(9*Math.random());
        temp = Integer.toString(random5);
        newCard += temp;

		int random6 = (int)(9*Math.random());
        temp = Integer.toString(random6);
        newCard += temp;

		int random7 = (int)(9*Math.random());
        temp = Integer.toString(random7);
        newCard += temp;

		newCard += " ";

		int random8 = (int)(9*Math.random());
        temp = Integer.toString(random8);
        newCard += temp;

		int random9 = (int)(9*Math.random());
        temp = Integer.toString(random9);
        newCard += temp;

		int random10 = (int)(9*Math.random());
        temp = Integer.toString(random10);
        newCard += temp;

		int random11 = (int)(9*Math.random());
        temp = Integer.toString(random11);
        newCard += temp;

		newCard += " ";

		int random12 = (int)(9*Math.random());
        temp = Integer.toString(random12);
        newCard += temp;

		int random13 = (int)(9*Math.random());
        temp = Integer.toString(random13);
        newCard += temp;

		int random14 = (int)(9*Math.random());
        temp = Integer.toString(random14);
        newCard += temp;

		int random15 = (int)(9*Math.random());
        temp = Integer.toString(random15);
        newCard += temp;


	//checks the type of the made card
		if(random0 == 1) {
	    	cardType = "Airline(1)";
		} 
		else if (random0 == 2) {
	    	cardType = "Airline(2)";
		}
		else if (random0 == 3 & random1 == 4){
	    	cardType = "American Express";
		}
		else if (random0 == 3 & random1 == 5){
	    	cardType = "Japan Credit Bureau";
		}
		else if(random0 == 3 & random1 == 6) {
		    cardType = "Diner's Club";
		}
		else if (random0 == 3 & random1 == 7){
		    cardType = "American Express";
		}
		else if(random0 == 3 & random1 == 8) {
		    cardType = "Diner's Club";
		}
		else if (random0 == 3) {
		    cardType = "Travel";
		}
		else if (random0 == 4) {
		    cardType = "Visa";
		}
		else if (random0 == 5 & random1 == 1) {
		    cardType = "Mastercard";
		}
		else if (random0 == 5 & random1 == 2) {
		    cardType = "Mastercard";
		}
		else if (random0 == 5 & random1 == 3) {
		    cardType = "Mastercard";
		}
		else if (random0 == 5 & random1 == 4) {
		    cardType = "Mastercard";
		}
		else if (random0 == 5 & random1 == 5) {
		    cardType = "Mastercard";
		}
		else if (random0 == 5) {
		    cardType = "Merchandizing";
		}
		else if (random0 == 6 & random1 == 5) {
		    cardType = "Discover";
		}
		else if (random0 == 6 & random1 == 0 & random2 == 1 & random3 == 1) {
		    cardType = "Discover";
		}
		else if (random0 == 6) {
		    cardType = "Banking(2)";
		}
		else if (random0 == 7) {
		    cardType = "Petroleum";
		}
		else if (random0 == 8) {
		    cardType = "Telecommunications";
		}
		else if (random0 == 9) {
		    cardType = "National Assignment";
		}
		else {
		    cardType = "Not a valid Card";
		}

		cardNumber = newCard;
		return newCard;
	} 
}
