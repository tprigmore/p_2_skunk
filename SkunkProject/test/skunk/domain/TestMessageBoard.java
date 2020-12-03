package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMessageBoard
{

	@Test
	void test_message_board_constructor()
	{
		MessageBoard mb = new MessageBoard();
		assertEquals("Do you want to play skunk? (y/n) ", mb.getMessage(ControllerState.START_GAME));
	}

	@Test
	void test_message_board_state_messages()
	{
		MessageBoard mb = new MessageBoard();
		assertEquals("Do you want to play skunk? (y/n) ", mb.getMessage(ControllerState.START_GAME));
	       assertEquals("Do you want to see the rules? (y/n) ", mb.getMessage(ControllerState.RULES)); 
	       assertEquals("\nThe game "  , mb.getMessage(ControllerState.DISPLAY_RULES).subSequence(0, 10)); 
	       assertEquals("Do you want to add a player? (y/n) " , mb.getMessage(ControllerState.ASK_ADD_PLAYER)); 
	       assertEquals("Enter player's name: ", mb.getMessage(ControllerState.ADD_PLAYER));
	       assertEquals("Add another player? (y/n) ", mb.getMessage(ControllerState.ADD_ANOTHER_PLAYER));
	       assertEquals("------------ Next Round ---------------------------", mb.getMessage(ControllerState.NEW_ROUND));
	       assertEquals("'s turn.  Want to roll? (y/n) ", mb.getMessage(ControllerState.PLAY_ROUND));
	       assertEquals("'s turn.  Want to roll? (y/n) ", mb.getMessage(ControllerState.TAKE_A_TURN));
	       assertEquals("\n", mb.getMessage(ControllerState.NEXT_PLAYER));
	       assertEquals("------------ Final Round ---------------------------\n", mb.getMessage(ControllerState.FINAL_ROUND));
	       assertEquals("'s turn.  Want to roll? (y/n) ", mb.getMessage(ControllerState.TAKE_FINAL_A_TURN));
	       assertEquals("GAME OVER", mb.getMessage(ControllerState.GAME_OVER));
	       assertEquals("BYE", mb.getMessage(ControllerState.DONE));
	}
}
