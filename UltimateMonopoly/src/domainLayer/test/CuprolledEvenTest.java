package domainLayer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domainLayer.Cup;

public class CuprolledEvenTest {

	
	Cup cp = new Cup();
	@Test
	public void test() {
		cp.roll();
		if(cp.get2RollValue()%2==0)
			assertEquals(true, cp.rolledEven());
		else
			assertEquals(false, cp.rolledEven());
		
	}

}
