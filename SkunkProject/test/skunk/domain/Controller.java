package skunk.domain;

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

	public String getMessage(ControllerState state)
	{
		String returnString;

		switch (state)
		{
		case START_GAME:
			returnString = "Do you want to play skunk? (y/n) ";
			break;
		case RULES:
			returnString = "Do you want to see the rules? (y/n) ";
			break;
		case DISPLAY_RULES:
			returnString = "Short rules.\nDo you want to add a player? (y/n) ";
			break;
		case ADD_PLAYER:
			returnString = "Enter player's name: ";
			break;
		case ADD_ANOTHER_PLAYER:
			returnString = "Add another player? (y/n) ";
			break;
		case PLAY_ROUND:
			returnString = "------------ Next Round ---------------------------\n" + getGame().getPlayerName()
					+ "'s turn.  Want to roll? (y/n) ";
			break;
		case TAKE_A_TURN:
			returnString = getGame().getPlayerName() + "'s turn.  Want to roll? (y/n) ";
			;
			break;

		default:
			returnString = "No message";
			break;
		}
		return returnString;
	}

	public void setResponse(String response)
	{
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
			getGame().addPlayer(response);
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
		case TAKE_A_TURN:
			if (response.toLowerCase().charAt(0) == 'y')
			{
				game.takeATurn();
				if (dice.getState() != DiceState.GOOD)
				{
					game.goToNextPlayer();
				}
			}
			else
			{
				game.goToNextPlayer();
			}
			state = ControllerState.TAKE_A_TURN;
			break;
		default:
			break;
		}
	}

	public Game getGame()
	{
		return game;
	}

	public void setGame(Game game)
	{
		this.game = game;
	}

}
