class monster{
	public int health;
	public boolean alive = true;
	
	public monster() {
		health = 3;
	}
	
	public boolean checkLife() {
		if(health <= 0) {
			alive = false;
		}
		return alive;
	}
}