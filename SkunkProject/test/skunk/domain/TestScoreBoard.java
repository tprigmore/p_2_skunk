package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestScoreBoard
{

	@Test
	void test_score_board_constructor()
	{
		ScoreBoard scoreBoard = new ScoreBoard();
		ScoreCard scoreCard1 = new ScoreCard();
		ScoreCard scoreCard2 = new ScoreCard();
		scoreCard1.setPlayerName("Scott");
		scoreCard2.setPlayerName("Joe");
		scoreBoard.addScoreCard(scoreCard1);
		scoreBoard.addScoreCard(scoreCard2);
		assertEquals("Scott", scoreBoard.getScoreCard(0).getPlayerName());
		assertEquals("Joe", scoreBoard.getScoreCard(1).getPlayerName());
	}

}
