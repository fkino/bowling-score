import org.junit.Test;
import static org.junit.Assert.*;

/*
 * This Java source file was auto generated by running 'gradle init --type java-library'
 * by 'fkino' at '17/01/10 19:08' with Gradle 3.0
 *
 * @author fkino, @date 17/01/10 19:08
 */
public class FrameTest {
	@Test
	public void ストライクでもスペアでもない場合のスコアを求める() {
		int[] fallenPins = {7, 2};
		Frame frame = new Frame(fallenPins, null);
		assertEquals(9, frame.score());
	}

	@Test
	public void ストライクの場合のスコアを求める() {
		int[] fallenPins1 = {10, 0};
		int[] fallenPins2 = {7, 2};
		Frame frame2 = new Frame(fallenPins2, null);
		Frame frame1 = new Frame(fallenPins1, frame2);
		assertEquals(19, frame1.score());
	}

	@Test
	public void スペアの場合のスコアを求める() {
		int[] fallenPins1 = {7, 3};
		int[] fallenPins2 = {6, 2};
		Frame frame2 = new Frame(fallenPins2, null);
		Frame frame1 = new Frame(fallenPins1, frame2);
		assertEquals(16, frame1.score());
	}

	@Test
	public void ダブルの場合のスコアを求める() {
		int[] fallenPins1 = {10, 0};
		int[] fallenPins2 = {10, 0};
		int[] fallenPins3 = {7, 2};
		Frame frame3 = new Frame(fallenPins3, null);
		Frame frame2 = new Frame(fallenPins2, frame3);
		Frame frame1 = new Frame(fallenPins1, frame2);
		assertEquals(27, frame1.score());
	}

	@Test
	public void ターキーの場合のスコアを求める() {
		int[] fallenPins1 = {10, 0};
		int[] fallenPins2 = {10, 0};
		int[] fallenPins3 = {10, 0};
		int[] fallenPins4 = {7, 2};
		Frame frame4 = new Frame(fallenPins4, null);
		Frame frame3 = new Frame(fallenPins3, frame4);
		Frame frame2 = new Frame(fallenPins2, frame3);
		Frame frame1 = new Frame(fallenPins1, frame2);
		assertEquals(30, frame1.score());
	}

}
