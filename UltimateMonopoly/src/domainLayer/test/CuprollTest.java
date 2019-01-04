package domainLayer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domainLayer.Cup;

public class CuprollTest {

	Cup cp = new Cup();
	
	@Test
	public void test() {
		int valOriginal = cp.get2RollValue();
		
		while(valOriginal==cp.get2RollValue()) {
			cp.roll();
			
		}
		assertNotEquals(valOriginal, cp.get2RollValue());
		
		
	}

}
