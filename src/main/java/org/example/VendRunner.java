package org.example;

public class VendRunner {

	public static void main(String[] args) {

		// Snacks, Beverages, slot
		Snack snack1 = new Snack("Snickers", 2.00, true);
		Snack snack2 = new Snack("Potato Chips", 1.75, true);
		Snack snack3 = new Snack("Beef Jerky", 2.50, false);

		Beverage b1 = new Beverage("Red Bull", 3.50, 4.5);
		Beverage b2 = new Beverage("Pepsi", 2.00, 3.0);
		Beverage b3 = new Beverage("Gatorade", 2.50, 4.0);

		Slot<Snack> slot1 = new Slot<Snack>(snack1, 3);
		Slot<Snack> slot2 = new Slot<Snack>(snack2, 2);
		Slot<Snack> slot3 = new Slot<Snack>(snack3, 4);
		Slot<Beverage> slot4 = new Slot<Beverage>(b1, 2);
		Slot<Beverage> slot5 = new Slot<Beverage>(b2, 2);
		Slot<Beverage> slot6 = new Slot<Beverage>(b3, 2);


		// objMap object containing list of slots
		//VendingMachine vendingMachine2 = new VendingMachine(list of slots);


		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.addProduct("F1", slot1);
		vendingMachine.addProduct("F2", slot2);
		vendingMachine.addProduct("F3", slot4);
		vendingMachine.addProduct("F4", slot5);
		
		vendingMachine.dispenseProduct("F2");



	}
}
