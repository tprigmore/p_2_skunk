package skunk.domain;

public class PredictableDie implements Die
{
	// The follow variables are used for predictable behavior
	private int[] theRolls;
	private int index;

	// Saves the last roll
	private int lastRoll;

	public PredictableDie()
	{
		this.lastRoll = 1;
	}

	public PredictableDie(int[] is)
	{
		this.theRolls = is;
		this.index = 0;
		this.lastRoll = theRolls[index];
	}

	@Override
	public void roll()
	{
		this.lastRoll = this.theRolls[this.index];
		this.index++;
		if (this.index == this.theRolls.length)
		{
			this.index = 0;
		}
	}

	@Override
	public int getLastRoll()
	{
		return this.lastRoll;
	}
}
