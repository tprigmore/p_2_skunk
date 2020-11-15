package skunk.domain;

public class Player {
	private int chips;
	private int gamePoints;
	
	public Player() {
		this.setChips(50);
		this.setGamePoints(0);
	}

	public void setChips(int chips) {
		this.chips = chips;
	}

	public int getChips() {
		return this.chips;
	}

	public Integer getGamePoints() {
		return this.gamePoints;
	}

	public void setGamePoints(int gamePoints) {
		this.gamePoints = gamePoints;
	}

}
