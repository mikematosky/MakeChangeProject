package makechange;

import java.util.Scanner;

public class MakeChangeApp {
	
	static Scanner kb= new Scanner(System.in);
	private static double total;
	
	public static void main(String[] args) {
		
		greeting();
		kb.nextLine();
		getTotal();
		kb.nextLine();
		takeMoney();
		
		kb.close();
	}
	
	public static String getChange() {
		String changeString="";
		
		return changeString;
	}
	public static double giveMoney() {
		double handedOver=0;
		
		return handedOver;
	}
	
	
	public static void getTotal() {
		
		//FOR TESTING
		//double total=(Math.random()*100);

		registerSay("Enter the bill total: $???.??");
		System.out.print("Your Total:  $");
		total= kb.nextDouble();		
		//Check to make sure the double is positive
		while(!isPositive(total)) {
			registerSay ("The input is negative!", 
					"Try again!");
			System.out.print("Your Total:  $");
			total= kb.nextDouble();
		}				
		registerSay("Your Total is: $"+toMoney(total));		
	}
	
	public static void takeMoney() {
		double moneyReceived;
		registerSay("How much did they", "give you? ");
		System.out.println("They gave me: $");
		moneyReceived= kb.nextDouble();
		
		if(moneyReceived < total) {
			registerSay("That is not enough!",
					"Try Again!");
			kb.nextDouble();
		}
		
	}
	

	

	
	public static int getDollars(double total) {
		return (int)total;
		
	}
	public static int getPennies(double total) {
		return (int)(((total+0.005)*100)%100);
	}
	public static boolean isPositive(double total) {
		return (total > 0);
	}
	public static long getTotalPennies(double total) {
		return (long)total*100;
	}
	
	//ROUND Strange Gas Station decimals from inputs
	public static double toMoney(double num) {
		int pennies;
		double money;
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
	
	
	public static void registerSay(String sayWhat) {
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(" =========================================");
		System.out.println("||                                       ||");
		System.out.printf("||    %28s      ||%n",sayWhat);
		System.out.println("||                                       ||");
		System.out.println("||                                       ||");
		System.out.println("||                                       ||");
		System.out.println(" =========================================");
		System.out.println();
		System.out.println();
		System.out.println();
		
	}
	
	//Two Lines Overload for registerSay
	public static void registerSay(String firstLine, String secondLine) {
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(" =========================================");
		System.out.println("||                                       ||");
		System.out.printf("||    %-28s       ||%n",firstLine);
		System.out.println("||                                       ||");
		System.out.printf("||        %-20s           ||%n", secondLine);
		System.out.println("||                                       ||");
		System.out.println(" =========================================");
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
}
