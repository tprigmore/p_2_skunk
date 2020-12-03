package skunk.domain;

import java.util.ArrayList;

public class ScoreBoard
{
	private ArrayList<ScoreCard> scoreCardArray = new ArrayList<ScoreCard>();
	private int numberOfScoreCards;

	public ScoreBoard()
	{
		this.setNumberOfScoreCards(0);
	}

	public void addScoreCard(ScoreCard scoreCard)
	{
		this.scoreCardArray.add(scoreCard);
		this.setNumberOfScoreCards(this.getNumberOfScoreCards() + 1);
	}

	public ScoreCard getScoreCard(int index)
	{
		return this.scoreCardArray.get(index);
	}

	public int getNumberOfScoreCards()
	{
		return numberOfScoreCards;
	}

	private void setNumberOfScoreCards(int numberOfScoreCards)
	{
		this.numberOfScoreCards = numberOfScoreCards;
	}

}
