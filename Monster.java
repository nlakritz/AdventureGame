import java.util.*;

public class Monster {
	private static ArrayList<Integer> arr = new ArrayList<Integer>();
	private int health;
	private static int counter = 0;
	public boolean alive = true;

	public Monster() {
		health = 3;
	}

	public boolean checkLife() {
		if (health <= 0) {
			alive = false;
		}
		return alive;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int newhealth) {
		health = newhealth;
	}

	public String bodyPart() {
		int num = (int) (Math.random() * 8);
		String part = "";
		while (arr.contains(num)) {
			num = (int) (Math.random() * 8);
		}
		arr.add(num);

		if (num == 0) {
			part = "left leg";
		} else if (num == 1) {
			part = "right leg";
		} else if (num == 2) {
			part = "left arm";
		} else if (num == 3) {
			part = "right arm";
		} else if (num == 4) {
			part = "tail";
		} else if (num == 5) {
			part = "left head";
		} else if (num == 6) {
			part = "middle head";
		} else if (num == 7) {
			part = "right head";
		}
		return part;
	}
}