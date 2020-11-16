package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPredictableTurn
{

	@Test
	void test_predictable_turn_constructor()
	{
		Die die1 = new PredictableDie(new int[]{ 1, 2, 1, 3 });
		Die die2 = new PredictableDie(new int[]{ 1, 1, 3, 4 });
		Dice dice = Dice.getInstance(die1, die2);
		Kitty kitty = new Kitty();
		Player player = new Player("Fred");
		Turn turn = new Turn(dice, kitty, player);
		assertEquals(DiceState.DOUBLE_SKUNK, turn.getState());
	}

	@Test
	void test_predictable_turn_state()
	{
		Die die1 = new PredictableDie(new int[]{ 1, 2, 1, 3 });
		Die die2 = new PredictableDie(new int[]{ 1, 1, 3, 4 });
		Dice dice = Dice.getInstance(die1, die2);
		Kitty kitty = new Kitty();
		Player player = new Player("Joe");
		Turn turn = new Turn(dice, kitty, player);
		assertEquals(DiceState.DOUBLE_SKUNK, turn.getState());
		turn.takeATurn();
		assertEquals(DiceState.SKUNK_DEUCE, turn.getState());
		turn.takeATurn();
		assertEquals(DiceState.SKUNK, turn.getState());
		turn.takeATurn();
		assertEquals(DiceState.GOOD, turn.getState());
	}

	@Test
	void test_predictable_turn_kitty()
	{
		Die die1 = new PredictableDie(new int[]{ 1, 2, 1, 3, 1});
		Die die2 = new PredictableDie(new int[]{ 1, 1, 3, 4, 1});
		Dice dice = Dice.getInstance(die1, die2);
		Kitty kitty = new Kitty();
		Player player = new Player("Sam");
		Turn turn = new Turn(dice, kitty, player);
		assertEquals(0, kitty.getKitty());
		turn.takeATurn();
		assertEquals(2, kitty.getKitty());
		turn.takeATurn();
		assertEquals(3, kitty.getKitty());
		turn.takeATurn();
		assertEquals(3, kitty.getKitty());
		turn.takeATurn();
		assertEquals(7, kitty.getKitty());
	}

	@Test
	void test_predictable_turn_player_chips()
	{
		Die die1 = new PredictableDie(new int[]{ 1, 2, 1, 3, 1});
		Die die2 = new PredictableDie(new int[]{ 1, 1, 3, 4, 1});
		Dice dice = Dice.getInstance(die1, die2);
		Kitty kitty = new Kitty();
		Player player = new Player("George");
		Turn turn = new Turn(dice, kitty, player);
		assertEquals(50, player.getChips());
		turn.takeATurn();
		assertEquals(48, player.getChips());
		turn.takeATurn();
		assertEquals(47, player.getChips());
		turn.takeATurn();
		assertEquals(47, player.getChips());
	}

	@Test
	void test_predictable_turn_player_game_points()
	{
		Die die1 = new PredictableDie(new int[]{ 4, 1, 2, 1, 3 });
		Die die2 = new PredictableDie(new int[]{ 3, 1, 1, 3, 4 });
		Dice dice = Dice.getInstance(die1, die2);
		Kitty kitty = new Kitty();
		Player player = new Player("Pete");
		Turn turn = new Turn(dice, kitty, player);
		assertEquals(0, player.getGamePoints());
		turn.takeATurn();
		assertEquals(0, player.getGamePoints());
	}

	@Test
	void test_predictable_turn_player_turn_points()
	{
		Die die1 = new PredictableDie(new int[]{ 4, 1, 2, 1, 3, 1 });
		Die die2 = new PredictableDie(new int[]{ 3, 1, 4, 3, 2, 2 });
		Dice dice = Dice.getInstance(die1, die2);
		Kitty kitty = new Kitty();
		Player player = new Player("Tom");
		Turn turn = new Turn(dice, kitty, player);
		assertEquals(0, player.getTurnPoints());
		turn.takeATurn();
		assertEquals(0, player.getTurnPoints());
		turn.takeATurn();
		assertEquals(6, player.getTurnPoints());
		turn.takeATurn();
		assertEquals(0, player.getTurnPoints());
		turn.takeATurn();
		assertEquals(5, player.getTurnPoints());
		turn.takeATurn();
		assertEquals(0, player.getTurnPoints());
		turn.takeATurn();
		assertEquals(7, player.getTurnPoints());
	}

	@Test
	void test_predictable_turn_takeATurn_return_value()
	{
		Die die1 = new PredictableDie(new int[]{ 4, 1, 2, 1, 3, 1, 4 });
		Die die2 = new PredictableDie(new int[]{ 3, 1, 4, 3, 2, 2, 4 });
		Dice dice = Dice.getInstance(die1, die2);
		Kitty kitty = new Kitty();
		Player player = new Player("Sue");
		Turn turn = new Turn(dice, kitty, player);
		assertEquals(0, turn.takeATurn());
		assertEquals(6, turn.takeATurn());
		assertEquals(0, turn.takeATurn());
		assertEquals(5, turn.takeATurn());
		assertEquals(0, turn.takeATurn());
		assertEquals(8, turn.takeATurn());
	}
}
