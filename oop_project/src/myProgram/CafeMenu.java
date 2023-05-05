package myProgram;

import java.util.ArrayList;

//This class represents a menu for a cafe.
class CafeMenu {
//Private instance variable to store menu items.
	private ArrayList<MenuItem> items;

	// Constructor to initialize an empty menu.
	public CafeMenu() {
		items = new ArrayList<MenuItem>();
	}

	// Adds a menu item to the menu.
	public void addItem(MenuItem item) {
		items.add(item);
	}

	// Returns a list of all the menu items
	public ArrayList<MenuItem> getItems() {
		return items;
	}

	// Returns the MenuItem object with the specified name.
	// Throws an ItemNotFoundException if the item is not found.
	public MenuItem getItemByName(String name) {
		for (MenuItem item : items) {
			if (item.getName().equals(name)) {
				return item;
			}
		}
		MenuItem MenuItem = new MenuItem(name, 0);
		return MenuItem;
	}

//Returns a string representation of the menu.
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (MenuItem item : items) {
			sb.append(item.toString()).append("\n");
		}
		return sb.toString();
	}
}