package skunk.domain;

import java.util.ArrayList;

public class Game
{
	private GameState state;
	private ArrayList<Player> playerArray = new ArrayList<Player>();
	private int playerCount;
	private int playerIndex;

	public Game()
	{
		setState(GameState.IDLE);
		this.playerCount = 0;
		this.playerIndex = 0;
	}

	public GameState getState()
	{
		return state;
	}

	public void setState(GameState state)
	{
		this.state = state;
	}

	public void addPlayer(String name)
	{
		Player player = new Player(name);
		this.playerArray.add(player);
		this.playerCount++;
	}

	public Object getPlayerName()
	{
		Player player;
		player = this.playerArray.get(this.playerIndex);
		return player.getName();
	}

}
