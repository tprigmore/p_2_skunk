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
			returnString = "------------ Next Round ---------------------------\n" + game.getAllPlayerStats()
					+ game.getPlayerName() + "'s turn.  Want to roll? (y/n) ";
			break;
		case TAKE_A_TURN:
			returnString = game.getPlayerName() + "'s turn.  Want to roll? (y/n) ";
			;
			break;
		case FINAL_ROUND:
			returnString = "------------ Final Round ---------------------------\n" + game.getAllPlayerStats()
					+ game.getPlayerName() + "'s turn.  Want to roll? (y/n) ";
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
				returnString = getRules();
				state = ControllerState.DISPLAY_RULES;
			}
			else
			{
				state = ControllerState.ADD_PLAYER;
			}
			break;
		case DISPLAY_RULES:
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
				state = ControllerState.PLAY_ROUND;
			}
			break;
		case PLAY_ROUND:
		case FINAL_ROUND:
		case TAKE_A_TURN:
			if (getYesOrNo(response))
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
				// returnString = game.getPlayerRollStats();
				goToNextPlayersTurn();
			}
			break;
		case GAME_OVER:
			Player player = this.game.findWinner();
			int chips = game.getKitty();
			player.setChips(player.getChips() + chips);
			game.setKitty(0);
			// returnString = game.getPlayerRollStats();
			state = ControllerState.DONE;
			break;
		case DONE:
			break;
		default:
			break;
		}
		return returnString;
	}

	private boolean getYesOrNo(String response)
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
		String returnString = "\n---------------------------------------------------------\n" + "The winner is "
				+ game.findWinner().getName() + "!!!!\n";
		returnString = returnString + game.getAllPlayerStats();
		return returnString;
	}

	public String getRules()
	{
		String rules = "\nThe game of Skunk was created by named W.H. Schaper back in 1953\n"
				+ "To win a game of Skunk you need to be the first player to score \n" + "100 points or more.\n\n"
				+ "A Skunk player scores points by rolling both dice at once and adding\n"
				+ "the total of the two.  For example, if a three and a five are rolled,\n"
				+ "that Skunk player would have earned 8 points.\n"
				+ "A player can choose to stop at the end of any roll and keep their \n"
				+ "accumulated game points or try to roll again for even more points.\n"
				+ "A Player accumulates turn points until the decide to pass or get skunked.\n"
				+ "If a player passes, the accumulated turn points become game points. Game\n"
				+ "points are safe unless the player rolls a double skunk.\n\n"
				+ "If a player rolls a skunk (a single one) the rollers turn is immediately\n"
				+ "over and the players accumulated turn points are lost, and must put a \n" + "chip in the kitty.\n\n"
				+ "Rolling a skunk - deuce (a roll of single one and a two) the rollers \n"
				+ "turn is immediately over and their accumulated turn points are lost,\n"
				+ " and they must put two chips in the kitty.\n\n"
				+ "If a player rolls a double skunk (double ones), their turn is over, \n"
				+ "they lose all the points for that turn, AND they lose any game points \n"
				+ "they might have and need to start accumulating points all over again.\n"
				+ "They must also put 4 chips in the kitty\n\n"
				+ "When a player reaches 100 points or more on their turn, they have two \n"
				+ "options.  They can keep rolling to raise the needed winning number for\n"
				+ "other players, or they can stop.\n"
				+ "When the first player to reach or exceed 100 points stops, all the other\n"
				+ "players get another chance to roll, giving them a chance to win the game.\n"
				+ "The winning player gets all the kitty points.\n";

		return rules;
	}
}
