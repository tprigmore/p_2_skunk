package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestController
{

	@Test
	void test_controller_constructor()
	{
		Controller controller = new Controller();
		assertEquals(ControllerState.START_GAME, controller.getState());
	}
	
//	@Test
//	void test_controller_getMessage()
//	{
//		Controller controller = new Controller();
//		assertEquals("Do you want to play skunk? (y/n) ", controller.getMessage(ControllerState.START_GAME));
//		assertEquals("Do you want to see the rules? (y/n) ", controller.getMessage(ControllerState.RULES));
//		assertEquals("Enter player's name: ", controller.getMessage(ControllerState.ADD_PLAYER));
//		assertEquals("Add another player? (y/n) ", controller.getMessage(ControllerState.ADD_ANOTHER_PLAYER));
//		assertEquals("Do you want to see the rules? (y/n) ", controller.getMessage(ControllerState.RULES));
//	}
	
	@Test
	void test_controller_game_setup()
	{
		Controller controller = new Controller();
		assertEquals("Do you want to play skunk? (y/n) ", controller.getMessage());
		assertEquals(ControllerState.START_GAME,controller.getState());
		controller.setResponse("y");
		assertEquals("Do you want to see the rules? (y/n) ", controller.getMessage());
		assertEquals(ControllerState.RULES,controller.getState());
		controller.setResponse("y");
		assertEquals("Do you want to add a player? (y/n) ", controller.getMessage());
		assertEquals(ControllerState.DISPLAY_RULES,controller.getState());
		controller.setResponse("y");
		assertEquals("Enter player's name: ", controller.getMessage());
		assertEquals(ControllerState.ADD_PLAYER,controller.getState());
		controller.setResponse("Scott");
		assertEquals("Add another player? (y/n) ", controller.getMessage());
		assertEquals(ControllerState.ADD_ANOTHER_PLAYER,controller.getState());
		controller.setResponse("n");
		assertEquals(ControllerState.PLAY_ROUND,controller.getState());
		assertEquals("------------ Next Round ---------------------------\n" +
				controller.getGame().getPlayerName() + "'s turn.  Want to roll? (y/n) ", controller.getMessage());

//		assertEquals("Enter player's name: ", controller.getMessage(ControllerState.ADD_PLAYER));
//		assertEquals("Add another player? (y/n) ", controller.getMessage(ControllerState.ADD_ANOTHER_PLAYER));
//		assertEquals("Do you want to see the rules? (y/n) ", controller.getMessage(ControllerState.RULES));
	}
	
	@Test
	void test_controller_game_setup_and_play()
	{
		Die die1 = new PredictableDie(new int[]{ 1, 6, 6, 6, 5, 3, 1, 6, 6, 6, 3, 2, 6, 6, 6, 4});
		Die die2 = new PredictableDie(new int[]{ 1, 6, 6, 6, 5, 3, 4, 6, 6, 6, 3, 1, 6, 6, 6, 4});
		Dice dice = Dice.getInstance();
		dice.setupDie(die1, die2);
		
		Kitty kitty = Kitty.getInstance();
		kitty.setKitty(0);

		Controller controller = new Controller();
		
		assertEquals("Do you want to play skunk? (y/n) ", controller.getMessage());
		assertEquals(ControllerState.START_GAME,controller.getState());
		controller.setResponse("y");
		assertEquals("Do you want to see the rules? (y/n) ", controller.getMessage());
		assertEquals(ControllerState.RULES,controller.getState());
		controller.setResponse("y");
		assertEquals("Do you want to add a player? (y/n) ", controller.getMessage());
		assertEquals(ControllerState.DISPLAY_RULES,controller.getState());
		controller.setResponse("y");
		assertEquals("Enter player's name: ", controller.getMessage());
		assertEquals(ControllerState.ADD_PLAYER,controller.getState());
		controller.setResponse("Scott");
		assertEquals("Add another player? (y/n) ", controller.getMessage());
		assertEquals(ControllerState.ADD_ANOTHER_PLAYER,controller.getState());
		controller.setResponse("y");
		assertEquals("Enter player's name: ", controller.getMessage());
		assertEquals(ControllerState.ADD_PLAYER,controller.getState());
		controller.setResponse("Pete");
		assertEquals("Add another player? (y/n) ", controller.getMessage());
		assertEquals(ControllerState.ADD_ANOTHER_PLAYER,controller.getState());
		controller.setResponse("n");
		assertEquals(ControllerState.PLAY_ROUND,controller.getState());
		assertEquals("------------ Next Round ---------------------------\n" +
				"Scott's turn.  Want to roll? (y/n) ", controller.getMessage());
		controller.setResponse("y");
		
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Scott's turn.  Want to roll? (y/n) ", controller.getMessage());
		assertEquals(50,controller.getGame().getPlayerChips());
		assertEquals(12,controller.getGame().getPlayerTurnPoints());
		assertEquals(0,controller.getGame().getPlayerGamePoints());
		assertEquals(0,controller.getGame().getKitty());
		controller.setResponse("y");
		
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Scott's turn.  Want to roll? (y/n) ", controller.getMessage());
		assertEquals(50,controller.getGame().getPlayerChips());
		assertEquals(24,controller.getGame().getPlayerTurnPoints());
		assertEquals(0,controller.getGame().getPlayerGamePoints());
		assertEquals(0,controller.getGame().getKitty());
		controller.setResponse("y");
		
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Scott's turn.  Want to roll? (y/n) ", controller.getMessage());
		assertEquals(50,controller.getGame().getPlayerChips());
		assertEquals(36,controller.getGame().getPlayerTurnPoints());
		assertEquals(0,controller.getGame().getPlayerGamePoints());
		assertEquals(0,controller.getGame().getKitty());
		controller.setResponse("n");
		
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Pete's turn.  Want to roll? (y/n) ", controller.getMessage());
		assertEquals(50,controller.getGame().getPlayerChips());
		assertEquals(0,controller.getGame().getPlayerTurnPoints());
		assertEquals(0,controller.getGame().getPlayerGamePoints());
		assertEquals(0,controller.getGame().getKitty());
		controller.setResponse("y");
		
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Pete's turn.  Want to roll? (y/n) ", controller.getMessage());
		assertEquals(50,controller.getGame().getPlayerChips());
		assertEquals(10,controller.getGame().getPlayerTurnPoints());
		assertEquals(0,controller.getGame().getPlayerGamePoints());
		assertEquals(0,controller.getGame().getKitty());
		controller.setResponse("y");

		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Pete's turn.  Want to roll? (y/n) ", controller.getMessage());
		assertEquals(50,controller.getGame().getPlayerChips());
		assertEquals(16,controller.getGame().getPlayerTurnPoints());
		assertEquals(0,controller.getGame().getPlayerGamePoints());
		assertEquals(0,controller.getGame().getKitty());
		controller.setResponse("y");

		assertEquals(ControllerState.PLAY_ROUND,controller.getState());
		assertEquals("------------ Next Round ---------------------------\n" +
				"Scott's turn.  Want to roll? (y/n) ", controller.getMessage());
		assertEquals(50,controller.getGame().getPlayerChips());
		assertEquals(0,controller.getGame().getPlayerTurnPoints());
		assertEquals(36,controller.getGame().getPlayerGamePoints());
		assertEquals(1,controller.getGame().getKitty());
		controller.setResponse("y");
		
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Scott's turn.  Want to roll? (y/n) ", controller.getMessage());
		assertEquals(50,controller.getGame().getPlayerChips());
		assertEquals(12,controller.getGame().getPlayerTurnPoints());
		assertEquals(36,controller.getGame().getPlayerGamePoints());
		assertEquals(1,controller.getGame().getKitty());
		controller.setResponse("y");

		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Scott's turn.  Want to roll? (y/n) ", controller.getMessage());
		assertEquals(50,controller.getGame().getPlayerChips());
		assertEquals(24,controller.getGame().getPlayerTurnPoints());
		assertEquals(36,controller.getGame().getPlayerGamePoints());
		assertEquals(1,controller.getGame().getKitty());
		controller.setResponse("y");

		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Scott's turn.  Want to roll? (y/n) ", controller.getMessage());
		assertEquals(50,controller.getGame().getPlayerChips());
		assertEquals(36,controller.getGame().getPlayerTurnPoints());
		assertEquals(36,controller.getGame().getPlayerGamePoints());
		assertEquals(1,controller.getGame().getKitty());
		controller.setResponse("n");

		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Pete's turn.  Want to roll? (y/n) ", controller.getMessage());
		assertEquals(49,controller.getGame().getPlayerChips());
		assertEquals(0,controller.getGame().getPlayerTurnPoints());
		assertEquals(0,controller.getGame().getPlayerGamePoints());
		assertEquals(1,controller.getGame().getKitty());
		controller.setResponse("y");

		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Pete's turn.  Want to roll? (y/n) ", controller.getMessage());
		assertEquals(49,controller.getGame().getPlayerChips());
		assertEquals(6,controller.getGame().getPlayerTurnPoints());
		assertEquals(0,controller.getGame().getPlayerGamePoints());
		assertEquals(1,controller.getGame().getKitty());
		controller.setResponse("y");
		
		assertEquals(ControllerState.PLAY_ROUND,controller.getState());
		assertEquals("------------ Next Round ---------------------------\n" +
				"Scott's turn.  Want to roll? (y/n) ", controller.getMessage());
		assertEquals(50,controller.getGame().getPlayerChips());
		assertEquals(0,controller.getGame().getPlayerTurnPoints());
		assertEquals(72,controller.getGame().getPlayerGamePoints());
		assertEquals(3,controller.getGame().getKitty());
		controller.setResponse("y");

		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Scott's turn.  Want to roll? (y/n) ", controller.getMessage());
		assertEquals(50,controller.getGame().getPlayerChips());
		assertEquals(12,controller.getGame().getPlayerTurnPoints());
		assertEquals(72,controller.getGame().getPlayerGamePoints());
		assertEquals(3,controller.getGame().getKitty());
		controller.setResponse("y");
		
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Scott's turn.  Want to roll? (y/n) ", controller.getMessage());
		assertEquals(50,controller.getGame().getPlayerChips());
		assertEquals(24,controller.getGame().getPlayerTurnPoints());
		assertEquals(72,controller.getGame().getPlayerGamePoints());
		assertEquals(3,controller.getGame().getKitty());
		controller.setResponse("y");
		
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Scott's turn.  Want to roll? (y/n) ", controller.getMessage());
		assertEquals(50,controller.getGame().getPlayerChips());
		assertEquals(36,controller.getGame().getPlayerTurnPoints());
		assertEquals(72,controller.getGame().getPlayerGamePoints());
		assertEquals(3,controller.getGame().getKitty());
		controller.setResponse("n");

		assertEquals(ControllerState.FINAL_ROUND,controller.getState());
		assertEquals("------------ Final Round ---------------------------\n" +
				"Pete's turn.  Want to roll? (y/n) ", controller.getMessage());
		assertEquals(47,controller.getGame().getPlayerChips());
		assertEquals(0,controller.getGame().getPlayerTurnPoints());
		assertEquals(0,controller.getGame().getPlayerGamePoints());
		assertEquals(3,controller.getGame().getKitty());
		controller.setResponse("y");

		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Pete's turn.  Want to roll? (y/n) ", controller.getMessage());
		assertEquals(47,controller.getGame().getPlayerChips());
		assertEquals(8,controller.getGame().getPlayerTurnPoints());
		assertEquals(0,controller.getGame().getPlayerGamePoints());
		assertEquals(3,controller.getGame().getKitty());
		controller.setResponse("y");

		assertEquals(ControllerState.GAME_OVER,controller.getState());
		assertEquals("GAME OVER", controller.getMessage());
		
		controller.setResponse("y");
		assertEquals(57,controller.getGame().getPlayerChips());
		assertEquals(0,controller.getGame().getPlayerTurnPoints());
		assertEquals(108,controller.getGame().getPlayerGamePoints());
		assertEquals(0,controller.getGame().getKitty());

		controller.getGame().setPlayerIndex(1);
		assertEquals(43,controller.getGame().getPlayerChips());
		assertEquals(0,controller.getGame().getPlayerTurnPoints());
		assertEquals(0,controller.getGame().getPlayerGamePoints());
		assertEquals(0,controller.getGame().getKitty());
	}
	
	@Test
	void test_controller_game_display_results()
	{
		Die die1 = new PredictableDie(new int[]{ 1, 6, 6, 6, 5, 3, 1, 6, 6, 6, 3, 2, 6, 6, 6, 4});
		Die die2 = new PredictableDie(new int[]{ 1, 6, 6, 6, 5, 3, 4, 6, 6, 6, 3, 1, 6, 6, 6, 4});
		Dice dice = Dice.getInstance();
		dice.setupDie(die1, die2);
		
		Kitty kitty = Kitty.getInstance();
		kitty.setKitty(0);

		Controller controller = new Controller();
		
		assertEquals("Do you want to play skunk? (y/n) ", controller.getMessage());
		assertEquals(ControllerState.START_GAME,controller.getState());
		controller.setResponse("y");
		assertEquals("Do you want to see the rules? (y/n) ", controller.getMessage());
		assertEquals(ControllerState.RULES,controller.getState());
		controller.setResponse("y");
		assertEquals("Do you want to add a player? (y/n) ", controller.getMessage());
		assertEquals(ControllerState.DISPLAY_RULES,controller.getState());
		controller.setResponse("y");
		assertEquals("Enter player's name: ", controller.getMessage());
		assertEquals(ControllerState.ADD_PLAYER,controller.getState());
		controller.setResponse("Scott");
		assertEquals("Add another player? (y/n) ", controller.getMessage());
		assertEquals(ControllerState.ADD_ANOTHER_PLAYER,controller.getState());
		controller.setResponse("y");
		assertEquals("Enter player's name: ", controller.getMessage());
		assertEquals(ControllerState.ADD_PLAYER,controller.getState());
		controller.setResponse("Pete");
		assertEquals("Add another player? (y/n) ", controller.getMessage());
		assertEquals(ControllerState.ADD_ANOTHER_PLAYER,controller.getState());
		controller.setResponse("n");
		assertEquals(ControllerState.PLAY_ROUND,controller.getState());
		assertEquals("------------ Next Round ---------------------------\n" +
				"Scott's turn.  Want to roll? (y/n) ", controller.getMessage());
		controller.setResponse("y");
		
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Scott's turn.  Want to roll? (y/n) ", controller.getMessage());
		assertEquals(50,controller.getGame().getPlayerChips());
		assertEquals(12,controller.getGame().getPlayerTurnPoints());
		assertEquals(0,controller.getGame().getPlayerGamePoints());
		assertEquals(0,controller.getGame().getKitty());
		controller.setResponse("y");
		
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Scott's turn.  Want to roll? (y/n) ", controller.getMessage());
		assertEquals(50,controller.getGame().getPlayerChips());
		assertEquals(24,controller.getGame().getPlayerTurnPoints());
		assertEquals(0,controller.getGame().getPlayerGamePoints());
		assertEquals(0,controller.getGame().getKitty());
		controller.setResponse("y");
		
		assertEquals("Scott rolled a 12. Turn points = 36. Game points = 0. Chips = 50\n", controller.getPlayerResults());
	}
		

}
