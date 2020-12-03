package skunk.domain;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkApp
{

	public static void main(String[] args)
	{
		Controller controller = new Controller();
		MessageBoard meassage = new MessageBoard();

		Dice dice = Dice.getInstance();
		Die die1 = new RandomDie();
		Die die2 = new RandomDie();
		dice.setupDie(die1, die2);

		// Game setup
		while (controller.getState() != ControllerState.DONE && controller.getState() != ControllerState.NEW_ROUND)
		{
			StdOut.println(meassage.getMessage(controller.getState()));
			controller.setResponse(StdIn.readLine());
		}

		// Playing Game
		while (controller.getState() != ControllerState.GAME_OVER)
		{
			// StdOut.println("state = " + controller.getState());
			if (controller.getState() == ControllerState.NEW_ROUND
					|| controller.getState() == ControllerState.FINAL_ROUND)
			{
				StdOut.println(meassage.getMessage(controller.getState()));
				showGameStats(controller);
				controller.setResponse("y");
			}
			else if (controller.getState() == ControllerState.NEXT_PLAYER)
			{
				controller.setResponse("y");
			}
			else
			{
				StdOut.print(controller.getPlayerName());
				StdOut.println(meassage.getMessage(controller.getState()));
				controller.setResponse(StdIn.readLine());
				if (controller.getState() != ControllerState.NEXT_PLAYER)
				{
					showPlayerStats(controller);
				}
			}
		}

		// End of Game
		if (controller.getState() == ControllerState.GAME_OVER)
		{
			StdOut.println(meassage.getMessage(controller.getState()));
			controller.setResponse("y");
			showGameStats(controller);
		}
	}

	// Shows all player stats
	private static void showGameStats(Controller controller)
	{
		ScoreBoard scoreBoard;
		ScoreCard scoreCard;

		scoreBoard = controller.getScoreBoard();
		for (int i = 0; i < scoreBoard.getNumberOfScoreCards(); i++)
		{
			scoreCard = scoreBoard.getScoreCard(i);
			StdOut.println(scoreCard.getPlayerName() + " has " + scoreCard.getGamePoints() + " game points, "
					+ scoreCard.getChips() + " chips.");
		}
		StdOut.println("The kitty has " + controller.getKitty() + " chip.\n");
	}

	// Shows players last turn stats
	private static void showPlayerStats(Controller controller)
	{
		ScoreCard scoreCard;
		scoreCard = controller.getScoreCard();

		StdOut.println("\n" + scoreCard.getPlayerName() + " rolled a " + scoreCard.getLastRoll() + " that was "
				+ scoreCard.getDiceState() + ".  Now has " + scoreCard.getTurnPoints() + " turn points, has "
				+ scoreCard.getGamePoints() + " game points, and has " + scoreCard.getChips() + " chips.\n");

	}

}
