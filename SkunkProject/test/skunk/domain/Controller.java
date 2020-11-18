package skunk.domain;

public class Controller
{
	private ControllerState state;

	public Controller() {
		this.state = ControllerState.START_GAME;
	}

	public Object getState()
	{
		return this.state;
	}

	public String getMessage(ControllerState state)
	{
		String returnString;
		
		switch (state) {
        case START_GAME:  returnString = "Do you want to play skunk? (y/n) ";
                 break;
        default: returnString = "Error state";
                 break;
    }
		return null;
	}

}
