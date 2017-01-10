
public class TenFrame extends Frame {

	public TenFrame(int[] fallenPins) {
		if (isStrike(fallenPins[0]) || isSpare(fallenPins[0], fallenPins[1])) {
			Throw thirdThrow = new Throw(fallenPins[2], null);
			Throw secondThrow = new Throw(fallenPins[1], thirdThrow);
			firstThrow = new Throw(fallenPins[0], secondThrow);
		} else {
			Throw secondThrow = new Throw(fallenPins[1], null);
			firstThrow = new Throw(fallenPins[0], secondThrow);
		}
		this.nextFrame = null;
	}
	
}
