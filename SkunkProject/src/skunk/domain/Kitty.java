package skunk.domain;

public class Kitty
{
	private static Kitty kitty = new Kitty() ;
	private int chips;

	private Kitty()
	{
	}
	
	public static Kitty getInstance() // overloaded constructor
	{
		kitty.setKitty(0);
		return kitty;
	}

	public void setKitty(int chips)
	{
		this.chips = chips;
	}

	public int getKitty()
	{
		return this.chips;
	}

}
