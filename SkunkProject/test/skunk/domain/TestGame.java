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
		game.addPlayer("Kathy");
		assertEquals("Kathy", game.getPlayerName());

	}
}
