package myProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//The main class that ties everything together in the cafe program.
class Cafe {
	private CafeMenu menu;
	private ArrayList<Order> orderHistory;

	public Cafe() {
		menu = new CafeMenu();
		orderHistory = new ArrayList<Order>();
	}

	// Method that loads the menu from a file.
	public void loadMenuFromFile(String filename) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line;
		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(",");
			String name = parts[0];
			double price = Double.parseDouble(parts[1]);
			MenuItem item = new MenuItem(name, price);
			menu.addItem(item);
		}
		reader.close();
	}

	// Method that returns the cafe menu.
	public CafeMenu getMenu() {
		return menu;
	}

	// Method that creates an order based on an array of item names.
	public Order createOrder(String[] itemNames) {
		Order order = new Order();
		for (String itemName : itemNames) {
			MenuItem item = menu.getItemByName(itemName);
			order.addItem(item);
		}
		orderHistory.add(order);
		return order;
	}

	// Method that prints out the order history.
	public void viewOrderHistory() {
		if (orderHistory.size() == 0) {
			System.out.println("--------------------\nNo order history found.");
		} else {
			System.out.println("-------------------- \nOrder history:");
			for (int i = 0; i < orderHistory.size(); i++) {
				System.out.println("Order " + (i + 1) + ":");
				System.out.println(orderHistory.get(i).getOrderSummary());
			}
		}
	}
}