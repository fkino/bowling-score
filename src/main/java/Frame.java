
public class Frame {
	private int[] fallenPins = new int[2];
	Frame nextFrame;
	
	private boolean isSpare() {
		if (fallenPins[0] + fallenPins[1] == 10) {
			return true;
		}
		return false;
	}

	private boolean isStrike() {
		if (fallenPins[0] == 10) {
			return true;
		}
		return false;
	}
	
	public Frame(int[] fallenPins, Frame nextFrame) {
		this.fallenPins[0] = fallenPins[0];
		this.fallenPins[1] = fallenPins[1];
		this.nextFrame = nextFrame;
	}

	public int score() {
		if (isSpare()) {
//			return 10 + nextThrow.fallenPins();
		} else if (isStrike()) {
			return 10 + nextFrame.score();
		}
		return fallenPins[0] + fallenPins[1];
	}
}
