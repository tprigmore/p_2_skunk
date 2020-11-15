package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestGame
{

	@Test
	void test_game_constructor()
	{
		Game game = new Game();
		
		assertEquals(GameState.PLAYING, game.getState());
	}

}
