import java.util.Arrays;

public class Game {
	static private int GAME_FRAMES = 10;
	
	private Frame frame;
	
	public Game(int[] fallenPins) {
		Frame frame = new TenFrame(Arrays.copyOfRange(fallenPins, GAME_FRAMES * 2 - 2, GAME_FRAMES * 2 + 2));
		
		for (int i = GAME_FRAMES - 1; i > 0; i--) {
			frame = new Frame(Arrays.copyOfRange(fallenPins, i * 2 - 2, i * 2), frame);
		}
		
		this.frame = frame;
	}
	
	public int[] score() {
		int[] score = new int[GAME_FRAMES];
		int prevFrameScore = 0;

		for (int i = 0; i < score.length; i++) {
			score[i] = frame.score() + prevFrameScore;
			frame = frame.next();
			if (frame == null) {
				// 10フレームまでなかった場合
				// 例外にしたい
				break;
			}
			prevFrameScore = score[i];
		}
		
		return score;
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

}
