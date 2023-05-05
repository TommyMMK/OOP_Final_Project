package myProgram;

import java.util.ArrayList;

//This class represents a customer's order.
class Order {
	private ArrayList<MenuItem> items;

	public Order() {
		items = new ArrayList<MenuItem>();
	}

	public void addItem(MenuItem item) {
		items.add(item);
	}

	public double getTotalPrice() {
		double totalPrice = 0;
		for (MenuItem item : items) {
			totalPrice += item.getPrice();
		}
		return totalPrice;
	}

//Returns a string summary of the order.
//Each ordered item is listed along with its price.
	public String getOrderSummary() {
		StringBuilder sb = new StringBuilder();
		for (MenuItem item : items) {
			sb.append(item.getName()).append("\t\t$").append(item.getPrice()).append("\n");
		}
		sb.append("Total price:\t$").append(getTotalPrice());
		return sb.toString();
	}
}