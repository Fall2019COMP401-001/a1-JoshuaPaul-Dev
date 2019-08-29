package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
			//creates new scanner object
		
		int customerCount = scan.nextInt();
			//reads the first integer from the console, 
			//the first input should represent the number of customers
		
		String[] firstNames = new String[customerCount];
		String[] lastNames = new String[customerCount];
			//creates two string arrays that will store the first and last names of customers respectively
		
		int[] numItems = new int[customerCount];
		double[] totals = new double[customerCount];
			//creates two arrays, one for storing the number or different items bought by each customer 
			//the other contains the total cost of all items for each customer respectively
		
		for(int i = 0; i<customerCount; i++) {
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			numItems[i] = scan.nextInt();
			for(int k = 0; k<numItems[i]; k++) {
				int numGoods = scan.nextInt();
				String itemName = scan.next();
				double priceItem = scan.nextDouble();
				totals[i] += (numGoods * priceItem);
			}
		}
		/*
		 * The first for loop goes through and for each customer scans in their first and last names
		 * it saves those names into index values based on a first come, first serve basis.
		 * It also saves the number of items to the same index value in another array.
		 * A second for loop is activated for that index i of the customer that goes through all of
		 * the item categories of the customer. For every item category the second for loop takes the number
		 * and the value of those items and finds the product to save in the same index value i for the total
		 * cost to the customer.
		 */
		
		scan.close();
		
		for(int i = 0; i<customerCount; i++) {
		System.out.println(firstNames[i].charAt(0) + ". " + lastNames[i] + ": " + String.format("%.2f", totals[i]));
		}
		//an output for loop uses the index value i to output to console the customer names
		//as well as outputting the totals saved to the same index value i
		//keeping the index value i matching between arrays is vital for correct usage of the output for loop.
		
	}
}
