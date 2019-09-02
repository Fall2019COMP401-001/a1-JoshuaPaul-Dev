package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		//creates new scanner object

		int numItems = scan.nextInt();
		//finds the total number of items for the directory of items
				
		String[] itemNames = new String[numItems];
		double[] itemPrices = new double[numItems];
		int[] goodBought = new int[numItems];
		int[] customerBought = new int[numItems];
		//creates two arrays for the directory of items containing the item names and prices respectively
		//creates two additional arrays for the directory to track when an item is purchased by a customer as well as the total number purchased
				
		for(int i = 0; i < numItems; i++) {
			itemNames[i] = scan.next();
			itemPrices[i] = scan.nextDouble();
			goodBought[i] = 0;
			customerBought[i] = 0;
		}
		//scans the input to populate the item directory
		
		int numCustomers = scan.nextInt();
		//finds the total number of customers for the directory of customers
		
		String[] firstNames = new String[numCustomers];
		String[] lastNames = new String[numCustomers];
		//creates two arrays for the directory of customers containing the first and last names of the customers
		
		int[] itemsBought = new int[numCustomers];
		double[] totals = new double[numCustomers];
		boolean[][] didBuy = new boolean[numCustomers][numItems];
		//creates two arrays for the directory of customers containing the number of items bought and the total paid by each customer
		//creates an array of arrays containing boolean values for whether or not each customer has purchased each item
		
		for(int i=0; i<numCustomers; i++) {
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			itemsBought[i] = scan.nextInt();
			for(int k=0; k<itemsBought[i]; k++) {
				int numGood = scan.nextInt();
				String goodName = scan.next();
				for(int n=0; n<numItems; n++) {
					if((goodName.compareTo(itemNames[n]))==0) {
						if(didBuy[i][n] == false) {
							customerBought[n]++;
							didBuy[i][n] = true;
						}
						goodBought[n] += numGood;
						totals[i] += (numGood * itemPrices[n]);
					}
				}
			}
		}
		/*
		 * The first for loop populates the customer directory with the customer names and the number of items bought by each customer.
		 * The second and third for loops populate the customer directory with the total paid of each customer by first finding the quantity
		 * and name of the item bought and then cross referencing the item with the item names and prices in the item directory. This repeats
		 * for every different item that each customer purchased. The final for loop also populates the item directory with information on 
		 * how many customers purchased each item and how many of each item is purchased overall. The array of arrays is tested for the original
		 * value of false in the location of each of the items for each customer. If that customer has not increased the customerBought value for
		 * each individual item they buy, then the counter will be incremented and the boolean in that index for that item set to true.
		 */

		for(int i=0; i<numItems; i++) {
			if(customerBought[i] == 0) {
				System.out.println("No customers bought " + itemNames[i]);
			}
			else {
				System.out.println(customerBought[i] + " customers bought " + goodBought[i] + " " + itemNames[i]);
			}
		}
		//this loop initiates an if then else cascade that sends item info to the console
	}
}
