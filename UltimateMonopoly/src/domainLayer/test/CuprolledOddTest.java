package domainLayer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domainLayer.Cup;

public class CuprolledOddTest {

	
	Cup cp = new Cup();
	@Test
	public void test() {
		cp.roll();
		if(cp.get2RollValue()%2==1)
			assertEquals(true, cp.rolledOdd());
		else
			assertEquals(false, cp.rolledOdd());
		
	}

}
