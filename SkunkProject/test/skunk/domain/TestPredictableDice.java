package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPredictableDice
{

	@Test
	void test_predictable_dice_constructor()
	{
		Die die1 = new PredictableDie(new int[]{ 1});
		Die die2 = new PredictableDie(new int[]{ 1});
		Dice dice = Dice.getInstance(die1, die2);

		assertEquals(2, dice.getLastRoll());
	}

	@Test
	void test_predictable_dice_246()
	{
		Die die1 = new PredictableDie(new int[]{ 1, 2, 3 });
		Die die2 = new PredictableDie(new int[]{ 1, 2, 3 });
		Dice dice = Dice.getInstance(die1, die2);
		assertEquals(2, dice.getLastRoll());
		dice.roll();
		assertEquals(4, dice.getLastRoll());
		dice.roll();
		assertEquals(6, dice.getLastRoll());
	}

	@Test
	void test_predictable_dice_state()
	{
		Die die1 = new PredictableDie(new int[]{ 1, 2, 1, 3 });
		Die die2 = new PredictableDie(new int[]{ 1, 1, 3, 4 });
		Dice dice = Dice.getInstance(die1, die2);
		assertEquals(DiceState.DOUBLE_SKUNK, dice.getState());
		dice.roll();
		assertEquals(DiceState.SKUNK_DEUCE, dice.getState());
		dice.roll();
		assertEquals(DiceState.SKUNK, dice.getState());
		dice.roll();
		assertEquals(DiceState.GOOD, dice.getState());
	}

	@Test
	void test_predictable_dice_toString()
	{
		Die die1 = new PredictableDie(new int[]{ 1, 2, 1, 3 });
		Die die2 = new PredictableDie(new int[]{ 1, 1, 3, 4 });
		Dice dice = Dice.getInstance(die1, die2);
		assertEquals("Dice with last roll: 2 => 1 + 1", dice.toString());
	}

}
