package skunk.domain;

import java.util.ArrayList;

public class Game
{
	private GameState state;
	private ArrayList<Player> playerArray = new ArrayList<Player>();
	private int playerCount;
	private int playerIndex;
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

	public int takeATurn()
	{
		this.turn = new Turn(this.playerArray.get(playerIndex));
		return (turn.takeATurn());
	}

	public GameState goToNextPlayer()
	{
		if(this.playerIndex == (playerCount - 1)) {
			this.playerIndex = 0;
			this.state = GameState.ROUND_END;
		}
		else {
			this.playerIndex++;
			this.state = GameState.ROUND_ACTIVE;
		}
		return this.state ;
	}

	public void addScorePoints()
	{
		Player activePlayer = this.playerArray.get(playerIndex);
		activePlayer.setGamePoints(activePlayer.getGamePoints() + activePlayer.getTurnPoints());
		activePlayer.setTurnPoints(0);
	}

	public int getPlayerTurnPoints()
	{
		Player activePlayer = this.playerArray.get(playerIndex);
		return activePlayer.getTurnPoints();
	}
}
