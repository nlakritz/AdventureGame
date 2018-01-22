import java.util.*;

public class AdventureMain {
	static Scanner userInput = new Scanner(System.in);
	public static int choice;

	public static void main(String[] args) {
		System.out.print("WELCOME, PRESS ENTER TO BEGIN.");
		userInput.nextLine();
		Character player = new Character();
		System.out.print("What is your name? ");
		player.setName(userInput.nextLine());
		System.out.println("\nGame has begun. You are a detective contracted by the Queen of England to find her daughter who has gotten lost in a haunted mansion.\n");
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
//			lobby();
		} else if (choice == 2) {
			endgame();
		} else {
			System.out.println("You have not entered a valid choice, please try again.");
			entrance();
		}
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
