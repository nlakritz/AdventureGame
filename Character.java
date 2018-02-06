import java.util.*;

public class Character {
	private String name;
	private int health;
	private int maxhealth;
	private String hand = "Nothing";
	ArrayList<String> pack = new ArrayList<String>(10);

	public Character() {
		maxhealth = 10;
		health = 10;
		pack.add("Bandage");
		pack.add("Flashlight");
	}

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
			death();
		}
	}

	public String getHand() {
		return hand;
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
		} else {
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
			} else if (hand.equals("Bread")) {
				System.out.println("You have used [Bread] to recover 2 HP.");
				increaseHealth(2);
				drop("Bread");
				hand = temp;
			} else if (hand.equals("Stew")) {
				System.out.println("You have used [Stew] to recover 3 HP.");
				increaseHealth(3);
				drop("Stew");
				hand = temp;
			} else if (hand.equals("Super Healing Potion")) {
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
	
	public static int attack(String weapon, int health, String description) {
		int damage = 0;
		if (weapon.equals("Nothing")) {
			if (description.equals("left head") || description.equals("middle head")
					|| description.equals("right head")) {
				damage = 2;
				health -= 2;
			} else {
				damage = 1;
				health -= 1;
			}
		} else if (weapon.equals("Butter Knife")) {
			if (description.equals("left head") || description.equals("middle head")
					|| description.equals("right head")) {
				damage = 3;
				health -= 3;
			} else {
				damage = 2;
				health -= 2;
			}
		} else if (weapon.equals("Axe")) {
			if (description.equals("left head") || description.equals("middle head")
					|| description.equals("right head")) {
				damage = 4;
				health -= 4;
			} else {
				damage = 3;
				health -= 3;
			}
		}
		System.out.println("You have cut off the monsters " + description + " and done " + damage + " damage");
		return health;
	}

	public boolean death() {
		Scanner revivechoice = new Scanner(System.in);
		for (String iterate : pack) {
			if (iterate.equals("Kiss of Life")) {
				System.out.print("You have a revive item. Use it? (Y/N) ");
				while (true) {
					String choice = revivechoice.nextLine();
					if (choice.equals("Y")) {
						System.out.println("You have been resurrected!");
						revivechoice.close();
						return false;
					} else if (choice.equals("N")) {
						System.out.println("You have died. GAME OVER.");
						revivechoice.close();
						return true;
					} else {
						System.out.print("That is not a valid answer. Please try again. ");
					}
				}
			}
		}
		System.out.println("You have died. GAME OVER.");
		revivechoice.close();
		return true;
	}
}