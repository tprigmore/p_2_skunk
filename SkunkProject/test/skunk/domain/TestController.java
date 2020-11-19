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
	
	@Test
	void test_controller_getMessage()
	{
		Controller controller = new Controller();
		assertEquals("Do you want to play skunk? (y/n) ", controller.getMessage(ControllerState.START_GAME));
		assertEquals("Do you want to see the rules? (y/n) ", controller.getMessage(ControllerState.RULES));
		assertEquals("Enter player's name: ", controller.getMessage(ControllerState.ADD_PLAYER));
		assertEquals("Add another player? (y/n) ", controller.getMessage(ControllerState.ADD_ANOTHER_PLAYER));
		assertEquals("Do you want to see the rules? (y/n) ", controller.getMessage(ControllerState.RULES));
	}
	
	@Test
	void test_controller_game_setup()
	{
		Controller controller = new Controller();
		assertEquals("Do you want to play skunk? (y/n) ", controller.getMessage(controller.getState()));
		assertEquals(ControllerState.START_GAME,controller.getState());
		controller.setResponse("y");
		assertEquals("Do you want to see the rules? (y/n) ", controller.getMessage(controller.getState()));
		assertEquals(ControllerState.RULES,controller.getState());
		controller.setResponse("y");
		assertEquals("Short rules.\nDo you want to add a player? (y/n) ", controller.getMessage(controller.getState()));
		assertEquals(ControllerState.DISPLAY_RULES,controller.getState());
		controller.setResponse("y");
		assertEquals("Enter player's name: ", controller.getMessage(controller.getState()));
		assertEquals(ControllerState.ADD_PLAYER,controller.getState());
		controller.setResponse("Scott");
		assertEquals("Add another player? (y/n) ", controller.getMessage(controller.getState()));
		assertEquals(ControllerState.ADD_ANOTHER_PLAYER,controller.getState());
		controller.setResponse("n");
		assertEquals(ControllerState.PLAY_ROUND,controller.getState());
		assertEquals("------------ Next Round ---------------------------\n" +
				controller.getGame().getPlayerName() + "'s turn.  Want to roll? (y/n) ", controller.getMessage(controller.getState()));

//		assertEquals("Enter player's name: ", controller.getMessage(ControllerState.ADD_PLAYER));
//		assertEquals("Add another player? (y/n) ", controller.getMessage(ControllerState.ADD_ANOTHER_PLAYER));
//		assertEquals("Do you want to see the rules? (y/n) ", controller.getMessage(ControllerState.RULES));
	}
	
	@Test
	void test_controller_game_setup_and_play()
	{
		Die die1 = new PredictableDie(new int[]{ 1, 2, 3, 4, 5, 6, 1, 2 });
		Die die2 = new PredictableDie(new int[]{ 1, 2, 3, 4, 5, 6, 4, 1 });
		Dice dice = Dice.getInstance();
		dice.setupDie(die1, die2);

		Controller controller = new Controller();
		
		assertEquals("Do you want to play skunk? (y/n) ", controller.getMessage(controller.getState()));
		assertEquals(ControllerState.START_GAME,controller.getState());
		controller.setResponse("y");
		assertEquals("Do you want to see the rules? (y/n) ", controller.getMessage(controller.getState()));
		assertEquals(ControllerState.RULES,controller.getState());
		controller.setResponse("y");
		assertEquals("Short rules.\nDo you want to add a player? (y/n) ", controller.getMessage(controller.getState()));
		assertEquals(ControllerState.DISPLAY_RULES,controller.getState());
		controller.setResponse("y");
		assertEquals("Enter player's name: ", controller.getMessage(controller.getState()));
		assertEquals(ControllerState.ADD_PLAYER,controller.getState());
		controller.setResponse("Scott");
		assertEquals("Add another player? (y/n) ", controller.getMessage(controller.getState()));
		assertEquals(ControllerState.ADD_ANOTHER_PLAYER,controller.getState());
		controller.setResponse("y");
		assertEquals("Enter player's name: ", controller.getMessage(controller.getState()));
		assertEquals(ControllerState.ADD_PLAYER,controller.getState());
		controller.setResponse("Pete");
		assertEquals("Add another player? (y/n) ", controller.getMessage(controller.getState()));
		assertEquals(ControllerState.ADD_ANOTHER_PLAYER,controller.getState());
		controller.setResponse("n");
		assertEquals(ControllerState.PLAY_ROUND,controller.getState());
		assertEquals("------------ Next Round ---------------------------\n" +
				"Scott's turn.  Want to roll? (y/n) ", controller.getMessage(controller.getState()));
		controller.setResponse("y");
		assertEquals(ControllerState.NEXT_PLAYER,controller.getState());
		assertEquals("Pete's turn.  Want to roll? (y/n) ", controller.getMessage(controller.getState()));
	}
}
