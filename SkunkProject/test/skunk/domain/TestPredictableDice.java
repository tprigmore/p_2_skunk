package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPredictableDice {

	@Test
	void test_predictable_dice_constructor() {
		Die die1 = new PredictableDie();
		Die die2 = new PredictableDie();
		Dice dice = new Dice(die1, die2);

		assertEquals(2, dice.getLastRoll());
	}

}
