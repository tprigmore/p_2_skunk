package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

/**
 * Dice represents a single pair of rollable Die objects.  Dice can
 * represent real dice randomly generating sums of their two values.  
 * Or use predictable die behavior.
 * 
 * This creates a singleton pattern.
 * 
 * This is a Javadoc comment: add more to your finished class below
 * 
 * @author scott
 *
 */

public class Dice
{
	// Instance fields (variables) may be declared anywhere in class body
	// Convention: put at top

//	private static Dice dice = new Dice() ;
	private static Dice dice ;	
	private DiceState state;
	private int lastRoll;
	private Die die1;
	private Die die2;

	// Constructors (object initializers) also can be declared anywhere
	// Convention: after instance fields/variables

	private Dice()
	{
	}

	public static Dice getInstance()
	{
		if (null == dice) {
			dice = new Dice();
		}
		return dice;
	}

	public void setupDie(Die die1, Die die2) 
	{
		// initialize instance variables die1 and die2 
		dice.die1 = die1;
		dice.die2 = die2;
		dice.roll();
	}

	// Instance methods can also be declared anywhere in body of class
	// One convention: after the constructors

	public int getLastRoll()
	{
		return this.lastRoll;
	}

	public void roll()
	{
		// Roll each of die1, die2, sum their last rolls,
		// then set Dice.lastRoll to this value

		die1.roll();
		die2.roll();
		int value1 = die1.getLastRoll();
		int value2 = die2.getLastRoll();
		this.lastRoll = value1 + value2;
		if (this.lastRoll == 2)
		{
			this.state = DiceState.DOUBLE_SKUNK;
		}
		else if (this.lastRoll == 3)
		{
			this.state = DiceState.SKUNK_DEUCE;
		}
		else if ((value1 == 1) || (value2 == 1))
		{
			this.state = DiceState.SKUNK;
		}
		else
		{
			this.state = DiceState.GOOD;
		}
	}

	public DiceState getState()
	{
		return this.state;
	}

	// the following method converts the internals of
	// this Dice object, and returns a descriptive String:
	//
	// Roll of 7 => 4 + 3
	//
	public String toString()
	{
		return "Dice with last roll: " + getLastRoll() + " => " + die1.getLastRoll() + " + " + die2.getLastRoll();
	}

}
