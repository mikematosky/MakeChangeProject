package makechange;

import java.util.Scanner;

public class MakeChangeApp {
	
	static Scanner kb= new Scanner(System.in);
	private static double total;
	private static double received;
	
	public static void main(String[] args) {
		
		greeting();
		kb.nextLine();
		getTotal();
		kb.nextLine();
		takeMoney();
		
		kb.close();
	}
	
	
	public static void getTotal() {
		
		//FOR TESTING
		//double total=(Math.random()*100);

		System.out.println("Enter the bill total: $???.??");
		System.out.print("Your Total:  $");
		//Convert the input to Money right away
		total= toMoney(kb.nextDouble());		
		
						
		System.out.println("Your Total is: $"+total);
		kb.nextLine();
	}
	
	public static void takeMoney() {
		boolean isEnough= false;
		System.out.println("How much did they give you? ");
		System.out.print("They gave me: $");
		received= toMoney(kb.nextDouble());
		
		while(!isEnough) {
			if(received < total) {
				System.out.println("That is not enough! Needs to be > $"+total);
				System.out.println("They gave me: $");
				received= toMoney(kb.nextDouble());
			}
			else {
				isEnough=true;
			}
		}
		System.out.println("GREAT! We need $"+toMoney(total-received));
		
		
	}

	public static long getTotalPennies(double total) {
		
		return (long)total*100;
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