package makechange;

import java.util.Scanner;

public class MakeChangeApp {
	//global variables are not against the rules
	static Scanner kb= new Scanner(System.in);
	static double total;
	static double received;
	static double change; 
	
	/*
	 * the main method. it calls greeting(), getTotal(), takeMoney(), and makeChange()
	 * methods. There are two stylistic pauses to signify the steps they are concluding
	 * and the Scanner is closed here because it's the last thing that happens in the program.
	 * 
	 * There are no local variables. This was a choice I made to prevent myself from passing
	 * variables back and forth and gobbing main up with all of the arithmetic and error
	 * checking. This also allowed me to work on this in modules.
	 */
	public static void main(String[] args) {
		
		greeting();
		kb.nextLine();//pause
		getTotal();
		kb.nextLine();//pause
		takeMoney();
		makeChange();
		
		
		kb.close();
	}
	
	/*
	 * getTotal() is a void method that performs the operations
	 * involved with establishing a total amount that needs to be
	 * charged. The total must be positive via the toMoney() call
	 * 
	 * It uses/manipulates global variable: total
	 */
	public static void getTotal() {
		
		//FOR TESTING
		//double total=(Math.random()*100);

		System.out.println("Enter the bill total: $???.??");
		System.out.print("Bill total:  $");
		
		//Convert the input to Money right away
		total= toMoney(kb.nextDouble()); //checks if positive already
		
		//Output Results
		System.out.println("The bill total is: $"+total); 
		
		//could establish total in the main and just toss it through as parameters when needed.
	}
	
	
	/*
	 * takeMoney() is a void method that performs the operations
	 * involved with receiving money. It will check to see if the
	 * input is enough, while also checking the input is positive
	 * via the toMoney() call
	 * 
	 * It uses/manipulates global variables: total, received, and change
	 */
	public static void takeMoney() {
		
		System.out.println("How much did they give you? ");
		System.out.print("They gave me: $");
		received= toMoney(kb.nextDouble());//must be positive
		
		//total must be < received. You have to cover the total amount.
		while(total > received) {
			System.out.println("That is not enough! Needs to be > $"+total);
			System.out.print("They gave me: $");
			received= toMoney(kb.nextDouble());			
		}
		change= toMoney(received - total);//the positive checker is never run here
		System.out.println("GREAT! We need $"+change); //Awesome for troubleshooting
		
	}
	
	
	/*
	 * makeChange() is a void method that performs the operations
	 * involved with doling out change. Change is set in takeMoney()
	 * as the difference between total and received.
	 * 
	 * It uses/manipulates global variables: change
	 */
	public static void makeChange() {
		
		if(change == 0) {
			System.out.println("You get no change!");
		}
		else {
			System.out.print("Give them ");
			change= (int)(change*100);
			
			while(change >= 0.00) {
								
				if(change >= 20_00) {
					int twenties= (int)(change/20_00);
					System.out.print(twenties+" twenties");
					change= change%20_00;
				}
				else if(change >= 10_00) {
					int tens= (int)(change/10_00);
					System.out.print(tens+" tens");
					change= change%10_00;
				}
				else if(change >= 5_00) {
					int fives= (int)(change/5_00);
					System.out.print(fives+" fives");
					change= change%5_00;
				}
				else if(change >= 1_00) {
					int singles= (int)(change/100);
					System.out.print(singles+" singles");
					change= change%1_00;
				}
				else if(change >= 25) {
					int quarters= (int)change/25;
					System.out.print(quarters+" quarters");
					change= change%25;
				}
				else if(change >= 10) {
					int dimes= (int)(change/10);
					System.out.print(dimes+" dimes");
					change= change%10;
				}
				else if(change >= 5) {
					int nickles= (int)(change/5);
					System.out.print(nickles+" nickles");
					change= change%0_05;
				}
				else if(change >= 1) {
					//Remainder is just the number of pennies
					System.out.print((int)change+" pennies");
					change= 0;
				}
				else {
					System.out.println("Something went wrong somewhere");// This no longer happens
					break;
				}
				
				//Line ending. Either add a "." or a ", " 
				if(change > 0)
					System.out.print(", ");				
				else {
					System.out.print(".");				
					break;
				}
			}	
		}
	}
	
	
	/*
	 * toMoney() is a method that returns a double, but only in the format
	 * of having two decimal places. It also error checks for positive money
	 * amounts and will prompt the user to enter a number >= 0. The value is
	 * added 0.005 to facilitate rounding gas station style money inputs with 
	 * more than 2 decimals. ie 44.3367412 will return 44.34 and our remaining
	 * value is lost to the ether.
	 * 
	 * a double is a parameter and a double is returned
	 * No global variables are used or manipulated
	 */
	public static double toMoney(double num) {
		int pennies;
		double money;
		 
		//recursive
		if(num < 0) {
			System.out.println("Needs to be a Positive Number! Try again");
			System.out.print("New money value: $");
			num= toMoney(kb.nextDouble());
		}
		
		num+=0.005;
		pennies= (int)(num * 100);
		money= pennies/100.00;	
	
		return money;
	}
	
	/*
	 * This is the ruins of my attempt at a UI type interaction. I tried to
	 * build a makeshift screen and it had overloads for different numbers of
	 * strings to be passed and what information showed up in different places.
	 * It can still be added later, but the regular sysout prompts worked well
	 * and while it looked very nice and fancy, I had spent too much time 
	 * focused on this aspect and not enough about passing tests. I came to a point
	 * where I had some rounding and casting problems and my register was giving
	 * out the wrong coins so I had to spend more time solving that, so I stopped
	 * playing with printf().
	 */
	public static void greeting() {
		System.out.println(" =========================================");
		System.out.println("||                                       ||");
		System.out.println("|| WELCOME TO THIS QUARANTINE-ENHANCED   ||");
		System.out.println("||                                       ||");
		System.out.println("||       CASH REGISTER PROGRAM!          ||");
		System.out.println("||                                       ||");
		System.out.println(" =========================================");
	}
	
}