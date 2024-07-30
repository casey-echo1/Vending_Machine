package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class VendingMachine {
	private Map<String,Slot<? extends Product>> slots;//<?extends Products>

	//default constructor
	public VendingMachine() {
		this.slots = new TreeMap<>();
	}

	public Map<String, Slot<? extends Product>> getSlots() {
		return this.slots;
	}

	public void addProduct(String code, Slot<? extends Product> slot) {
		if(code == null || code.isEmpty() || slot == null) {
			throw new IllegalArgumentException("Code/slot cannot be empty or null");
		}
		slots.put(code, slot);
	}

	public void dispenseProduct(String code) throws IOException {
		if(code == null || code.isEmpty()) {
			throw new IllegalArgumentException("Code cannot be empty or null");
		}
		if (slots.containsKey(code)) {
			if (this.slots.get(code).getQuantity() > 0) {
				Slot<? extends Product> slot = this.slots.get(code);
				slot.setQuantity(this.slots.get(code).getQuantity() - 1);
				System.out.println(slot.getProduct().getName());
				printReceipt(slot.getProduct());
			} else {
				System.out.println("Product Not Available");
				// notify vendor that product is out of stock
				sendVendorNotification(this.slots.get(code).getProduct());
			}
		} else {
			System.out.println("Invalid Input");
		}
	}
	/*
		this method creates a file with timestamp and name of product that is out of stock
	 */
	public void sendVendorNotification(Product product) throws IOException {
		String location = "notification_"+product.getName()+".txt";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(location, true))) {
			writer.newLine();
			writer.write(product.getName() + " is out of Stock!!!");
			writer.newLine();
			writer.write(LocalDateTime.now().toString());
		}
	}


	public void displayProducts() {
		//display all available products
		for(Map.Entry<String, Slot<? extends Product>> slot : this.slots.entrySet()) System.out.println(slot);
		//Slot{product=Snack{SnickersPrice= 2.0isVegan=true}, quantity=3}
		// what we WANT
		//F1 {product=Snack{SnickersPrice= 2.0isVegan=true}, quantity=3}
	}
	public void printReceipt(Product product) throws IOException {
		String location = "receipt.txt";
		//String timeStamp = LocalDateTime.now().toString();
		double price = product.getPrice();
		String productName = product.getName();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(location, true))) {
			bw.write("Receipt " + LocalDateTime.now().toString() + "\n");
			bw.newLine();
			bw.write("Product Name: " + productName);
			bw.newLine();
			bw.write("Product Price: " + price);
		}
	}

	@Override
	public String toString() {
		return "VendingMachine{" +
			"slots=" + slots +
			'}';
	}
}
