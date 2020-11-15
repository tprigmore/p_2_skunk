package skunk.domain;

public class Kitty {

	private int chips;
	
	public Kitty() {
		setKitty(50);
	}
	
	private void setKitty(int chips) {
		this.chips = chips;
	}

	public int getKitty() {
		return this.chips;
	}

}
