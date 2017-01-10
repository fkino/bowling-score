import java.util.Arrays;

public class Game {
	private Frame frame;
	
	public Game(int[] fallenPins) {
		Frame frame = new TenFrame(Arrays.copyOfRange(fallenPins, 18, 22));
		
		for (int i = 8; i >= 0; i--) {
			frame = new Frame(Arrays.copyOfRange(fallenPins, i * 2, i * 2 + 2), frame);
		}
		
		this.frame = frame;
	}
	
	public String toString() {
		String fallenPins = "";
		
		while (true) {
			fallenPins += frame.toString();
			frame = frame.next();
			if (frame == null) {
				break;
			}
			fallenPins += ", ";
		}
		
		return fallenPins;
	}

	public int[] score() {
		int[] score = new int[10];
		int prevFrameScore = 0;

		for (int i = 0; i < score.length; i++) {
			score[i] = frame.score() + prevFrameScore;
			frame = frame.next();
			if (frame == null) {
				break;
			}
			prevFrameScore = score[i];
		}
		
		return score;
	}

}
