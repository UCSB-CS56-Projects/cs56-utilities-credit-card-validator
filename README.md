# cs56-utilities-credit-card-validator

GUI-based credit card number validator. Allows user to choose between creating a random
credit card number or checking if a given number is valid.

Allows users to choose to generate specific card numbers, like Visa, Mastercard, American Express, and Discover.

project history
===============
```
 W15 | andrewberls, Jonathan Easterman, Ishi Von Meier | TBD | A credit card number validator
```
project history
===============
```
W16 | Angel Rivera, Stefana Gloginic

```
The credit card validator allows the user to input a credit card number into a JTextField and check if it is a valid number. It also allows users to generate valid numbers for 4 types of credit cards. The user can pick the type from a JComboBox. There is currently a label that tells the user if they have input too many characters for a certain card, but there is a bug because it does not check for white space or the '-' character. There is also a JcomboBox that would be used when the user wants to select how many numbers to generate, but it currently has no function. There is also an oppurtunity to create a card class and have each type such as Visa be a subclass of it. Also more tests could be added for the generate functions of each cardtype.