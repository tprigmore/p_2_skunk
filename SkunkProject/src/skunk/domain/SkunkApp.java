package skunk.domain;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkApp
{

	public static void main(String[] args)
	{
		Controller controller = new Controller();
		String response;
		Dice dice = Dice.getInstance();

		Die die1 = new DieReal();
		Die die2 = new DieReal();
		dice.setupDie(die1, die2);

		while (controller.getState() != ControllerState.GAME_OVER)
		{
			StdOut.println(controller.getMessage());
			response = StdIn.readLine();
			controller.setResponse(response);
			StdOut.println(controller.getPlayerResults());
		}
	}
}
