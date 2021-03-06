package bowlingscore;

public class TenFrame extends Frame {

	public TenFrame(int[] fallenPins) {
		if (isStrike(fallenPins[FIRST]) || isSpare(fallenPins[FIRST], fallenPins[SECOND])) {
			Throw thirdThrow = new Throw(fallenPins[THIRD], null);
			Throw secondThrow = new Throw(fallenPins[SECOND], thirdThrow);
			firstThrow = new Throw(fallenPins[FIRST], secondThrow);
		} else {
			Throw secondThrow = new Throw(fallenPins[SECOND], null);
			firstThrow = new Throw(fallenPins[FIRST], secondThrow);
		}
		
		this.nextFrame = null;
	}
	
	public String toString() {
		int thirdFallenPins = 0;
		if (isStrike() || isSpare()) {
			thirdFallenPins = firstThrow.nextThrow().nextThrow().fallenPins();
		}
		return firstThrow.fallenPins()
				+ ", " + firstThrow.nextThrow().fallenPins()
				+ ", " + thirdFallenPins;
	}
	
}
