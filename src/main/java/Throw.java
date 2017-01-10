
public class Throw {
	private int fallenPins;
	private Throw nextThrow;

	public Throw(int fallenPins, Throw nextThrow) {
		this.fallenPins = fallenPins;
		this.nextThrow = nextThrow;
	}

	public int fallenPins() {
		return fallenPins;
	}
	
	

}
