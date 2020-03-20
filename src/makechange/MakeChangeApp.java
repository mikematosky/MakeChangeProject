package makechange;

import java.util.Scanner;

public class MakeChangeApp {
	
	static Scanner kb= new Scanner(System.in);
	
	public static void main(String[] args) {
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
		double total=(Math.random()*100);
		int allPennies= (int)(total*100);
		double roundedCost= allPennies/100.00;
		/*
		 * I am fully aware that this loses precision. This is just to create the total
		 * that pops up on the cash register.... So this is an 'Office Space' rounding 
		 * error that only the programmers know about and is theoretically as beneficial
		 * as it is harmful to the profit... I will just allow the total to be inputed in future
		 * versions. So this is just my secret. But it's better than just truncating if you ask me.
		 */
		
		
		
		return roundedCost;
	}

}
