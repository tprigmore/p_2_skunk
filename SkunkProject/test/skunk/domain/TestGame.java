package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestGame
{

	@Test
	void test_game_constructor()
	{
		Game game = new Game();
		assertEquals(GameState.IDLE, game.getState());
	}

	@Test
	void test_game_adding_players()
	{
		Game game = new Game();
		game.addPlayer("Scott");
		assertEquals("Scott", game.getPlayerName());
		assertEquals(0, game.getPlayerIndex());
		game.addPlayer("Kathy");
		game.setPlayerIndex(1);
		assertEquals(1, game.getPlayerIndex());
		assertEquals("Kathy", game.getPlayerName());
		game.addPlayer("Joe");
		game.setPlayerIndex(2);
		assertEquals(2, game.getPlayerIndex());
		assertEquals("Joe", game.getPlayerName());
		game.setPlayerIndex(0);
		assertEquals(0, game.getPlayerIndex());
		assertEquals("Scott", game.getPlayerName());
	}

	@Test
	void test_game_player_count()
	{
		Game game = new Game();
		assertEquals(0, game.getPlayerCount());
		game.addPlayer("Scott");
		assertEquals(1, game.getPlayerCount());
		game.addPlayer("Kathy");
		assertEquals(2, game.getPlayerCount());
		game.addPlayer("Joe");
		assertEquals(3, game.getPlayerCount());
	}
	
	@Test
	void test_game_kitty()
	{
		Game game = new Game();
		game.setKitty(0);
		assertEquals(0, game.getKitty());
		game.setKitty(20);
		assertEquals(20, game.getKitty());
		game.setKitty(0);
		assertEquals(0, game.getKitty());
		game.setKitty(10);
		assertEquals(10, game.getKitty());
	}
	
	@Test
	void test_game_take_a_turn()
	{
		Die die1 = new PredictableDie(new int[]{ 1, 2, 3 });
		Die die2 = new PredictableDie(new int[]{ 1, 2, 3 });
		Dice dice = Dice.getInstance();
		dice.setupDie(die1, die2);
		Game game = new Game();
		game.addPlayer("Scott");
		game.takeATurn();
		assertEquals(4, game.getPlayerTurnPoints());
		game.takeATurn();
		assertEquals(10, game.getPlayerTurnPoints());
		game.takeATurn();
		assertEquals(0, game.getPlayerTurnPoints());
	}
	
	@Test
	void test_game_go_to_next_player()
	{
		Die die1 = new PredictableDie(new int[]{ 1, 2, 3, 4, 5, 6, 1, 2 });
		Die die2 = new PredictableDie(new int[]{ 1, 2, 3, 4, 5, 6, 4, 1 });
		Dice dice = Dice.getInstance();
		dice.setupDie(die1, die2);
		Game game = new Game();
		game.addPlayer("Scott");
		game.addPlayer("Joe");
		game.addPlayer("Pete");
		game.takeATurn();
		assertEquals(4, game.getPlayerTurnPoints());
		game.takeATurn();
		assertEquals(10, game.getPlayerTurnPoints());
		game.goToNextPlayer();
		game.takeATurn();
		assertEquals(8, game.getPlayerTurnPoints());
		game.takeATurn();
		assertEquals(18, game.getPlayerTurnPoints());
		game.goToNextPlayer();
		game.takeATurn();
		assertEquals(12, game.getPlayerTurnPoints());
		game.takeATurn();
		assertEquals(0, game.getPlayerTurnPoints());
		game.goToNextPlayer();
		game.takeATurn();
		assertEquals(0, game.getPlayerTurnPoints());
		game.goToNextPlayer();
		game.takeATurn();
		assertEquals(0, game.getPlayerTurnPoints());
	}
	
	@Test
	void test_game_test_scoring()
	{
		Die die1 = new PredictableDie(new int[]{ 1, 2, 3, 4, 5, 6, 1, 2 });
		Die die2 = new PredictableDie(new int[]{ 1, 2, 3, 4, 5, 6, 4, 1 });
		Dice dice = Dice.getInstance();
		dice.setupDie(die1, die2);
		Game game = new Game();
		game.addPlayer("Scott");
		game.addPlayer("Joe");
		game.addPlayer("Pete");
		assertEquals(0, game.getPlayerTurnPoints());
		assertEquals(50,game.getPlayerChips());
		game.takeATurn();
		assertEquals(4, game.getPlayerTurnPoints());
		game.takeATurn();
		assertEquals(10, game.getPlayerTurnPoints());
		assertEquals(0, game.getPlayerGamePoints());
		game.addScorePoints();
		assertEquals(10, game.getPlayerGamePoints());
		assertEquals(50,game.getPlayerChips());
		
		game.goToNextPlayer();
		assertEquals(50,game.getPlayerChips());
		assertEquals(0, game.getPlayerTurnPoints());
		assertEquals(0, game.getPlayerGamePoints());
		game.takeATurn();
		assertEquals(8, game.getPlayerTurnPoints());
		game.takeATurn();
		assertEquals(18, game.getPlayerTurnPoints());
		assertEquals(0, game.getPlayerGamePoints());
		game.addScorePoints();
		assertEquals(18, game.getPlayerGamePoints());
		assertEquals(50,game.getPlayerChips());

		game.goToNextPlayer();
		assertEquals(50,game.getPlayerChips());
		assertEquals(0, game.getPlayerTurnPoints());
		assertEquals(0, game.getPlayerGamePoints());
		game.takeATurn();
		assertEquals(12, game.getPlayerTurnPoints());
		game.takeATurn();
		assertEquals(0, game.getPlayerTurnPoints());
		assertEquals(0, game.getPlayerGamePoints());
		game.addScorePoints();
		assertEquals(0, game.getPlayerGamePoints());
		assertEquals(49,game.getPlayerChips());

		game.goToNextPlayer();
		assertEquals(0, game.getPlayerTurnPoints());
		assertEquals(10, game.getPlayerGamePoints());
		game.takeATurn();
		assertEquals(0, game.getPlayerTurnPoints());
		assertEquals(10, game.getPlayerGamePoints());
		game.addScorePoints();
		assertEquals(10, game.getPlayerGamePoints());
		assertEquals(48,game.getPlayerChips());
		
		game.goToNextPlayer();
		assertEquals(0, game.getPlayerTurnPoints());
		assertEquals(18, game.getPlayerGamePoints());
		game.takeATurn();
		assertEquals(0, game.getPlayerTurnPoints());
		assertEquals(0, game.getPlayerGamePoints());
		game.addScorePoints();
		assertEquals(0, game.getPlayerGamePoints());
		assertEquals(46,game.getPlayerChips());
	}
	@Test
	void test_game_test_winner()
	{
		Die die1 = new PredictableDie(new int[]{ 1, 6, 6, 6, 6, 6, 1, 6, 6, 6, 6, 6 });
		Die die2 = new PredictableDie(new int[]{ 1, 6, 6, 6, 6, 6, 4, 6, 6, 6, 6, 6 });
		Dice dice = Dice.getInstance();
		dice.setupDie(die1, die2);
		Game game = new Game();
		game.addPlayer("Scott");
		game.addPlayer("Joe");
		assertEquals(0, game.getPlayerTurnPoints());
		assertEquals(50,game.getPlayerChips());
		game.takeATurn();
		game.takeATurn();
		game.takeATurn();
		game.takeATurn();
		game.takeATurn();
		assertEquals("Scott", game.getPlayerName());
		assertEquals(60, game.getPlayerTurnPoints());
		assertEquals(0, game.getPlayerGamePoints());
		game.addScorePoints();
		assertEquals(0, game.getPlayerTurnPoints());
		assertEquals(60, game.getPlayerGamePoints());

		game.goToNextPlayer();
		
		game.takeATurn();
		assertEquals("Joe", game.getPlayerName());
		assertEquals(0, game.getPlayerTurnPoints());
		assertEquals(0, game.getPlayerGamePoints());

		game.goToNextPlayer();
		
		game.takeATurn();
		game.takeATurn();
		game.takeATurn();
		game.takeATurn();
		game.takeATurn();
		assertEquals("Scott", game.getPlayerName());
		assertEquals(60, game.getPlayerTurnPoints());
		assertEquals(60, game.getPlayerGamePoints());
		game.addScorePoints();
		assertEquals(0, game.getPlayerTurnPoints());
		assertEquals(120, game.getPlayerGamePoints());

		game.goToNextPlayer();

		game.takeATurn();
		assertEquals("Joe", game.getPlayerName());
		assertEquals(0, game.getPlayerTurnPoints());
		assertEquals(0, game.getPlayerGamePoints());
		
	
		assertEquals(0, game.findWinner());
		game.giveWinnerChips();
		assertEquals(45, game.getPlayerChips());

		ScoreBoard  sb = game.getScoreBoard();
		ScoreCard sc1 = sb.getScoreCard(0);
		assertEquals("Scott",sc1.getPlayerName());
		
		
	}
}
