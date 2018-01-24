import java.util.*;

public class AdventureMain {
	static Scanner userInput = new Scanner(System.in);
	static Character player = new Character();
	public static int choice;

	public static void main(String[] args) {
		System.out.print("WELCOME, PRESS ENTER TO BEGIN.");
		userInput.nextLine();
		System.out.print("What is your name? ");
		player.setName(userInput.nextLine());
		System.out.println(
				"\nGame has begun. You are a detective contracted by the Queen of England to find her daughter who has gotten lost in a haunted mansion.\n");
		entrance();
		userInput.close();
	}

	public static void entrance() {
		System.out.println("You have arrived at the entrance of the haunted mansion.");
		System.out.println("1: Enter mansion through front gate");
		System.out.println("2: Leave");

		choice = userInput.nextInt();

		if (choice == 1) {
			lobby();
		} else if (choice == 2) {
			endgame();
		} else {
			System.out.println("You have not entered a valid choice, please try again.");
			entrance();
		}
	}

	public static void lobby() {
		System.out.println("You now see three doors in the lobby, which one do you choose to enter?");
		System.out.println("1: Enter the door to your left");
		System.out.println("2: Enter the door in front of you");
		System.out.println("3: Enter the door to your right");
		choice = userInput.nextInt();
		if (choice == 1) {
			a1();
		} else if (choice == 2) {
			a2();
		} else if (choice == 3) {
			// a3();
		} else {
			System.out.println("You have not entered a valid choice, please try again.");
			lobby();
		}
	}

	public static void a1() {
		Monster jam = new Monster(5);
		System.out.println("You have encountered a monster. It attacks you, tearing off your shirt.");
		player.decreaseHealth(1);
		System.out.println("1: Attack monster");
		System.out.println("2: Run past monster to the door behind it");
		choice = userInput.nextInt();
		if (choice == 1) {
			while (jam.checkLife()) {
				if (choice == 1) {
					jam.setHealth(attackMonster(player.getHand(), jam.getHealth(), jam.bodyPart()));
					if (jam.getHealth() > 0) {
						System.out.println("The monster has " + jam.getHealth() + " health left");
					}
					else {
						System.out.println("The monster has 0 health left");
					}
					player.decreaseHealth(1);
				}
			}
		} else if (choice == 2) {
			System.out.println("As you run pass the monster it swipes at you, gashing your back.");
			player.decreaseHealth(3);
			// b1();
		} else {
			System.out.println("You have not entered a valid choice, please try again.");
			a1();
		}
		System.out.println("The monster has dropped a blue key!");
		System.out.println("You have acquired a blue key and now proceed through the door...");
		player.pickup("blue key");
	}

	public static void a2() {
		System.out.println(
				"You enter a musty storage room. There are two cardboard boxes on the ground, both sealed with tape.");
		System.out.println("The left box is labeled [WEAPONS] and right box is labeled [FOOD]. Which do you open?");
		System.out.println("1: Open the left box");
		System.out.println("2: Open the right box");
		choice = userInput.nextInt();
		if (choice == 1) {
			System.out.println(
					"As you approach the mysterious box, you hear the ground creak. You open the box and find a butter knife. \nJust as you pocket your loot, the floor suddenly caves in and you fall into a pile of wood chips.");
			player.decreaseHealth(2);
			player.pickup("Butter Knife");
			System.out.println("Obtained +1 Butter Knife!");
			} else if (choice == 2) {
			System.out.println(
					"As you approach the mysterious box, you hear the ground creak. You open the box and find a bowl of fresh stew. \nJust as you pick up your loot, the floor caves in and you fall into a pile of wood chips.");
			player.decreaseHealth(2);
			player.pickup("Stew");
			System.out.println("Obtained +1 Stew!");
		} else {
			System.out.println("You have not entered a valid choice, please try again.");
			a2();
		}
		// b2();
	}

	public static int attackMonster(String weapon, int health, String description) {
		int damage = 0;
		if (weapon.equals("Nothing")) {
			if (description.equals("left head") || description.equals("middle head") || description.equals("right head")) {
				damage = 2;
				health -= 2;
			}
			else {
				damage = 1;
				health -= 1;
			}
		}
		else if (weapon.equals("Butter Knife")) {
			if (description.equals("left head") || description.equals("middle head") || description.equals("right head")) {
				damage = 3;
				health -= 3;
			}
			else {
				damage = 2;
				health -= 2;
			}
		}

		System.out.println("You have cut off the monsters " + description + " and done " + damage + " damage");
		return health;
	}

	public static void endgame() {
		System.out.println("You have abandoned your mission. GAME OVER.");
	}

	public static ArrayList<String> stack_game(ArrayList<String> jam) {
		ArrayList<String> temp = new ArrayList<String>();
		String[] arr = new String[5];
		String[] ans = { "red", "green", "blue", "yellow", "black" };
		System.out.println("You will need the following items: blue, red, green, yellow, black");
		System.out.println("if you do not have these items then leave");
		System.out.println("To place block type place (item)");

		Stack puzzle = new Stack();
		while (userInput.hasNextLine()) {
			String item = userInput.nextLine();
			if (!jam.contains(item) && !item.equals("q")) {
				System.out.println("You don't have this item");
				continue;
			} else {
				jam.remove(item);
			}
			if (item.equals("q")) {
				break;
			} else {
				puzzle.push(item);
			}
		}
		System.out.println(puzzle);
		for (int i = 0; i < 5; i++) {
			if (!puzzle.isEmpty() && !ans[i].equals((String) puzzle.pop())) {
				System.out.println("Not correct order try Again!!");
				puzzle.clear();
				break;
			}
			System.out.println("Correct");
		}
		return jam;
	}
}