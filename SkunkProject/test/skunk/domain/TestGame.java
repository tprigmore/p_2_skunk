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
		assertEquals(0,game.getPlayerCount());
//		game.addPlayer("Scott");
//		assertEquals("Scott", game.getPlayerName());
//		assertEquals(0, game.getPlayerIndex());
//		game.addPlayer("Kathy");
//		game.setPlayerIndex(1);
//		assertEquals(1, game.getPlayerIndex());
//		assertEquals("Kathy", game.getPlayerName());
//		game.addPlayer("Joe");
//		game.setPlayerIndex(2);
//		assertEquals(2, game.getPlayerIndex());
//		assertEquals("Joe", game.getPlayerName());
//		game.setPlayerIndex(0);
//		assertEquals(0, game.getPlayerIndex());
//		assertEquals("Scott", game.getPlayerName());
	}
}
