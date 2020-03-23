package makechange;

import java.util.Scanner;

public class MakeChangeApp {
	
	static Scanner kb= new Scanner(System.in);
	static double total;
	static double received;
	static double change; 
	
	public static void main(String[] args) {
		
		greeting();
		kb.nextLine();
		getTotal();
		kb.nextLine();
		takeMoney();
		makeChange();
		
		
		kb.close();
	}
	
	
	public static void getTotal() {
		
		//FOR TESTING
		//double total=(Math.random()*100);

		System.out.println("Enter the bill total: $???.??");
		System.out.print("Your Total:  $");
		//Convert the input to Money right away
		total= toMoney(kb.nextDouble()); //checks if positive already
		//Output Results and pause
		System.out.println("Your Total is: $"+total);
		kb.nextLine();
	}
	
	public static void takeMoney() {
		
		System.out.println("How much did they give you? ");
		System.out.print("They gave me: $");
		received= toMoney(kb.nextDouble());
		
		while(total > received) {
			System.out.println("That is not enough! Needs to be > $"+total);
			System.out.println("They gave me: $");
			received= toMoney(kb.nextDouble());			
		}
		change= toMoney(received - total);
		System.out.println("GREAT! We need $"+change);
		
	}
	
	public static void makeChange() {
		System.out.print("Give them ");
		change= change*100;
		
		if(change == 0) {
			System.out.println("You get no change!");
		}
		else {
			while(change > 0) {
				
				if(change >= 20_00) {
					int twenties= (int)(change/20_00);
					System.out.print(twenties+" twenties");
					change= (change%20_00);
				}
				else if(change >= 10_00) {
					int tens= (int)(change/10_00);
					System.out.print(tens+" tens");
					change= (change%10_00);
				}
				else if(change >= 5_00) {
					int fives= (int)(change/5_00);
					System.out.print(fives+" fives");
					change= (change%5_00);
				}
				else if(change >= 1_00) {
					int singles= (int)(change/100);
					System.out.print(singles+" singles");
					change= (change%1_00);
				}
				else if(change >= 0_25) {
					int quarters= (int)(change/0_25);
					System.out.print(quarters+" quarters");
					change= (change%0_25);
				}
				else if(change >= 0_10) {
					int dimes= (int)(change/0_10);
					System.out.print(dimes+" dimes");
					change= (change%0_10);
				}
				else if(change >= 0_05) {
					int nickles= (int)(change/0_05);
					System.out.print(nickles+" nickles");
					change= (change%0_05);
				}
				else if(change >= 1) {
					int pennies= (int)(change/0_01);
					System.out.print(pennies+" pennies");
					change= (change%0_01);
				}
				else {
					System.out.println("Something went wrong somewhere");
				}
				
				if(change > 0)
					System.out.print(", ");				
				else
					System.out.print(".");				
			
			}	
		}
		
		
	}
	
	
	//ROUND Strange Gas Station decimals from inputs
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