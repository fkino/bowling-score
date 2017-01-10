
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
		if (isSpare()) {
			return ALL_PINS + firstThrow.nextThrow().nextThrow().fallenPins();
		} else if (isStrike()) {
			return ALL_PINS + firstThrow.nextThrow().fallenPins() + firstThrow.nextThrow().nextThrow().fallenPins();
		}
		return firstThrow.fallenPins() + firstThrow.nextThrow().fallenPins();
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

	private boolean isSpare() {
		return isSpare(firstThrow.fallenPins(), firstThrow.nextThrow().fallenPins());
	}


	private boolean isStrike() {
		return isStrike(firstThrow.fallenPins());
	}

}
