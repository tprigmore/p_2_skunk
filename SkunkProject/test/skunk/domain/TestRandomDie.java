package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRandomDie
{

	@Test
	public void test_die_constructor()
	{
		boolean flag = false;
		Die die = new RandomDie();
		int lastRoll = die.getLastRoll();
		if (lastRoll >= 2 && lastRoll <=12)
			flag = true;
		
		assertTrue(flag);
	}

}
