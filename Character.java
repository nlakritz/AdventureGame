import java.util.ArrayList;

public class Character {
	private String name;
	private int health;
	private int maxhealth;
	private String hand = "Nothing";
	ArrayList<String> pack = new ArrayList<String>(10);
	
	public void setName(String playerName) {
		name = playerName;
	}

	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return health;
	}
	
	private void increaseHealth(int hearts) {
		for (int i = hearts; (i > 0) && (health < maxhealth); i--) {
			health++;
		}
	}
	
	public void decreaseHealth(int damage) {
		health -= damage;
		if (health <= 0) {
			System.out.println("Sorry, you have died."); // Maybe have a revive potion option.
		}
	}
	
	public void pickup(String item) {
		pack.add(item);
	}

	public void drop(String item) {
		pack.remove(item);
	}
	
	public void equip(String object) {
		if (hand.equals(object)) {
			System.out.println("You already have [" + object + "] equipped.");
		}
		else {
			String temp = hand;
			for (String iterate : pack) {
				if (object.equals(iterate)) {
					hand = object;
				}
			}
			if (hand.equals(temp)) {
				System.out.println("You have not entered a valid item.");
			}
				
			else if (hand.equals("Bandage")) {
				System.out.println("You have used [Bandage] to recover 1 HP.");
				increaseHealth(1);
				drop("Bandage"); // Consumable items must be removed from inventory after use.
				hand = temp;
			}
			else if (hand.equals("Stew")) {
				System.out.println("You have used [Stew] to recover 3 HP.");
				increaseHealth(3);
				drop("Stew");
				hand = temp;
			}
			else if (hand.equals("Super Healing Potion")) {
				System.out.println("You have used [Super Healing Potion] to recover all HP.");
				health = maxhealth;
				drop("Super Healing Potion");
				hand = temp;
			}
		}
	}
	
	public void status() {
		System.out.println("You have " + health + " health left and are holding [" + hand + "].");
	}
	
	public void death() {
		for (String iterate : pack) {
			if (iterate.equals("Kiss of Life")) {
				System.out.println("You have a revive item. Use it? (Y/N)");
			}
			else {
				System.out.println("You have died. GAME OVER.");
			}
		}
	}
	
	public Character() {
		maxhealth = 10;
		health = 10;
		pack.add("Bandage");
		pack.add("Flashlight");
	}
}
