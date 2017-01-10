
public class Frame {
	Throw firstThrow;
	Frame nextFrame;
		
	private boolean isSpare() {
		return isSpare(firstThrow.fallenPins(), firstThrow.nextThrow().fallenPins());
	}

	boolean isSpare(int first, int second) {
		if ((first < 10) && (first + second == 10)) {
			return true;
		}
		return false;		
	}

	private boolean isStrike() {
		return isStrike(firstThrow.fallenPins());
	}

	boolean isStrike(int first) {
		if (first == 10) {
			return true;
		}
		return false;
	}
	
	Frame() {	
	}
	
	public Frame(int[] fallenPins, Frame nextFrame) {
		Throw nextFrameThrow = null;
		if (nextFrame != null) {
			nextFrameThrow = nextFrame.firstThrow;
		}
		
		if (fallenPins[0] < 10) {
			Throw secondThrow = new Throw(fallenPins[1], nextFrameThrow);
			firstThrow = new Throw(fallenPins[0], secondThrow);
		} else {
			firstThrow = new Throw(fallenPins[0], nextFrameThrow);
		}
		this.nextFrame = nextFrame;
	}

	public int score() {
		if (isSpare()) {
			return 10 + firstThrow.nextThrow().nextThrow().fallenPins();
		} else if (isStrike()) {
			return 10 + firstThrow.nextThrow().fallenPins() + firstThrow.nextThrow().nextThrow().fallenPins();
		}
		return firstThrow.fallenPins() + firstThrow.nextThrow().fallenPins();
	}
}
