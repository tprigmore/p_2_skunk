package skunk.domain;

import java.util.HashMap;

public class MessageBoard
{
	private HashMap<ControllerState, String> map = new HashMap<>();

	public MessageBoard()
	{
		map.put(ControllerState.START_GAME, "Do you want to play skunk? (y/n) ");
		map.put(ControllerState.RULES, "Do you want to see the rules? (y/n) ");
		map.put(ControllerState.DISPLAY_RULES, getRules());
		map.put(ControllerState.ASK_ADD_PLAYER, "Do you want to add a player? (y/n) ");
		map.put(ControllerState.ADD_PLAYER, "Enter player's name: ");
		map.put(ControllerState.ADD_ANOTHER_PLAYER, "Add another player? (y/n) ");
		map.put(ControllerState.NEW_ROUND, "------------ Next Round ---------------------------");
		map.put(ControllerState.PLAY_ROUND, "'s turn.  Want to roll? (y/n) ");
		map.put(ControllerState.TAKE_A_TURN, "'s turn.  Want to roll? (y/n) ");
		map.put(ControllerState.NEXT_PLAYER, "\n");
		map.put(ControllerState.FINAL_ROUND, "------------ Final Round ---------------------------\n");
		map.put(ControllerState.TAKE_FINAL_A_TURN, "'s turn.  Want to roll? (y/n) ");
		map.put(ControllerState.GAME_OVER, "GAME OVER");
		map.put(ControllerState.DONE, "BYE");
	}
	// Add elements to the map

	public String getMessage(ControllerState state)
	{

		return map.get(state);
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
				+ "The winning player gets all the kitty points.\n" + "\nPress any ket to continue...\n";

		return rules;
	}
}
