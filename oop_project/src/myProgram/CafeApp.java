package myProgram;

import java.io.*;
import java.util.*;
import java.util.InputMismatchException;

//This is the main class for the CafeApp program
public class CafeApp {
	public static void main(String[] args) {
		Cafe cafe = new Cafe();

		// Load the menu from a file
		try {
			cafe.loadMenuFromFile("menu.txt");
		} catch (IOException e) {
			System.out.println("Failed to load menu from file.");
			System.exit(1);
		}

		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Welcome to CafeApp!");
			System.out.println("--------------------");
			System.out.println("1. View Menu");
			System.out.println("2. Create Order");
			System.out.println("3. View Order History");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			try {
				choice = scanner.nextInt();
				scanner.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("--------------------\nInvalid input. Please enter a number.\n");
				scanner.nextLine();
				choice = 0;
			}

			switch (choice) {
			case 1:
				System.out.println("--------------------\nMenu:");
				System.out.println(cafe.getMenu().toString());
				break;
			case 2: // Allow the user to create a new order
				System.out.println("--------------------\nMenu:");
				System.out.println(cafe.getMenu().toString());
				ArrayList<String> itemNames = new ArrayList<String>();
				while (true) {
					System.out.print("Enter item number (Type 0 to finish order): ");
					try {
						int itemNumber = scanner.nextInt();
						scanner.nextLine();
						if (itemNumber == 0) {
							break;
						}
						try {
							MenuItem item = cafe.getMenu().getItems().get(itemNumber - 1);
							itemNames.add(item.getName());
						} catch (IndexOutOfBoundsException e) {
							System.out.println("--------------------\nInvalid item number.\n");
						}
					} catch (InputMismatchException e) {
						System.out.println("--------------------\nInvalid input. Please enter a number.\n");
						scanner.nextLine();
					}
				}
				// Create a new order
				Order order = cafe.createOrder(itemNames.toArray(new String[itemNames.size()]));
				System.out.println("\nOrder created successfully.");
				System.out.println(order.getOrderSummary());
				System.out.print("\nConfirm order (y/n)? ");
				String confirm = scanner.nextLine();
				if (confirm.equalsIgnoreCase("y")) {
					System.out.println("\nOrder confirmed.");
				} else {
					System.out.println("\nOrder cancelled.");
				}

				break;
			case 3:
				cafe.viewOrderHistory();
				break;
			case 4:
				System.out.println("--------------------\nThank you for using CafeApp!\n");
				break;
			default:
				System.out.println("--------------------\nInvalid choice.\n");
				break;
			}
			System.out.println();
		} while (choice != 4);
		scanner.close();
	}
}