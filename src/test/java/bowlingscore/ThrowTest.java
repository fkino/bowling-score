package bowlingscore;
import org.junit.Test;

import bowlingscore.Throw;

import static org.junit.Assert.*;

/*
 * This Java source file was auto generated by running 'gradle init --type java-library'
 * by 'fkino' at '17/01/10 19:08' with Gradle 3.0
 *
 * @author fkino, @date 17/01/10 19:08
 */
public class ThrowTest {
	@Test
	public void 倒したピンの数を返す() {
		Throw _throw = new Throw(7, null);
		assertEquals(7, _throw.fallenPins());
	}

	@Test
	public void 次の投球で倒したピンの数を返す() {
		Throw _throw2 = new Throw(7, null);
		Throw _throw1 = new Throw(2, _throw2);
		assertEquals(7, _throw1.nextThrow().fallenPins());
	}
}
