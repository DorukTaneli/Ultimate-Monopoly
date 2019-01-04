package domainLayer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domainLayer.Cup;

public class CupisDualRollTest {

	Cup cp = new Cup();
	@Test
	public void test() {
		cp.roll();
		cp.setFirstDie(3);
		cp.setSecondDie(3);
		boolean output=cp.isDualRoll();
		assertEquals(true,output);
		
		cp.roll();
		cp.setFirstDie(2);
		cp.setSecondDie(3);
		output=cp.isDualRoll();
		assertEquals(false,output);
		
	}

}
