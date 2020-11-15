package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPredictableTurn {

	@Test
	void test_predictable_turn_constructor() {
		Die die1 = new PredictableDie(new int[] {1,2,1,3});
		Die die2 = new PredictableDie(new int[] {1,1,3,4});
		Dice dice = new Dice(die1, die2);
		Kitty kitty = new Kitty();
		Player player = new Player();

		Turn turn = new Turn(dice, kitty, player);
		assertEquals(DiceState.DOUBLE_SKUNK, turn.getState());
	}
	
	@Test
	void test_predictable_turn_state() {
		Die die1 = new PredictableDie(new int[] {1,2,1,3});
		Die die2 = new PredictableDie(new int[] {1,1,3,4});
		Dice dice = new Dice(die1, die2);
		Kitty kitty = new Kitty();
		Player player = new Player();

		Turn turn = new Turn(dice, kitty, player);
		turn.takeATurn();
		assertEquals(DiceState.DOUBLE_SKUNK, turn.getState());
		turn.takeATurn();
		assertEquals(DiceState.SKUNK_DEUCE, turn.getState());

	}
}
