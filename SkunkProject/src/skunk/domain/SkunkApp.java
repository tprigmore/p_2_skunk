package skunk.domain;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkApp
{

	public static void main(String[] args)
	{
		Controller controller = new Controller();

		Dice dice = Dice.getInstance();
		Die die1 = new RandomDie();
		Die die2 = new RandomDie();
		dice.setupDie(die1, die2);
		
		while (controller.getState() != ControllerState.GAME_OVER && controller.getState() != ControllerState.DONE)
		{
			StdOut.println(controller.getMessage());
			StdOut.println(controller.setResponse(StdIn.readLine()));
		}
		if (controller.getState() == ControllerState.DONE) {
			StdOut.println(controller.getMessage());
		}
		else {
			StdOut.println(controller.getMessage());
			StdOut.println(controller.setResponse("y"));
			StdOut.println(controller.getFinalScore());
		}
	}
}
