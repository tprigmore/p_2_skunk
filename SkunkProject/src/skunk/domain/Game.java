package skunk.domain;

public class Game
{
	private GameState state;
	
	public Game() {
		setState(GameState.IDLE);
	}

	public GameState getState()
	{
		return state;
	}

	public void setState(GameState state)
	{
		this.state = state;
	}

}
