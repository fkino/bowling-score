
public class TenFrame extends Frame {

	public TenFrame(int[] fallenPins) {
		if ((fallenPins[0] == 10) || (fallenPins[0] + fallenPins[1]) == 10) {
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
