package skunk.domain;

public class Controller
{
	private ControllerState state;
	private Game game = new Game();
	private Dice dice = Dice.getInstance();

	public Controller()
	{
		this.state = ControllerState.START_GAME;
	}

	public ControllerState getState()
	{
		return this.state;
	}

	// public int getPlayerCount()
	// {
	// return game.getPlayerCount();
	// }

	public ScoreBoard getScoreBoard()
	{
		return game.getScoreBoard();
	}

	public ScoreCard getScoreCard()
	{
		return game.getScoreCard();
	}

	public String getPlayerName()
	{
		return game.getPlayerName();
	}

	public int getKitty()
	{
		return game.getKitty();
	}

	public void setResponse(String response)
	{
		switch (state)
		{
		case START_GAME:
			if (getYesOrNo(response))
			{
				state = ControllerState.RULES;
			}
			else
			{
				state = ControllerState.DONE;
			}
			break;
		case RULES:
			if (getYesOrNo(response))
			{
				state = ControllerState.DISPLAY_RULES;
			}
			else
			{
				state = ControllerState.ASK_ADD_PLAYER;
			}
			break;
		case DISPLAY_RULES:
			getYesOrNo(response);
			state = ControllerState.ASK_ADD_PLAYER;
			break;
		case ASK_ADD_PLAYER:
			if (getYesOrNo(response))
			{
				state = ControllerState.ADD_PLAYER;
			}
			else
			{
				state = ControllerState.DONE;
			}
			break;
		case ADD_PLAYER:
			game.addPlayer(response);
			state = ControllerState.ADD_ANOTHER_PLAYER;
			break;
		case ADD_ANOTHER_PLAYER:
			if (getYesOrNo(response))
			{
				state = ControllerState.ADD_PLAYER;
			}
			else
			{
				state = ControllerState.NEW_ROUND;
			}
			break;
		case NEW_ROUND:
			state = ControllerState.PLAY_ROUND;
			break;
		case PLAY_ROUND:
		case TAKE_A_TURN:
			if (getYesOrNo(response))
			{
				game.takeATurn();
				// returnString = game.getPlayerRollStats();
				state = ControllerState.TAKE_A_TURN;
				if (dice.getState() != DiceState.GOOD)
				{
					game.addScorePoints();
					game.goToNextPlayer();
					if (game.getState() == GameState.GAME_OVER)
					{
						state = ControllerState.GAME_OVER;
					}
					else if (game.getState() == GameState.FINAL_ROUND)
					{
						state = ControllerState.FINAL_ROUND;
					}
					else if (game.getState() == GameState.ROUND_END)
					{
						state = ControllerState.NEW_ROUND;
					}
					else
					{
						state = ControllerState.TAKE_A_TURN;
					}
				}
			}
			else
			{
				game.addScorePoints();
				game.goToNextPlayer();
				state = ControllerState.NEXT_PLAYER;
			}
			break;
		case NEXT_PLAYER:
			if (game.getState() == GameState.GAME_OVER)
			{
				state = ControllerState.GAME_OVER;
			}
			else if (game.getState() == GameState.FINAL_ROUND)
			{
				state = ControllerState.FINAL_ROUND;
			}
			else if (game.getState() == GameState.ROUND_END)
			{
				state = ControllerState.NEW_ROUND;
			}
			else
			{
				state = ControllerState.TAKE_A_TURN;
			}
			break;
		case FINAL_ROUND:
			state = ControllerState.TAKE_FINAL_A_TURN;
			break;
		case TAKE_FINAL_A_TURN:
			if (getYesOrNo(response))
			{
				game.takeATurn();
				// returnString = game.getPlayerRollStats();
				state = ControllerState.TAKE_FINAL_A_TURN;
				if (dice.getState() != DiceState.GOOD)
				{
					game.addScorePoints();
					game.goToNextPlayer();
					if (game.getState() == GameState.GAME_OVER)
					{
						state = ControllerState.GAME_OVER;
					}
				}
			}
			else
			{
				game.addScorePoints();
				game.goToNextPlayer();
				if (game.getState() == GameState.GAME_OVER)
				{
					state = ControllerState.GAME_OVER;
				}
			}
			break;
		case GAME_OVER:
			game.giveWinnerChips();
			state = ControllerState.DONE;
			break;
		case DONE:
			break;
		default:
			break;
		}
	}

	public boolean getYesOrNo(String response)
	{
		boolean returnValue;
		if (response.equals(""))
		{
			returnValue = false;
		}
		else if (response.toLowerCase().charAt(0) == 'y')
		{
			returnValue = true;
		}
		else
		{
			returnValue = false;
		}

		return returnValue;
	}
}
