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
	}

}
