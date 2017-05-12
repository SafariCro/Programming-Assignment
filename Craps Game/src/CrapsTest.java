import static org.junit.Assert.*;

import org.junit.Test;

public class CrapsTest {

	@Test
	public void test() {
		
		Craps craps = new Craps();
		
		craps.setSumOfRolls(1);
		assertEquals("Draw", craps.gameResult());
		
		craps.setSumOfRolls(2);
		assertEquals("Lose", craps.gameResult());
		
		craps.setSumOfRolls(3);
		assertEquals("Lose", craps.gameResult());
		
		craps.setSumOfRolls(4);
		assertEquals("Draw", craps.gameResult());
		
		craps.setSumOfRolls(5);
		assertEquals("Draw", craps.gameResult());
		
		craps.setSumOfRolls(6);
		assertEquals("Draw", craps.gameResult());
		
		craps.setSumOfRolls(7);
		assertEquals("Win", craps.gameResult());
		
		craps.setSumOfRolls(8);
		assertEquals("Draw", craps.gameResult());
		
		craps.setSumOfRolls(9);
		assertEquals("Draw", craps.gameResult());
		
		craps.setSumOfRolls(10);
		assertEquals("Draw", craps.gameResult());
		
		craps.setSumOfRolls(11);
		assertEquals("Win", craps.gameResult());
		
		craps.setSumOfRolls(12);
		assertEquals("Lose", craps.gameResult());
		
		
		
		//Unsure why but the following tests do not work, even though I know the program is working.
		
		//draw
		craps.setMoney(10);
		craps.setSumOfRolls(1);
		craps.gameResult();
		assertEquals(10, craps.getMoney());
		
		//lose
		craps.setMoney(10);
		craps.setSumOfRolls(2);
		craps.gameResult();
		assertEquals(0, craps.getMoney());
		
		craps.setMoney(10);
		craps.setSumOfRolls(3);
		craps.gameResult();
		assertEquals(0, craps.getMoney());
		
		craps.setMoney(12);
		craps.setSumOfRolls(3);
		craps.gameResult();
		assertEquals(0, craps.getMoney());
		
		//win
		craps.setMoney(10);
		craps.setSumOfRolls(7);
		craps.gameResult();
		assertEquals(20, craps.getMoney());
		
	}

}
