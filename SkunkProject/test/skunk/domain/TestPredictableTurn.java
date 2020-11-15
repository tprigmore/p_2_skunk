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
		turn.takeATurn();
		assertEquals(DiceState.SKUNK, turn.getState());
		turn.takeATurn();
		assertEquals(DiceState.GOOD, turn.getState());
	}
	
	@Test
	void test_predictable_turn_kitty() {
		Die die1 = new PredictableDie(new int[] {1,2,1,3});
		Die die2 = new PredictableDie(new int[] {1,1,3,4});
		Dice dice = new Dice(die1, die2);
		Kitty kitty = new Kitty();
		Player player = new Player();
		Turn turn = new Turn(dice, kitty, player);
		assertEquals(0, kitty.getKitty());
		turn.takeATurn();
		assertEquals(4, kitty.getKitty());
		turn.takeATurn();
		assertEquals(6, kitty.getKitty());
		turn.takeATurn();
		assertEquals(7, kitty.getKitty());
	}
	
	@Test
	void test_predictable_turn_player_chips() {
		Die die1 = new PredictableDie(new int[] {1,2,1,3});
		Die die2 = new PredictableDie(new int[] {1,1,3,4});
		Dice dice = new Dice(die1, die2);
		Kitty kitty = new Kitty();
		Player player = new Player();
		Turn turn = new Turn(dice, kitty, player);
		assertEquals(50, player.getChips());
		turn.takeATurn();
		assertEquals(46, player.getChips());
		turn.takeATurn();
		assertEquals(44, player.getChips());
		turn.takeATurn();
		assertEquals(43, player.getChips());
	}
	
	@Test
	void test_predictable_turn_player_game_points() {
		Die die1 = new PredictableDie(new int[] {4,1,2,1,3});
		Die die2 = new PredictableDie(new int[] {3,1,1,3,4});
		Dice dice = new Dice(die1, die2);
		Kitty kitty = new Kitty();
		Player player = new Player();
		Turn turn = new Turn(dice, kitty, player);
		assertEquals(0, player.getGamePoints());
	}
	
	@Test
	void test_predictable_turn_player_turn_points() {
		Die die1 = new PredictableDie(new int[] {4,1,2,1,3,1});
		Die die2 = new PredictableDie(new int[] {3,1,5,3,4,2});
		Dice dice = new Dice(die1, die2);
		Kitty kitty = new Kitty();
		Player player = new Player();
		Turn turn = new Turn(dice, kitty, player);
		assertEquals(0, player.getTurnPoints());
		turn.takeATurn();
		assertEquals(7, player.getTurnPoints());
//		turn.takeATurn();
//		assertEquals(0, player.getGamePoints());
	}

}
