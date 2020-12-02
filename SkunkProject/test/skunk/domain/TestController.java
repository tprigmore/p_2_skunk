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
		assertEquals("Scott", controller.getPlayerName());
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
		ScoreBoard sb = controller.getScoreBoard();
		ScoreCard sc = sb.getScoreCard(0);
		assertEquals("Scott", sc.getPlayerName());
	}
	
	@Test
	void test_controller_y_or_n()
	{
		Controller controller = new Controller();
		assertEquals(true,controller.getYesOrNo("Yes"));
		assertEquals(false,controller.getYesOrNo("No"));
		assertEquals(false,controller.getYesOrNo(""));
	}
	
	@Test
	void test_controller_game_setResonse_done()
	{
		Controller controller = new Controller();
		assertEquals(ControllerState.START_GAME,controller.getState());
		controller.setResponse("n");
		assertEquals(ControllerState.DONE,controller.getState());
	}
	
	@Test
	void test_controller_game_setResonse_rules()
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
	}
	
	@Test
	void test_controller_game_setResonse_no_rules()
	{
		Controller controller = new Controller();
		assertEquals(ControllerState.START_GAME,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.RULES,controller.getState());
		controller.setResponse("n");
		assertEquals(ControllerState.ASK_ADD_PLAYER,controller.getState());
		controller.setResponse("y");
	}
	
	@Test
	void test_controller_game_setResonse_add_player()
	{
		Controller controller = new Controller();
		assertEquals(ControllerState.START_GAME,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.RULES,controller.getState());
		controller.setResponse("n");
		assertEquals(ControllerState.ASK_ADD_PLAYER,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.ADD_PLAYER,controller.getState());
		controller.setResponse("fred");
		assertEquals(ControllerState.ADD_ANOTHER_PLAYER,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.ADD_PLAYER,controller.getState());
		controller.setResponse("joe");
		assertEquals(ControllerState.ADD_ANOTHER_PLAYER,controller.getState());
		controller.setResponse("n");
		assertEquals(ControllerState.NEW_ROUND,controller.getState());
	}
	
	@Test
	void test_controller_game_setResonse_add_player_no()
	{
		Controller controller = new Controller();
		assertEquals(ControllerState.START_GAME,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.RULES,controller.getState());
		controller.setResponse("n");
		assertEquals(ControllerState.ASK_ADD_PLAYER,controller.getState());
		controller.setResponse("n");
		assertEquals(ControllerState.DONE,controller.getState());
	}
	@Test
	void test_controller_game_setup_and_play_to_finish()
	{
		Die die1 = new PredictableDie(new int[]{ 1, 6, 6, 6, 5, 3, 1, 6, 6, 6, 3, 2, 6, 6, 6, 4});
		Die die2 = new PredictableDie(new int[]{ 1, 6, 6, 6, 5, 3, 4, 6, 6, 6, 3, 1, 6, 6, 6, 4});
		Dice dice = Dice.getInstance();
		dice.setupDie(die1, die2);
		Controller controller = new Controller();

		assertEquals(ControllerState.START_GAME,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.RULES,controller.getState());
		controller.setResponse("n");
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
		// scott
		assertEquals(ControllerState.PLAY_ROUND,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		controller.setResponse("n");
		//pete
		assertEquals(ControllerState.NEXT_PLAYER,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		controller.setResponse("y");
		
		// scott
		assertEquals(ControllerState.NEW_ROUND,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.PLAY_ROUND,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		controller.setResponse("n");
		//pete
		assertEquals(ControllerState.NEXT_PLAYER,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.NEW_ROUND,controller.getState());
		controller.setResponse("y");
		//scott
		assertEquals(ControllerState.PLAY_ROUND,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.TAKE_A_TURN,controller.getState());
		controller.setResponse("n");
		assertEquals(ControllerState.NEXT_PLAYER,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.FINAL_ROUND,controller.getState());
		controller.setResponse("y");
		//pete
		assertEquals(ControllerState.TAKE_FINAL_A_TURN,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.GAME_OVER,controller.getState());
		controller.setResponse("y");
		assertEquals(ControllerState.DONE,controller.getState());
		controller.setResponse("y");
	}
}
