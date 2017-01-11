package bowlingscore;
import java.util.Arrays;

public class Game {
	private static final int GAME_FRAMES = 10;
	private static final int FRAME_THROW_COUNT = 2;
	private static final int TEN_FRAME_THROW_COUNT = 3;
	private static final int TEN_FRAME_THROW_TOTAL_COUNT = (GAME_FRAMES - 1) * FRAME_THROW_COUNT;
	
	private Frame frame;
	
	public Game(int[] fallenPins) {
		Frame frame = new TenFrame(Arrays.copyOfRange(fallenPins,
				TEN_FRAME_THROW_TOTAL_COUNT, TEN_FRAME_THROW_TOTAL_COUNT + TEN_FRAME_THROW_COUNT + 1));
		
		for (int i = GAME_FRAMES - 1; i > 0; i--) {
			frame = new Frame(Arrays.copyOfRange(fallenPins,
					(i - 1) * FRAME_THROW_COUNT, i * FRAME_THROW_COUNT), frame);
		}
		
		this.frame = frame;
	}
	
	public int[] score() {
		int[] score = new int[GAME_FRAMES];
		int totalScore = 0;

		for (int i = 0; i < score.length && frame != null; i++) {
			totalScore += frame.score();
			score[i] = totalScore;
			frame = frame.next();
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
