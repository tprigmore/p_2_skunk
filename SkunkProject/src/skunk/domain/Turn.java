package skunk.domain;

public class Turn {
	private Dice dice;
	private Kitty kitty;
	private Player player;
	private DiceState state;

	public Turn(Dice dice, Kitty kitty, Player player) {
		this.setDice(dice);
		this.kitty = kitty;
		this.player = player;
	}

	public DiceState getState() {
		this.state = dice.getState();
		return this.state;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

	public void takeATurn() {
		this.dice.roll();
		this.state = dice.getState();
		if(this.state == DiceState.DOUBLE_SKUNK) {
			this.kitty.setKitty(this.kitty.getKitty() + 4); 
			this.player.setChips(this.player.getChips() - 4);
			this.player.setGamePoints(0);
			this.player.setTurnPoints(0);
		}
		else if (this.state == DiceState.SKUNK_DEUCE) {
			this.kitty.setKitty(this.kitty.getKitty() + 2); 
			this.player.setChips(this.player.getChips() - 2);
			this.player.setTurnPoints(0);
		}
		else if (this.state == DiceState.SKUNK) {
			this.kitty.setKitty(this.kitty.getKitty() + 1); 
			this.player.setChips(this.player.getChips() - 1);
			this.player.setTurnPoints(0);
		}
		else {
			this.player.setTurnPoints(this.player.getTurnPoints() +  dice.getLastRoll());
		}
	}

}
