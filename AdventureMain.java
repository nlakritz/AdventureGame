import java.util.*;

public class AdventureMain {
	static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("WELCOME, PRESS ENTER TO BEGIN.");
		userInput.nextLine();
		Character player = new Character();
		System.out.print("What is your name? ");
		player.setName(userInput.next());
	}
}