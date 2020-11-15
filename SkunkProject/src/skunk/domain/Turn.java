package skunk.domain;

public class Turn {
	private Dice dice;

	public Turn(Dice dice) {
		this.setDice(dice);
	}

	public DiceState getDiceState() {
		return dice.getState();
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

}
