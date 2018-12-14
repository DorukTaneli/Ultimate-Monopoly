package domainLayer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domainLayer.Cup;

public class CupisThirdDualRollTest {

	Cup cp = new Cup();
	@Test
	public void test() {
		cp.setDual(1,1);
		assertEquals(false,cp.isThirdDualRoll());
		cp.setDual(2,2);
		assertEquals(false,cp.isThirdDualRoll());
		cp.setDual(3,3);
		assertEquals(true,cp.isThirdDualRoll());
		cp.setDual(1,1);
		assertEquals(false,cp.isThirdDualRoll());
		
		
		cp.setDual(1,2);
		assertEquals(false,cp.isThirdDualRoll());
		cp.setDual(1,2);
		assertEquals(false,cp.isThirdDualRoll());
		cp.setDual(1,2);
		assertEquals(false,cp.isThirdDualRoll());
		cp.setDual(1,2);
		assertEquals(false,cp.isThirdDualRoll());
		
	}

}
