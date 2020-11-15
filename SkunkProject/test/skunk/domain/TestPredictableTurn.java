package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPredictableTurn {

	@Test
	void test_predictable_turn_constructor() {
		Die die1 = new PredictableDie(new int[] {1,2,1,3});
		Die die2 = new PredictableDie(new int[] {1,1,3,4});
		Dice dice = new Dice(die1, die2);

		Turn turn = new Turn(dice);
		assertEquals(DiceState.DOUBLE_SKUNK, turn.getDiceState());
	}

}
