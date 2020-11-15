package skunk.domain;

public class Player {
	private int chips;
	
	public Player() {
		this.setChips(0);
	}

	private void setChips(int chips) {
		this.chips = chips;
		
	}

	public int getChips() {
		
		return this.chips;
	}

}
