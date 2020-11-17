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
		Dice dice = Dice.getInstance();
		dice.setupDie(die1, die2);

		assertEquals(2, dice.getLastRoll());
	}

	@Test
	void test_predictable_dice_246()
	{
		Die die1 = new PredictableDie(new int[]{ 1, 2, 3 });
		Die die2 = new PredictableDie(new int[]{ 1, 2, 3 });
		Dice dice = Dice.getInstance();
		dice.setupDie(die1, die2);
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
		Dice dice = Dice.getInstance();
		dice.setupDie(die1, die2);
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
		Dice dice = Dice.getInstance();
		dice.setupDie(die1, die2);
		assertEquals("Dice with last roll: 2 => 1 + 1", dice.toString());
	}
	
	@Test
	void test_predictable_dice_singleton()
	{
		Die die1 = new PredictableDie(new int[]{ 1, 2, 1, 3 });
		Die die2 = new PredictableDie(new int[]{ 1, 1, 3, 4 });
		Dice dice1 = Dice.getInstance();
		Dice dice2 = Dice.getInstance();
		dice1.setupDie(die1, die2);
		dice2.setupDie(die1, die2);
		assertEquals(3, dice1.getLastRoll());
		assertEquals(3, dice2.getLastRoll());
		dice1.roll();
		assertEquals(4, dice1.getLastRoll());
		assertEquals(4, dice2.getLastRoll());
		dice2.roll();
		assertEquals(7, dice1.getLastRoll());
		assertEquals(7, dice2.getLastRoll());
		dice2.roll();
		assertEquals(2, dice1.getLastRoll());
		assertEquals(2, dice2.getLastRoll());
	}
}
