package org.example;

public class VendRunner {

	public static void main(String[] args) {


		/*
		makeSureIsValid() throws Exceptions A, B C,{
			try {

			} catch {
			}
		 */


		try {
			Snack snack1 = new Snack("Snickers", 2.00, true);
			Snack snack2 = new Snack("", 2.50, true);
			Snack snack3 = new Snack("Chips", -2.75, true);
			Snack snack4 = new Snack(null, 2.75, true);

			Beverage b1 = new Beverage("Red Bull", 3.50, 4.5);
			Beverage b2 = new Beverage("Green Bull", -3.75, 4.5);
			Beverage b3 = new Beverage("", 3.75, 4.5);
			Beverage b4 = new Beverage(null, 3.75, 4.5);


			Slot<Snack> slot1 = new Slot<Snack>(snack1, 3);


			VendingMachine vendingMachine = new VendingMachine();
			vendingMachine.addProduct("F1", slot1);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//}

		// Snacks, Beverages, slot

//addProduct(String code, Slot<? extends Product> slot)



	}
}
