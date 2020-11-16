package skunk.domain;

public class Player
{
	private String name;
	private int chips;
	private int gamePoints;
	private int turnPoints;

	public Player(String name)
	{
		this.setName(name);
		this.setChips(50);
		this.setGamePoints(0);
		this.setTurnPoints(0);
	}

	public void setChips(int chips)
	{
		this.chips = chips;
	}

	public int getChips()
	{
		return this.chips;
	}

	public Integer getGamePoints()
	{
		return this.gamePoints;
	}

	public void setGamePoints(int gamePoints)
	{
		this.gamePoints = gamePoints;
	}

	public void setTurnPoints(int points)
	{
		this.turnPoints = points;
	}

	public Integer getTurnPoints()
	{
		return this.turnPoints;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
