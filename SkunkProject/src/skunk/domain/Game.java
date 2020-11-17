package skunk.domain;

import java.util.ArrayList;

public class Game
{
	private GameState state;
	private ArrayList<Player> playerArray = new ArrayList<Player>();
	private int playerCount;
	private int playerIndex;
	private Kitty kitty = Kitty.getInstance();;

	public Game()
	{
		setState(GameState.IDLE);
		this.playerCount = 0;
		this.setPlayerIndex(0);
	}

	public void setPlayerIndex(int index)
	{
		this.playerIndex = index;
	}

	public int getPlayerIndex()
	{
		return this.playerIndex ;
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

	public int getPlayerCount()
	{
		return this.playerCount;
	}

	public void setKitty(int chips)
	{
		this.kitty.setKitty(chips);
	}
	
	public int getKitty()
	{
		return this.kitty.getKitty();
	}
}
