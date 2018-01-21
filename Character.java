public class Character {
	private String name;
	
	public void setName(String playerName) {
		name = playerName;
	}

	public String getName() {
		return name;
	}
	
	public void displayName() {
		System.out.println("Your name is " + name);
	}
}
