package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

public class Controller
{
	private ControllerState state;
	private Game game;
	private Dice dice = Dice.getInstance();

	public Controller()
	{
		this.state = ControllerState.START_GAME;
		this.setGame(new Game());
	}

	public ControllerState getState()
	{
		return this.state;
	}

	public Game getGame()
	{
		return game;
	}

	public void setGame(Game game)
	{
		this.game = game;
	}

	public String getMessage()
	{
		String returnString;

		switch (this.state)
		{
		case START_GAME:
			returnString = "Do you want to play skunk? (y/n) ";
			break;
		case RULES:
			returnString = "Do you want to see the rules? (y/n) ";
			break;
		case DISPLAY_RULES:
			returnString = "Do you want to add a player? (y/n) ";
			break;
		case ADD_PLAYER:
			returnString = "Enter player's name: ";
			break;
		case ADD_ANOTHER_PLAYER:
			returnString = "Add another player? (y/n) ";
			break;
		case PLAY_ROUND:
			returnString = "------------ Next Round ---------------------------\n" + 
					game.getAllPlayerStats() + game.getPlayerName() +
					"'s turn.  Want to roll? (y/n) ";
			break;
		case TAKE_A_TURN:
			returnString = game.getPlayerName() + "'s turn.  Want to roll? (y/n) ";
			;
			break;
		case FINAL_ROUND:
			returnString = "------------ Final Round ---------------------------\n" + 
					game.getAllPlayerStats() + game.getPlayerName()
					+ "'s turn.  Want to roll? (y/n) ";
			break;
		case GAME_OVER:
			returnString = "GAME OVER";
			break;
		case DONE:
			returnString = "BYE";
			break;
		default:
			returnString = "????????????No message?????????????";
			break;
		}
		return returnString;
	}

	public String setResponse(String response)
	{
		String returnString = "";

		switch (state)
		{
		case START_GAME:
			if (response.toLowerCase().charAt(0) == 'y')
			{
				state = ControllerState.RULES;
			}
			else
			{
				state = ControllerState.DONE;
			}
			break;
		case RULES:
			if (response.toLowerCase().charAt(0) == 'y')
			{
				returnString = "Short rules...\n";
				state = ControllerState.DISPLAY_RULES;
			}
			else
			{
				state = ControllerState.ADD_PLAYER;
			}
			break;
		case DISPLAY_RULES:
			if (response.toLowerCase().charAt(0) == 'y')
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
			if (response.toLowerCase().charAt(0) == 'y')
			{
				state = ControllerState.ADD_PLAYER;
			}
			else
			{
				state = ControllerState.PLAY_ROUND;
			}
			break;
		case PLAY_ROUND:
		case FINAL_ROUND:
		case TAKE_A_TURN:
			if (response.toLowerCase().charAt(0) == 'y')
			{
				game.takeATurn();
				returnString = game.getPlayerRollStats();
				state = ControllerState.TAKE_A_TURN;
				if (dice.getState() != DiceState.GOOD)
				{
					goToNextPlayersTurn();
				}
			}
			else
			{
//				returnString = game.getPlayerRollStats();
				goToNextPlayersTurn();
			}
			break;
		case GAME_OVER:
			Player player = this.game.findWinner();
			int chips = game.getKitty();
			player.setChips(player.getChips() + chips);
			game.setKitty(0);
//			returnString = game.getPlayerRollStats();
			state = ControllerState.DONE;
			break;
		case DONE:
			break;
		default:
			break;
		}
		return returnString;
	}

	private void goToNextPlayersTurn()
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
			state = ControllerState.PLAY_ROUND;
		}
	}

	public String getFinalScore()
	{
		String returnString = "\n---------------------------------------------------------\n" + "The winnder is "
				+ game.findWinner().getName() + "!!!!\n";
		returnString = returnString + game.getAllPlayerStats();
		return returnString;
	}
}
