package bowlingscore;

public class Frame {
	static final int FIRST = 0;
	static final int SECOND = 1;
	static final int THIRD = 2;
	
	Throw firstThrow;
	Frame nextFrame;
	
	private static final int ALL_PINS = 10;
	
	public Frame(int[] fallenPins, Frame nextFrame) {
		Throw nextFrameThrow = null;
		if (nextFrame != null) {
			nextFrameThrow = nextFrame.firstThrow;
		} else {
			// NOOP
			// 本来はあり得ない。テスト用。
		}

		if (isStrike(fallenPins[FIRST])) {
			firstThrow = new Throw(fallenPins[FIRST], nextFrameThrow);
		} else {
			Throw secondThrow = new Throw(fallenPins[SECOND], nextFrameThrow);
			firstThrow = new Throw(fallenPins[FIRST], secondThrow);
		}

		this.nextFrame = nextFrame;
	}

	public int score() {
		int score = firstThrow.fallenPins() + firstThrow.nextThrow().fallenPins();
		if (isStrike() || isSpare()) {
			return score + firstThrow.nextThrow().nextThrow().fallenPins();
		}
		return score;
	}
	
	public String toString() {
		int secondfallenPins = 0;
		if (!isStrike()) {
			secondfallenPins = firstThrow.nextThrow().fallenPins();
		}
		return firstThrow.fallenPins() + ", " + secondfallenPins;
	}
	
	public Frame next() {
		return nextFrame;
	}


	Frame() {	
	}
	
	boolean isSpare(int first, int second) {
		if ((first < ALL_PINS) && (first + second == ALL_PINS)) {
			return true;
		}
		return false;		
	}

	boolean isStrike(int first) {
		if (first == ALL_PINS) {
			return true;
		}
		return false;
	}

	boolean isSpare() {
		return isSpare(firstThrow.fallenPins(), firstThrow.nextThrow().fallenPins());
	}

	boolean isStrike() {
		return isStrike(firstThrow.fallenPins());
	}
}
