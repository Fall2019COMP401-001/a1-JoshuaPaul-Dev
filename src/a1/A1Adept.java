package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		//creates new scanner object

		int numItems = scan.nextInt();
		//finds the total number of items for the directory of items
		
		String[] itemNames = new String[numItems];
		double[] itemPrices = new double[numItems];
		//creates two arrays for the directory of items containing the item names and prices respectively
		
		for(int i = 0; i < numItems; i++) {
			itemNames[i] = scan.next();
			itemPrices[i] = scan.nextDouble();
		}
		//scans the input to populate the item directory
		
		int numCustomers = scan.nextInt();
		//finds the total number of customers for the directory of customers
		
		String[] firstNames = new String[numCustomers];
		String[] lastNames = new String[numCustomers];
		//creates two arrays for the directory of customers containing the first and last names of the customers
		
		int[] itemsBought = new int[numCustomers];
		double[] totals = new double[numCustomers];
		//creates two arrays for the directory of customers containing the number of items bought and the total paid by each customer
		
		for(int i=0; i<numCustomers; i++) {
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			itemsBought[i] = scan.nextInt();
			for(int k=0; k<itemsBought[i]; k++) {
				int numGood = scan.nextInt();
				String goodName = scan.next();
				for(int n=0; n<numItems; n++) {
					if((goodName.compareTo(itemNames[n]))==0) {
						totals[i] += (numGood * itemPrices[n]);
					}
				}
			}
		}
		/*
		 * The first for loop populates the customer directory with the customer names and the number of items bought by each customer.
		 * The second and third for loops populate the customer directory with the total paid of each customer by first finding the quantity
		 * and name of the item bought and then cross referencing the item with the item names and prices in the item directory. This repeats
		 * for every different item that each customer purchased.
		 */
		
		double biggest = totals[0];
		int biggestIndex = 0;
		double smallest = totals[0];
		int smallestIndex = 0;
		double grandTotal = 0;
		//creates variables for each of the metrics we wish to compare with including the biggest and smallest spender
		//the grand total variable will be part of the average paid computation later
		
		for(int i=0; i<numCustomers; i++) {
			if(biggest<totals[i]) {
				biggest = totals[i];
				biggestIndex = i;
			}
			if(smallest>totals[i]) {
				smallest = totals[i];
				smallestIndex = i;
			}
			grandTotal += totals[i];
		}
		//this for loop serves to both compare totals to define each of the metrics and to define the grand total for the average paid computation
		
		double average = (grandTotal/numCustomers);
		//this calculates the average paid by each customer
		
		scan.close();
		//this closes the scanner object
		
		System.out.println("output");
		System.out.println("Biggest: " + firstNames[biggestIndex] + " " + lastNames[biggestIndex] + " (" + String.format("%.2f", biggest) + ")");
		System.out.println("Smallest: " + firstNames[smallestIndex] + " " + lastNames[smallestIndex] + " (" + String.format("%.2f", smallest) + ")");
		System.out.println("Average: " + String.format("%.2f", average));
		//output prints and execution ends
	}
}
