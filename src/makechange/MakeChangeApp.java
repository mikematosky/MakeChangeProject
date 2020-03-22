package makechange;

import java.util.Scanner;

public class MakeChangeApp {
	
	static Scanner kb= new Scanner(System.in);
	
	public static void main(String[] args) {
		
		greeting();
		kb.hasNextLine();
		registerSay("Enter the bill total: $???.??");
		
		System.out.println("$"+getTotal());
		
		
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
	public static double getTotal() {
		//double total=(Math.random()*100);
		//int allPennies= (int)(total*100);
		//double roundedCost= allPennies/100.00;
		/*
		 * I am fully aware that this loses precision. This is just to create the total
		 * that pops up on the cash register.... So this is an 'Office Space' rounding 
		 * error that only the programmers know about and is theoretically as beneficial
		 * as it is harmful to the profit... I will just allow the total to be inputed in future
		 * versions. So this is just my secret. But it's better than just truncating if you ask me.
		 */
		//return roundedCost;

		registerSay("Enter the bill total: $???.??");
		System.out.print("Your Total:  $");
		double total= kb.nextDouble();
		
		
		//Check to make sure the double is positive
		while(!isPositive(total)) {
				registerSay ("The input is negative!", 
						"Try again!");
				System.out.println();
				total= kb.nextDouble();
		}
		return total;
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

	
	
	//For error checking the input
	public static boolean isPositive(double total) {
		return (total>0);
	}
	
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}
	
//	public static double convertToMoney(double nonMoney) {
//		
//	}

}
