import java.util.*;

public class AdventureMain {
	static Scanner userInput = new Scanner(System.in);
	static Character player = new Character();
	static int choice;

	public static void main(String[] args) {
		System.out.print("WELCOME, PRESS ENTER TO BEGIN.");
		userInput.nextLine();
		System.out.print("What is your name? ");
		player.setName(userInput.nextLine());
		System.out.println(
				"\nGame has begun! You are a detective contracted by the Queen of England to find her daughter who has gotten lost in a haunted mansion.\n");
		entrance();
		userInput.close();
	}

	public static void entrance() {
		System.out.println("You have arrived at the entrance of the haunted mansion.");
		System.out.println("1: Enter mansion through front gate");
		System.out.println("2: Leave");
		choice = intCheck(2); // Pass the total number of choices.
		if (choice == 1) {
			lobby();
		} else if (choice == 2) {
			System.out.println("You have abandoned your mission. GAME OVER.");
		}
	}

	public static void lobby() {
		System.out.println("You now see three doors in the lobby, which one do you choose to enter?");
		System.out.println("1: Enter the door to your left");
		System.out.println("2: Enter the door in front of you");
		System.out.println("3: Enter the door to your right");
		choice = intCheck(3);
		if (choice == 1) {
			a1();
		} else if (choice == 2) {
			a2();
		} else if (choice == 3) {
			a3();
		}
	}

	public static void a1() {
		Monster jam = new Monster(4);
		System.out.println("You have encountered a monster. It attacks you, tearing off your shirt.");
		player.decreaseHealth(1);
		System.out.println("1: Attack monster");
		System.out.println("2: Run past monster to the door behind it");
		choice = intCheck(2);
		if (choice == 1) {
			while (jam.checkLife()) {
				jam.setHealth(player.attack(player.getHand(), jam.getHealth(), jam.bodyPart()));
				if (jam.getHealth() > 0) {
					System.out.println("The monster has " + jam.getHealth() + " health left");
				} else {
					System.out.println("The monster has 0 health left\n");
				}
				player.decreaseHealth(1);
			}
		} else if (choice == 2) {
			System.out.println("As you run pass the monster it swipes at you, gashing your back.");
			player.decreaseHealth(3);
		}
		System.out.println("The monster has dropped a blue key!");
		System.out.println("You have acquired a blue key and now proceed through the door...\n");
		player.pickup("blue key");
		b1();
	}

	public static void a2() {
		System.out.println(
				"You enter a musty storage room. There are two cardboard boxes on the ground, both sealed with tape.");
		System.out.println("The left box is labeled [WEAPONS] and right box is labeled [FOOD]. Which do you open?");
		System.out.println("1: Open the left box");
		System.out.println("2: Open the right box");
		System.out.println("3: Look around");
		choice = intCheck(3);
		if (choice == 1) {
			System.out.println(
					"As you approach the mysterious box, you hear the ground creak. You open the box and find a butter knife. \nJust as you pocket your loot, the floor suddenly caves in and you fall into a pile of wood chips.");
			player.decreaseHealth(2);
			player.pickup("Butter Knife");
			System.out.println("Obtained +1 Butter Knife!\n");
		} else if (choice == 2) {
			System.out.println(
					"As you approach the mysterious box, you hear the ground creak. You open the box and find a bowl of fresh stew. \nJust as you pick up your loot, the floor caves in and you fall into a pile of wood chips.");
			player.decreaseHealth(2);
			player.pickup("Stew");
			System.out.println("Obtained +1 Stew!\n");
		} else if (choice == 3) {
			System.out.println(
					"The room appears to be a dead end. It's empty other than the two mysterious boxes laid before you.\n");
			a2();
		}
		b2();
	}

	public static void a3() {
		System.out.println(
				"You survey a large hallway -- its walls are lined with aging artifacts.\nA rusty hatchet stands out among rows of old ornaments and documents.");
		System.out.println("1: Take the axe");
		System.out.println("2: Look around");
		choice = intCheck(2);
		if (choice == 1) {
			player.pickup("Axe");
			System.out.println("The axe is light and sharp. Although old, it should come in handy. Obtained +1 Axe!");
			System.out.println("You head for the exit with your new choice of weapon.\n");
			b3();
		} else if (choice == 2) {
			System.out.println(
					"Any of the items could probably be sold for a nice profit, but you have a mission to complete...\n");
			a3();
		}
	}

	public static void b1() {
		System.out.println(
				"You appear to have found the kitchen. However, all the food is gone except for a single loaf of moldy bread.");
		System.out.println("1: Take the bread");
		System.out.println("2: Look around");
		choice = intCheck(2);
		if (choice == 1) {
			System.out.println("You take the stale bread, and proceed through to the next room. Obtained +1 Bread!\n");
			player.pickup("Bread");
			c1();
		} else if (choice == 2) {
			System.out.println("All the dishes are stashed away nicely. Everything seems to be inactive.\n");
			b1();
		}

	}

	public static void b2() {
		Monster speedy = new Monster(4);
		int escape = (int) (Math.random() * 3);
		System.out.println(
				"Dazed and slightly injured, you slowly get up. A large monster watches from a distance, awaiting your arrival.");
		System.out.println("It growls and suddenly rushes toward you at lightning speed! It's a trap!");
		System.out.println("1: Defend yourself in combat");
		System.out.println("2: Attempt to dodge the attack and rush for the exit");
		choice = intCheck(2);
		if (choice == 1) {
			while (speedy.checkLife()) {
				speedy.setHealth(player.attack(player.getHand(), speedy.getHealth(), speedy.bodyPart()));
				if (speedy.getHealth() > 0) {
					System.out.println("The monster has " + speedy.getHealth() + " health left");
				} else {
					System.out.println("The monster has 0 health left");
				}
				player.decreaseHealth(1);
			}
		} else if (choice == 2) {
			if (escape == 2) {
				System.out.println("You successfully evade the monster's attack and escape completely unharmed.");
			} else {
				System.out.println(
						"The monster lands a flurry of direct blows, yet you somehow manage to squirm over to the exit and escape.");
				player.decreaseHealth(4);
			}
		}
		System.out.println("On the way out, you manage to strip the monster of a red key. It looks useful.\n");
		player.pickup("red key");
		c2();
	}

	public static void b3() {
		String guess;
		System.out.println(
				"As you enter the next room, you feel a sense of danger. The room is completely empty, with a massive steel door blocking your next move.");
		System.out.println(
				"You try the door... but it's locked solid. Suddenly, you hear a raspy voice coming in from all around.");
		System.out.println("Creepy Voice: Hello " + player.getName()
				+ ". I'm going to have to stop you right here. To get past, you must solve the following riddle:");
		System.out.println("What has a head and a tail, but no body? A _______.");
		guess = userInput.nextLine();
		while ((!guess.equals("Coin")) && !guess.equals("coin")) {
			System.out.println("Please try again.");
			guess = userInput.nextLine();
		}
		System.out.println("Creepy Voice: Correct! You may pass.");
		System.out.println("The steel door unlocks and your journey continues forward.\n");
		c2();
	}

	public static void c1() {
		Scanner lightchoice = new Scanner(System.in);
		System.out.println("Everything is pitch black... Equip your flashlight? (Y/N)");
		while (true) {
			String c = lightchoice.nextLine();
			if (c.equals("Y")) {
				player.equip("Flashlight");
				break;
			} else if (c.equals("N")) {
				break;
			} else {
				System.out.print("That is not a valid answer. Please try again.\n");
			}
		}
		if (player.getHand().equals("Flashlight")) {
			System.out.println(
					"Your flashlight illuminates the room. You see a black key on the ground and pick it up. Nothing else seems to be here, so you move ahead.");
			lightchoice.close();
			player.pickup("black key");
			// d1();
		} else if (!player.getHand().equals("Flashlight")) {
			System.out.println("You need some light to proceed.\n");
			c1();
		}
	}
	
	public static void c2() {
		Monster giant = new Monster(6);
		System.out.println("A giant monster awaits you, stronger than any you have faced previously. Your weapon upgrades and consumables will be needed here.");
		System.out.println("1: Engage in battle");
		System.out.println("2: Run past your opponent and escape");
		choice = intCheck(2);
		if (choice == 1) {
			while (giant.checkLife()) {
				giant.setHealth(player.attack(player.getHand(), giant.getHealth(), giant.bodyPart()));
				if (giant.getHealth() > 0) {
					System.out.println("The monster has " + giant.getHealth() + " health left");
				} else {
					System.out.println("The monster has 0 health left");
				}
				player.decreaseHealth(1);
			}
		}
		else if (choice == 2) {
			System.out.println("You try and sidestep the monster, but it's just too large. There's no running from this one... COMBAT PHASE INITATE!");
			while (giant.checkLife()) {
				giant.setHealth(player.attack(player.getHand(), giant.getHealth(), giant.bodyPart()));
				if (giant.getHealth() > 0) {
					System.out.println("The monster has " + giant.getHealth() + " health left");
				} else {
					System.out.println("The monster has 0 health left");
				}
				player.decreaseHealth(1);
			}		
		}
		System.out.println("Defeated, the monster hands you a green key before disintegrating into dust.\n");
		player.pickup("green key");
		System.out.println("There are two ways to exit this room. Choose one.");
		System.out.println("1. Go left");
		System.out.println("2. Go right");
		choice = intCheck(2);
		if (choice == 1) {
			//d2();
		}
		else if (choice == 2) {
			//d3();
		}
	}

	public static void stackRoom() {
		Scanner keyChoice = new Scanner(System.in);
		ArrayList<String> temp = new ArrayList<String>();
		ArrayList<String> backup = new ArrayList<String>();
		System.out.println("To place a key type ( ___key) and when you are finished type (done) ");
		String answer = "";
		while (!answer.equals("done")) {
			answer = keyChoice.nextLine();
			if (answer.equals("done")) {
				break;
			} else if (!player.pack.contains(answer)) { // to check if player has said item
				System.out.println("You do not have this item");
				break;
			}
			temp.add(answer);
			backup.add(answer); // in case he doesn't have all the keys and i need to put keys back in the pack
			player.pack.remove(answer); // removes keys from bag
		}
		if (temp.size() != 3) { // checks if he has right number of keys, if not puts keys back in bag
			player.pack.addAll(backup);
			System.out.println("You do not have enough keys, come back when you have found them all");
			home();
		}
		boolean ans = stackGame(temp);
		if(ans) {
			endGame();
		}
	}

	public static void home() {
		System.out.println("You are home");
	}
 
	public static boolean stackGame(ArrayList<String> jam) {
		ArrayList<String> temp = new ArrayList<String>();
		String[] arr = new String[3];
		String[] ans = { "blue key", "red key", "black key" };
		Stack puzzle = new Stack(); 
		int n = 0;
		while (n < 3) {
			puzzle.push(jam.get(n));
			n++;
		}
		System.out.println(puzzle);
		for (int i = 0; i < 3; i++) {
			if (!ans[i].equals((String) puzzle.pop())) {
				System.out.println("Not correct order try Again!!");
				puzzle.clear();
				return false;
			}
			System.out.println("Correct");
		}
		return true;
	}

	public static void endGame() {
		System.out.println("You enter a bedroom and see the most beautiful woman you will ever lay eyes on in your entire life and those to come.");
		System.out.println("She's laying down on the bed not making a noise.");
		System.out.println("You try and get her attention but nothing seems to work so you walk closer now");
		System.out.println("Now by the bedside, you realize that she isn't sleeping, she's dead.");
		System.out.println("If you still have the revive potion you can use it here. (Y/N)");
		String choice = userInput.nextLine();
		if (choice.equals("Y")) {
			if (player.pack.contains("revive potion")) {
				player.pack.remove("revive potion");
				System.out.println("She opens her eyes and looks around. You are stunned by her beautiful blue eyes. After regaining your composure you"
						+ " explain what has happened. She stands up and you both walk out of the mansion");
				System.out.println("Congratulations you have won the game");
			}
		} else if (choice.equals("Y")) {
			if (!player.pack.contains("revive potion")) {
				System.out.println("You don't have the revive potion. If you have used it you can't save Taylor and the game is over. You couldn't save Taylor.");
			}
		} else if (choice.equals("N")) {
			System.out.println("You couldn't save Taylor and have failed the mission." );
		}

	}

	public static int intCheck(int options) {
		int selection;
		do {
			while (!userInput.hasNextInt()) {
				System.out.println("Please enter an integer value.");
				userInput.nextLine();
			}
			selection = userInput.nextInt();
			if (selection > options || selection < 1) {
				System.out.println("Please enter a valid choice.");
				userInput.nextLine();
			}
		} while (selection > options || selection < 1);
		userInput.nextLine();
		return selection;
	}
}