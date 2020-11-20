package skunk.domain;

public class Turn
{
	private static final int SKUNK_PENALTY = 1;
	private static final int SKUNK_DEUCE_PENALTY = 2;
	private static final int DOUBLE_SKUNK_PENALTY = 4;

	private Dice dice;
	private Kitty kitty;
	private Player player;
	private DiceState state;

	public Turn(Player player)
	{
		this.dice = Dice.getInstance();
		this.kitty = Kitty.getInstance();
		this.player = player;
		this.state = DiceState.GOOD;
	}

	public DiceState getState()
	{
		this.state = dice.getState();
		return this.state;
	}

//	public void setDice(Dice dice)
//	{
//		this.dice = dice;
//	}

	public int takeATurn()
	{
		this.dice.roll();
		this.state = dice.getState();
		if (this.state == DiceState.DOUBLE_SKUNK)
		{
			this.kitty.setKitty(this.kitty.getKitty() + DOUBLE_SKUNK_PENALTY);
			this.player.setChips(this.player.getChips() - DOUBLE_SKUNK_PENALTY);
			this.player.setGamePoints(0);
			this.player.setTurnPoints(0);
		}
		else if (this.state == DiceState.SKUNK_DEUCE)
		{
			this.kitty.setKitty(this.kitty.getKitty() + SKUNK_DEUCE_PENALTY);
			this.player.setChips(this.player.getChips() - SKUNK_DEUCE_PENALTY);
			this.player.setTurnPoints(0);
		}
		else if (this.state == DiceState.SKUNK)
		{
			this.kitty.setKitty(this.kitty.getKitty() + SKUNK_PENALTY);
			this.player.setChips(this.player.getChips() - SKUNK_PENALTY);
			this.player.setTurnPoints(0);
		}
		else
		{
			this.player.setTurnPoints(this.player.getTurnPoints() + dice.getLastRoll());
		}
		return this.player.getTurnPoints();
	}
}
