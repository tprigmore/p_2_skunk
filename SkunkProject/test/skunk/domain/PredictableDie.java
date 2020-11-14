package skunk.domain;

public class PredictableDie implements Die {
	
	private int lastRoll ;
	
	public PredictableDie()
	{
		this.lastRoll = 1;
	}
	
	@Override
	public int getLastRoll() {
		return this.lastRoll;
		
	}
}
