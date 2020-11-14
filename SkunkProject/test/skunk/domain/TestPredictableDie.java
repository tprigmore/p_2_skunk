package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPredictableDie {

	@Test
	public void test_predictable_die_123() {
		Die die = new PredictableDie();
		assertEquals(1, die.getLastRoll());
	}

}
