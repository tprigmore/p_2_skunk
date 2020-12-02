package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestScoreCard
{

	@Test
	void test_test_score_constructor()
	{
		ScoreCard sc = new ScoreCard();
		sc.setPlayerName("Scott");
		assertEquals("Scott", sc.getPlayerName());
	}

	@Test
	void test_test_score_set_get_chips()
	{
		ScoreCard sc = new ScoreCard();
		sc.setChips(10);
		assertEquals(10, sc.getChips());
	}
	
	@Test
	void test_test_score_set_get_turn_points()
	{
		ScoreCard sc = new ScoreCard();
		sc.setTurnPoints(15);
		assertEquals(15, sc.getTurnPoints());
	}
	
	@Test
	void test_test_score_set_get_game_points()
	{
		ScoreCard sc = new ScoreCard();
		sc.setGamePoints(25);
		assertEquals(25, sc.getGamePoints());
	}
	
	@Test
	void test_test_score_set_get_last_roll()
	{
		ScoreCard sc = new ScoreCard();
		sc.setLastRoll(2);
		assertEquals(2, sc.getLastRoll());
	}
	
	@Test
	void test_test_score_set_get_dice_state()
	{
		ScoreCard sc = new ScoreCard();
		sc.setDiceState(DiceState.GOOD);
		assertEquals(DiceState.GOOD, sc.getDiceState());
	}
}
