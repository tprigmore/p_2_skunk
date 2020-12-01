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
		assertEquals(ControllerState.START_GAME,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.RULES,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.DISPLAY_RULES,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.ASK_ADD_PLAYER,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.ADD_PLAYER,controller.getState());
		controller.setResponse("Scott");
		assertEquals(ControllerState.ADD_ANOTHER_PLAYER,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.ADD_PLAYER,controller.getState());
		controller.setResponse("Joe");
		assertEquals(ControllerState.ADD_ANOTHER_PLAYER,controller.getState());
		controller.setResponse("n");
		assertEquals(ControllerState.NEW_ROUND,controller.getState());
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
		ScoreBoard scoreBoard;
		ScoreCard scoreCard;


		Controller controller = new Controller();

		assertEquals(ControllerState.START_GAME,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.RULES,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.DISPLAY_RULES,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.ASK_ADD_PLAYER,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.ADD_PLAYER,controller.getState());
		controller.setResponse("Scott");
		assertEquals(ControllerState.ADD_ANOTHER_PLAYER,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.ADD_PLAYER,controller.getState());
		controller.setResponse("Pete");
		assertEquals(ControllerState.ADD_ANOTHER_PLAYER,controller.getState());
		controller.setResponse("n");
		assertEquals(ControllerState.NEW_ROUND,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.PLAY_ROUND,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		scoreCard  = controller.getScoreCard();
		assertEquals("Scott",scoreCard.getPlayerName());
		assertEquals(50,scoreCard.getChips());
		assertEquals(12,scoreCard.getTurnPoints());
		assertEquals(0,scoreCard.getGamePoints());
		assertEquals(0,controller.getKitty());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Scott",scoreCard.getPlayerName());
		scoreCard  = controller.getScoreCard();
		assertEquals(50,scoreCard.getChips());
		assertEquals(24,scoreCard.getTurnPoints());
		assertEquals(0,scoreCard.getGamePoints());
		assertEquals(0,controller.getKitty());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Scott",scoreCard.getPlayerName());
		scoreCard  = controller.getScoreCard();
		assertEquals(50,scoreCard.getChips());
		assertEquals(36,scoreCard.getTurnPoints());
		assertEquals(0,scoreCard.getGamePoints());
		assertEquals(0,controller.getKitty());
		controller.setResponse("n");
		assertEquals(ControllerState.NEXT_PLAYER,controller.getState());
		assertEquals("Scott",scoreCard.getPlayerName());
		scoreCard  = controller.getScoreCard();
		assertEquals(50,scoreCard.getChips());
		assertEquals(36,scoreCard.getTurnPoints());
		assertEquals(36,scoreCard.getGamePoints());
		assertEquals(0,controller.getKitty());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Scott",scoreCard.getPlayerName());
		scoreCard  = controller.getScoreCard();
		assertEquals(50,scoreCard.getChips());
		assertEquals(36,scoreCard.getTurnPoints());
		assertEquals(36,scoreCard.getGamePoints());
		assertEquals(0,controller.getKitty());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Scott",scoreCard.getPlayerName());
		scoreCard  = controller.getScoreCard();
		assertEquals(50,scoreCard.getChips());
		assertEquals(10,scoreCard.getTurnPoints());
		assertEquals(0,scoreCard.getGamePoints());
		assertEquals(0,controller.getKitty());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Pete",scoreCard.getPlayerName());
		scoreCard  = controller.getScoreCard();
		assertEquals(50,scoreCard.getChips());
		assertEquals(16,scoreCard.getTurnPoints());
		assertEquals(0,scoreCard.getGamePoints());
		assertEquals(0,controller.getKitty());
		controller.setResponse("y");
		assertEquals(ControllerState.NEW_ROUND,controller.getState());
		assertEquals("Pete",scoreCard.getPlayerName());
		scoreCard  = controller.getScoreCard();
		assertEquals(49,scoreCard.getChips());
		assertEquals(0,scoreCard.getTurnPoints());
		assertEquals(0,scoreCard.getGamePoints());
		assertEquals(1,controller.getKitty());
		controller.setResponse("y");
		assertEquals(ControllerState.PLAY_ROUND,controller.getState());
		assertEquals("Pete",scoreCard.getPlayerName());
		scoreCard  = controller.getScoreCard();
		assertEquals(49,scoreCard.getChips());
		assertEquals(0,scoreCard.getTurnPoints());
		assertEquals(0,scoreCard.getGamePoints());
		assertEquals(1,controller.getKitty());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Pete",scoreCard.getPlayerName());
		scoreCard  = controller.getScoreCard();
		assertEquals(50,scoreCard.getChips());
		assertEquals(12,scoreCard.getTurnPoints());
		assertEquals(36,scoreCard.getGamePoints());
		assertEquals(1,controller.getKitty());
		controller.setResponse("n");
		assertEquals(ControllerState.NEXT_PLAYER,controller.getState());
		assertEquals("Scott",scoreCard.getPlayerName());
		scoreCard  = controller.getScoreCard();
		assertEquals(50,scoreCard.getChips());
		assertEquals(12,scoreCard.getTurnPoints());
		assertEquals(48,scoreCard.getGamePoints());
		assertEquals(1,controller.getKitty());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Scott",scoreCard.getPlayerName());
		scoreCard  = controller.getScoreCard();
		assertEquals(50,scoreCard.getChips());
		assertEquals(12,scoreCard.getTurnPoints());
		assertEquals(48,scoreCard.getGamePoints());
		assertEquals(1,controller.getKitty());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Scott",scoreCard.getPlayerName());
		scoreCard  = controller.getScoreCard();
		assertEquals(49,scoreCard.getChips());
		assertEquals(12,scoreCard.getTurnPoints());
		assertEquals(0,scoreCard.getGamePoints());
		assertEquals(1,controller.getKitty());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Pete",scoreCard.getPlayerName());
		scoreCard  = controller.getScoreCard();
		assertEquals(49,scoreCard.getChips());
		assertEquals(24,scoreCard.getTurnPoints());
		assertEquals(0,scoreCard.getGamePoints());
		assertEquals(1,controller.getKitty());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Pete",scoreCard.getPlayerName());
		scoreCard  = controller.getScoreCard();
		assertEquals(49,scoreCard.getChips());
		assertEquals(30,scoreCard.getTurnPoints());
		assertEquals(0,scoreCard.getGamePoints());
		assertEquals(1,controller.getKitty());
		controller.setResponse("y");
		assertEquals(ControllerState.NEW_ROUND,controller.getState());
		assertEquals("Pete",scoreCard.getPlayerName());
		scoreCard  = controller.getScoreCard();
		assertEquals(47,scoreCard.getChips());
		assertEquals(0,scoreCard.getTurnPoints());
		assertEquals(0,scoreCard.getGamePoints());
		assertEquals(3,controller.getKitty());
		controller.setResponse("n");
		assertEquals(ControllerState.PLAY_ROUND,controller.getState());
		assertEquals("Pete",scoreCard.getPlayerName());
		scoreCard  = controller.getScoreCard();
		assertEquals(47,scoreCard.getChips());
		assertEquals(0,scoreCard.getTurnPoints());
		assertEquals(0,scoreCard.getGamePoints());
		assertEquals(3,controller.getKitty());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Pete",scoreCard.getPlayerName());
		scoreCard  = controller.getScoreCard();
		assertEquals(50,scoreCard.getChips());
		assertEquals(12,scoreCard.getTurnPoints());
		assertEquals(48,scoreCard.getGamePoints());
		assertEquals(3,controller.getKitty());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		assertEquals("Scott",scoreCard.getPlayerName());
		scoreCard  = controller.getScoreCard();
		assertEquals(50,scoreCard.getChips());
		assertEquals(24,scoreCard.getTurnPoints());
		assertEquals(48,scoreCard.getGamePoints());
		assertEquals(3,controller.getKitty());


	}
	
//	@Test
//	void test_controller_game_display_results()
//	{
//		Die die1 = new PredictableDie(new int[]{ 1, 6, 6, 6, 5, 3, 1, 6, 6, 6, 3, 2, 6, 6, 6, 4});
//		Die die2 = new PredictableDie(new int[]{ 1, 6, 6, 6, 5, 3, 4, 6, 6, 6, 3, 1, 6, 6, 6, 4});
//		Dice dice = Dice.getInstance();
//		dice.setupDie(die1, die2);
//		
//		Kitty kitty = Kitty.getInstance();
//		kitty.setKitty(0);
//
//		Controller controller = new Controller();
//		
//		assertEquals("Do you want to play skunk? (y/n) ", controller.getMessage());
//		assertEquals(ControllerState.START_GAME,controller.getState());
//		controller.setResponse("y");
//		assertEquals("Do you want to see the rules? (y/n) ", controller.getMessage());
//		assertEquals(ControllerState.RULES,controller.getState());
//		controller.setResponse("y");
//		assertEquals("Do you want to add a player? (y/n) ", controller.getMessage());
//		assertEquals(ControllerState.DISPLAY_RULES,controller.getState());
//		controller.setResponse("y");
//		assertEquals("Enter player's name: ", controller.getMessage());
//		assertEquals(ControllerState.ADD_PLAYER,controller.getState());
//		controller.setResponse("Scott");
//		assertEquals("Add another player? (y/n) ", controller.getMessage());
//		assertEquals(ControllerState.ADD_ANOTHER_PLAYER,controller.getState());
//		controller.setResponse("y");
//		assertEquals("Enter player's name: ", controller.getMessage());
//		assertEquals(ControllerState.ADD_PLAYER,controller.getState());
//		controller.setResponse("Pete");
//		assertEquals("Add another player? (y/n) ", controller.getMessage());
//		assertEquals(ControllerState.ADD_ANOTHER_PLAYER,controller.getState());
//		controller.setResponse("n");
//		assertEquals(ControllerState.PLAY_ROUND,controller.getState());
//		assertEquals("------------ Next Round ---------------------------\n" +
//				"Scott has 0 game points and 50 chips.\n" + 
//				"Pete has 0 game points and 50 chips.\n" +
//				"---------------------------------------------------\n" +
//				"Scott's turn.  Want to roll? (y/n) ", controller.getMessage());
//		controller.setResponse("y");
//		
//		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
//		assertEquals("Scott's turn.  Want to roll? (y/n) ", controller.getMessage());
//		assertEquals(50,controller.getGame().getPlayerChips());
//		assertEquals(12,controller.getGame().getPlayerTurnPoints());
//		assertEquals(0,controller.getGame().getPlayerGamePoints());
//		assertEquals(0,controller.getGame().getKitty());
//		controller.setResponse("y");
//		
//		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
//		assertEquals("Scott's turn.  Want to roll? (y/n) ", controller.getMessage());
//		assertEquals(50,controller.getGame().getPlayerChips());
//		assertEquals(24,controller.getGame().getPlayerTurnPoints());
//		assertEquals(0,controller.getGame().getPlayerGamePoints());
//		assertEquals(0,controller.getGame().getKitty());
//		controller.setResponse("y");
//		
//		assertEquals("Scott rolled a 12. Turn points = 36. Game points = 0. Chips = 50\n", controller.getGame().getPlayerRollStats());
//	}
		

}
