package skunk.domain;

public class Controller
{
	private ControllerState state;

	public Controller() {
		this.state = ControllerState.SETUP;
	}

	public Object getState()
	{
		return this.state;
	}

}
