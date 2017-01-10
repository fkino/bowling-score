
public class Frame {
	int[] fallenPins = new int[2];
	
	public Frame(int[] fallenPins) {
		this.fallenPins[0] = fallenPins[0];
		this.fallenPins[1] = fallenPins[1];
	}

	public int score() {
		return fallenPins[0] + fallenPins[1];
	}


}
