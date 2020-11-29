package skunk.domain;

import java.util.ArrayList;

public class Game
{
	private GameState state;
	private ArrayList<Player> playerArray = new ArrayList<Player>();
	private Kitty kitty = Kitty.getInstance();
	private Turn turn;
	private ScoreBoard scoreBoard = new ScoreBoard();
	private int playerCount;
	private int playerIndex;
	private int lastPlayerIndex = -1;

	public Game()
	{
		setState(GameState.IDLE);
		this.playerCount = 0;
		this.setPlayerIndex(0);
		this.setKitty(0);
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
		ScoreCard scoreCard = new ScoreCard(name);
		scoreBoard.addScoreCard(scoreCard);
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

	public void takeATurn()
	{
		ScoreCard scoreCard = this.scoreBoard.getScoreCard(playerIndex);
		Player player = this.playerArray.get(playerIndex);
		this.turn = new Turn(player);
		turn.takeATurn();
		scoreCard.setGamePoints(player.getGamePoints());
		scoreCard.setTurnPoints(player.getTurnPoints());
		scoreCard.setLastRoll(player.getLastRoll());
		scoreCard.setDiceState(player.getDiceState());
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
		ScoreCard scoreCard = this.scoreBoard.getScoreCard(playerIndex);
		scoreCard.setGamePoints(activePlayer.getGamePoints());
		scoreCard.setTurnPoints(activePlayer.getTurnPoints());
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

	public Player findWinner()
	{
		Player player;
		int maxGamePionts = 0;
		int maxPlayerIndex = 0;
		
		for (int i = 0; i < this.playerCount; i++)
		{
			player = this.playerArray.get(i);
			if (player.getGamePoints() > maxGamePionts)
			{
				maxGamePionts = player.getGamePoints();
				maxPlayerIndex = i;
			}
		}
		return this.playerArray.get(maxPlayerIndex);
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
	
//	public String getPlayerRollStats()
//	{
//		Player player;
//		player = this.playerArray.get(this.playerIndex);
//		
//		String returnString;
//		String skunkString;
//		switch (this.turn.getState())
//		{
//		case GOOD:
//			skunkString = String.valueOf(this.turn.getLastRoll());
//			break;
//		case DOUBLE_SKUNK:
//			skunkString = "Double Skunk";
//			break;
//		case SKUNK_DEUCE:
//			skunkString = "Skunk Deuce";
//			break;
//		case SKUNK:
//			skunkString = "Skunk";
//			break;
//		default:
//			skunkString = " ";
//			break;
//		}
//		returnString = player.getName() + " rolled a " + skunkString + ". Turn points = "
//				+ player.getTurnPoints() + ". Game points = " + player.getGamePoints() + ". Chips = "
//				+ player.getChips() + "\n";
//		return returnString;
//	}
//	
//	public String getAllPlayerStats()
//	{
//		Player player;
//		String returnString = "";
//		
//		for (int i = 0; i < this.playerCount; i++) {
//		player = this.playerArray.get(i);
//		
//		returnString = returnString + player.getName() + " has " + player.getGamePoints() + 
//				" game points and " + player.getChips() + " chips.\n";
//		}
//		returnString = returnString + "---------------------------------------------------\n";
//		return returnString;
//	}

	public ScoreCard getScoreCard()
	{
		return this.scoreBoard.getScoreCard(playerIndex);
	}

	public ScoreBoard getScoreBoard()
	{
		return this.scoreBoard;
	}
}
