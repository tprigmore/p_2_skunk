package skunk.domain;

public class ScoreCard
{
	String playerName;
	int gamePoints;
	int turnPoints;
	int chips;
	int lastRoll;
	DiceState diceState;

	public ScoreCard()
	{
	}

	public String getPlayerName()
	{
		return playerName;
	}

	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}

	public int getGamePoints()
	{
		return gamePoints;
	}

	public void setGamePoints(int gamePoints)
	{
		this.gamePoints = gamePoints;
	}

	public int getTurnPoints()
	{
		return turnPoints;
	}

	public void setTurnPoints(int turnPoints)
	{
		this.turnPoints = turnPoints;
	}

	public int getChips()
	{
		return chips;
	}

	public void setChips(int chips)
	{
		this.chips = chips;
	}

	public int getLastRoll()
	{
		return lastRoll;
	}

	public void setLastRoll(int lastRoll)
	{
		this.lastRoll = lastRoll;
	}

	public DiceState getDiceState()
	{
		return diceState;
	}

	public void setDiceState(DiceState diceState)
	{
		this.diceState = diceState;
	}

}
