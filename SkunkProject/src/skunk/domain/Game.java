package skunk.domain;

import java.util.ArrayList;

public class Game
{
	private GameState state;
	private ArrayList<Player> playerArray = new ArrayList<Player>();
	private int playerCount;
	private int playerIndex;
	private int lastPlayerIndex = -1;
	private Kitty kitty = Kitty.getInstance();
	private Turn turn;

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
		return this.playerIndex;
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

	public String getPlayerName()
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

	public int takeATurn()
	{
		this.turn = new Turn(this.playerArray.get(playerIndex));
		return (turn.takeATurn());
	}

	public GameState goToNextPlayer()
	{
		this.playerIndex++;

		if (this.state == GameState.FINAL_ROUND)
		{
			if (this.playerIndex == playerCount)
			{
				this.playerIndex = 0;
			}
			if (this.playerIndex == this.lastPlayerIndex)
			{
				this.state = GameState.GAME_OVER;
			}
		}
		else if (this.playerIndex == playerCount)
		{
			this.playerIndex = 0;
			this.state = GameState.ROUND_END;
		}
		else
		{
			this.state = GameState.ROUND_ACTIVE;
		}
		return this.state;
	}

	public void addScorePoints()
	{
		Player activePlayer = this.playerArray.get(playerIndex);
		activePlayer.setGamePoints(activePlayer.getGamePoints() + activePlayer.getTurnPoints());
		if (activePlayer.getGamePoints() >= 100)
		{
			this.state = GameState.FINAL_ROUND;
			if (this.lastPlayerIndex == -1)
			{
				this.lastPlayerIndex = playerIndex;
			}
		}
		activePlayer.setTurnPoints(0);
	}

	public int getPlayerTurnPoints()
	{
		Player activePlayer = this.playerArray.get(playerIndex);
		return activePlayer.getTurnPoints();
	}

	public int getPlayerGamePoints()
	{
		Player activePlayer = this.playerArray.get(playerIndex);
		return activePlayer.getGamePoints();
	}

	public int getPlayerChips()
	{
		Player activePlayer = this.playerArray.get(playerIndex);
		return activePlayer.getChips();
	}
}
