import java.util.ArrayList;

public class Character {
	private String name;
	private int health;
	private String hand = "";
	ArrayList<String> pack = new ArrayList<String>(10);
	
	public void setName(String playerName) {
		name = playerName;
	}

	public String getName() {
		return name;
	}
	
	public void displayName() {
		System.out.println("Your name is " + name);
	}
	
	public int getHealth() {
		return health;
	}

	public void displayHealth() {
		System.out.println("You are currently at " + health);
	}
	
	public void decreaseHealth(int damage) {
		health -= damage;
		if (health <= 0)
			System.out.println("Sorry you have died"); // Maybe have a revive potion option.
	}
	
	public void pickup(String item) {
		pack.add(item);
	}

	public void drop(String item) {
		pack.remove(item);
	}
	
	public void equip(String object) {
		String temp = hand;
		for (String iterate : pack) {
			if (object.equals(iterate)) {
				hand = object;
			}
		}
		if (hand.equals(temp)) {
			System.out.println("You have not entered a valid item.");
		}
	}
	
	public String status() {
		if (hand.equals("")) {
			hand = "[nothing]";
		}
		return "Detective has " + health + " health left and is holding " + hand;
	}
	
	public Character() {
		health = 10;
		pack.add("Bandage"); // Gives +1 health
		pack.add("Flash Light"); // Some rooms are dark, so first need to equip flashlight to see room. Maybe to find a key or something else.
	}
}
