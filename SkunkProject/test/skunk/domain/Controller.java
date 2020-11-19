package skunk.domain;

public class Controller
{
	private ControllerState state;
	private Game game;

	public Controller()
	{
		this.state = ControllerState.START_GAME;
		this.game = new Game();
	}

	public ControllerState getState()
	{
		return this.state;
	}

	public String getMessage(ControllerState state)
	{
		String returnString;

		switch (state)
		{
		case START_GAME:
			returnString = "Do you want to play skunk? (y/n) ";
			break;
		case RULES:
			returnString = "Do you want to see the rules? (y/n) ";
			break;
		case DISPLAY_RULES:
			returnString = "Short rules.\nDo you want to add a player? (y/n) ";
			break;
		case ADD_PLAYER:
			returnString = "Enter player's name: ";
			break;
		case ADD_ANOTHER_PLAYER:
			returnString = "Add another player? (y/n) ";
			break;
		default:
			returnString = "No message";
			break;
		}
		return returnString;
	}
	
	public void setResponse(String response)
	{
		switch (state)
		{
		case START_GAME:
			if (response.toLowerCase().charAt(0) == 'y') {
				state = ControllerState.RULES;
			}
			else {
				state = ControllerState.DONE;
			}
			break;
		case RULES:
			if (response.toLowerCase().charAt(0) == 'y') {
				state = ControllerState.DISPLAY_RULES;
			}
			else {
				state = ControllerState.ADD_PLAYER;
			}
			break;
//		case RULES:
//			returnString = "Do you want to see the rules? (y/n) ";
//			break;
//		case ADD_PLAYER:
//			returnString = "Enter player's name: ";
//			break;
//		case ADD_ANOTHER_PLAYER:
//			returnString = "Add another player? (y/n) ";
//			break;
		default:
			break;
		}
	}

}
