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
		// player.pack = stack_game(player.pack);
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
		System.out.println("You now see three doors in the lobby, which one do you choose to enter");
		System.out.println("1: Enter the door to your left");
		System.out.println("2: Enter the door in front of you");
		System.out.println("3: Enter the door to your right");
		choice = userInput.nextInt();
		if (choice == 1) {
			leftDoor();
		} else if (choice == 2) {
			// middleDoor();
		} else if (choice == 3) {
			// rightDoor();
		} else {
			System.out.println("You have not entered a valid choice");
			lobby();
		}
	}

	public static void leftDoor() {
		Monster jam = new Monster();
		System.out.println("You have encountered a monster. It attacks you, tearing off your shirt.");
		player.decreaseHealth(1);
		System.out.println("1: Attack monster");
		System.out.println("2: Run past monster to the door behind it");
		choice = userInput.nextInt();
		if (choice == 1) {
			while (jam.checkLife()) {
				if (choice == 1) {
					jam.setHealth(attackMonster(player.getHand(), jam.getHealth(), jam.bodyPart()));
					System.out.println("The monster has " + jam.getHealth() +" health left" );
					player.decreaseHealth(1);
				}
			}
		} else if (choice == 2) {
			System.out.println(" As you run pass the monster it swipes at you gashing you back");
			player.decreaseHealth(3);
			// nextDoor();
		} else {
			System.out.println("You have not entered a valid choice");
			leftDoor();
		}
		System.out.println("The monster has dropped a blue key");
		System.out.println("You have acquired a blue key and now proceed through the door");
		player.pickup("blue key");
		
	}


	public static int attackMonster(String weapon, int health, String description) {
		if (weapon.equals("Nothing")) {
			health -= 1;
		}
		System.out.println("You have cut off the monsters " + description + " and done 1 damage");
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