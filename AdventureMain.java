import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class AdventureMain {
	static Scanner scan = new Scanner(System.in);
	public static int choice;
	public static Character panish;

	public static void main(String[] args) {
		System.out.println(
				"Game has begun. You are a detective contracted by the Queen of England to find her daughter that has gotten lost in a haunted mansion.");
		System.out.print("WELCOME TO THE DANK DUNGEON, PRESS ENTER TO BEGIN.");
		scan.nextLine();
		panish = new Character();
		System.out.print("What is your name? ");
		panish.setName(scan.next());
		entrance();
		// panish.pack = stack_game(panish.pack);
	}

	public static void entrance() {
		System.out.println("You have arrived at the haunted mansion's entrance.");
		System.out.println("1: Enter mansion through front gate");
		System.out.println("2: Leave");

		choice = scan.nextInt();

		if (choice == 1) {
//			lobby();
		} else if (choice == 2) {
			endgame();
		} else {
			System.out.println("You have not entered a valid choice");
			entrance();
		}
	}
	public static void endgame() {
		System.out.println("You have abandoned your mission. Game Over");
	}

	public static ArrayList<String> stack_game(ArrayList<String> jam) {
		ArrayList<String> temp = new ArrayList<String>();
		String[] arr = new String[5];
		String[] ans = { "red", "green", "blue", "yellow", "black" };
		System.out.println("You will need the following items: blue, red, green, yellow, black");
		System.out.println("if you do not have these items then leave");
		System.out.println("To place block type place (item)");

		Stack puzzle = new Stack();
		while (scan.hasNextLine()) {
			String item = scan.nextLine();
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
