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
		controller.setResponse("y");
		assertEquals("Do you want to see the rules? (y/n) ", controller.getMessage(controller.getState()));
		controller.setResponse("y");
		assertEquals("Short rules.\nDo you want to add a player? (y/n) ", controller.getMessage(controller.getState()));
		controller.setResponse("y");
		assertEquals("Enter player's name: ", controller.getMessage(controller.getState()));
		controller.setResponse("Scott");
		assertEquals("Add another player? (y/n) ", controller.getMessage(controller.getState()));
		
//		assertEquals("Enter player's name: ", controller.getMessage(ControllerState.ADD_PLAYER));
//		assertEquals("Add another player? (y/n) ", controller.getMessage(ControllerState.ADD_ANOTHER_PLAYER));
//		assertEquals("Do you want to see the rules? (y/n) ", controller.getMessage(ControllerState.RULES));
	}
}
