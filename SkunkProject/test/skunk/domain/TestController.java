package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestController
{

	@Test
	void test_controller_constructor()
	{
		Controller controller = new Controller();
		assertEquals(ControllerState.SETUP, controller.getState());
	}

}
