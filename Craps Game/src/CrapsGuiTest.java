import static org.junit.Assert.*;

import org.junit.Test;

public class CrapsGuiTest {

	@Test
	public void test() {
		
		CrapsGui gui = new CrapsGui();
		
		assertEquals("one.png", gui.resolveDiceImage(0));
		assertEquals("one.png", gui.resolveDiceImage(1));
		assertEquals("two.png", gui.resolveDiceImage(2));
		assertEquals("three.png", gui.resolveDiceImage(3));
		assertEquals("four.png", gui.resolveDiceImage(4));
		assertEquals("five.png", gui.resolveDiceImage(5));
		assertEquals("six.png", gui.resolveDiceImage(6));
		assertEquals("one.png", gui.resolveDiceImage(7));



	}

}
