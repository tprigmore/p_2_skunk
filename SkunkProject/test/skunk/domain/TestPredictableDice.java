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

	@Test
	void test_predictable_dice_246() {
		Die die1 = new PredictableDie(new int[] {1,2,3});
		Die die2 = new PredictableDie(new int[] {1,2,3});
		Dice dice = new Dice(die1, die2);
		dice.roll();
		assertEquals(2, dice.getLastRoll());
	}

}
