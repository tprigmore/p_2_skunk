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
		case FINAL_ROUND:
			returnString = "------------ Final Round ---------------------------\n" + getGame().getPlayerName()
					+ "'s turn.  Want to roll? (y/n) ";
			break;
		case GAME_OVER:
			returnString = "GAME OVER";
			break;
		case DONE:
			returnString = "BYE";
			break;
		default:
			returnString = "No message?????????????";
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
		case FINAL_ROUND:
		case TAKE_A_TURN:
			if (response.toLowerCase().charAt(0) == 'y')
			{
				game.takeATurn();
				state = ControllerState.TAKE_A_TURN;
				if (dice.getState() != DiceState.GOOD)
				{
					goToNextPlayersTurn();					
				}
			}
			else
			{
				goToNextPlayersTurn();
			}
			
			break;
		case GAME_OVER:
			Player player = this.game.findWinner();
			//StdOut.println("the winner is" + player.getName());
			int chips = game.getKitty();
			//StdOut.println("Give " + chips + " to player.");
			player.setChips(player.getChips() + chips);
			game.setKitty(0);
			state = ControllerState.DONE;
			break;
		case DONE:
			break;
		default:
			break;
		}
	}

	private void goToNextPlayersTurn()
	{
		game.addScorePoints();
		game.goToNextPlayer();
		if (game.getState() == GameState.GAME_OVER) {
			state = ControllerState.GAME_OVER;
		}
		else if (game.getState() == GameState.FINAL_ROUND) {
			state = ControllerState.FINAL_ROUND;
		}
		else if (game.getState() == GameState.ROUND_END) {
			state = ControllerState.PLAY_ROUND;
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

	public String getPlayerResults()
	{
		String returnString ;
		String skunkString;
		switch(this.dice.getState()) {
		case GOOD:
			skunkString = String.valueOf(this.dice.getLastRoll());
			break;
		case DOUBLE_SKUNK:
			skunkString = "Double Skunk";
			break;
		case SKUNK_DEUCE:
			skunkString = "Skunk Deuce";
			break;
		case SKUNK:
			skunkString = "Skunk";
			break;
		default:
			skunkString = " ";
			break;
		}
		returnString = game.getPlayerName() + " rolled a " + 
				skunkString + ". Turn point = " + game.getPlayerTurnPoints() +
				". Game points = " + game.getPlayerGamePoints() +
				". Chips " + game.getPlayerChips();
		return returnString;
		
	}

}
