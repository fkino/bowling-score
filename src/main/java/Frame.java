
public class Frame {
	private Throw firstThrow;
	private Frame nextFrame;
	
	private boolean isSpare() {
		if ((firstThrow.fallenPins() < 10)
				&& (firstThrow.fallenPins() + firstThrow.nextThrow().fallenPins() == 10)) {
			return true;
		}
		return false;
	}

	private boolean isStrike() {
		if (firstThrow.fallenPins() == 10) {
			return true;
		}
		return false;
	}
	
	public Frame(int[] fallenPins, Frame nextFrame) {
		Throw nextFrameThrow = null;
		if (nextFrame != null) {
			nextFrameThrow = nextFrame.firstThrow;
		}
		Throw secondThrow = new Throw(fallenPins[1], nextFrameThrow);
		firstThrow = new Throw(fallenPins[0], secondThrow);
		this.nextFrame = nextFrame;
	}

	public int score() {
		if (isSpare()) {
			return 10 + firstThrow.nextThrow().nextThrow().fallenPins();
		} else if (isStrike()) {
			return 10 + nextFrame.score();
		}
		return firstThrow.fallenPins() + firstThrow.nextThrow().fallenPins();
	}
}
