package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRandomDie
{

	@Test
	public void test_die_constructor()
	{
		boolean result = false;
		Die die = new RandomDie();
		int lastRoll = die.getLastRoll();
		if (lastRoll >= 2 && lastRoll <=6)
			result = true;
		
		assertTrue(result);
	}

	@Test
	public void to_string()
	{
		boolean result = false;
		Die die = new RandomDie();
		String string = die.toString();
		if (string.equals("Die: 1") || string.equals("Die: 2") || string.equals("Die: 3") ||  string.equals("Die: 4") || string.equals("Die: 5") || string.equals("Die: 6"))
			result = true ;
		assertTrue(result);
	}
	
	@Test
	public void test_die_for_1()
	{
		boolean result = false;
		for (int i = 0; i < 100; i++)
		{
			Die die = new RandomDie();
			die.roll();
			int value = die.getLastRoll();
			if (value == 1)
			{
				result = true;
				break;
			}
		}
		assertFalse(result);
	}
	
}
