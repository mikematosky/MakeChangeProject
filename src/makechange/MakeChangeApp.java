package makechange;

import java.util.Scanner;

public class MakeChangeApp {
	
	public static void main(String[] args) {
		System.out.println("$"+getTotal());

	}
	
	public static String getChange() {
		String changeString="";
		
		return changeString;
	}
	public static double giveMoney() {
		double handedOver=0;
		Scanner kb= new Scanner(System.in);
		
		kb.close();
		return handedOver;
	}
	public static double getTotal() {
		double total=(Math.random()*100);
		int allPennies= (int)(total*100);
		double roundedCost= allPennies/100.00;
		
		return roundedCost;
	}

}
