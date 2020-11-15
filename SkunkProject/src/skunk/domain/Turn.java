package skunk.domain;

public class Turn {
	private Dice dice;
	private Kitty kitty;
	private Player player;

	public Turn(Dice dice, Kitty kitty, Player player) {
		this.setDice(dice);
		this.kitty = kitty;
		this.player = player;
	}

	public DiceState getState() {
		return dice.getState();
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

}
