package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domainLayer.Board;
import domainLayer.Cup;

class CupTest {
	
	Cup cp;
	
	@BeforeEach
	void setUp() {
		cp = new Cup();
	}
	
	public boolean repOK() {
        if(cp.getFirstDie()<1 || cp.getFirstDie()>6) return false;
        if(cp.getSecondDie()<1 || cp.getSecondDie()>6) return false;
        if(cp.getThirdDie()<1 || cp.getThirdDie()>6) return false;
        return true;
    }
	
	@Test
	void testRoll() {
		int valOriginal = cp.get2RollValue();
		
		while(valOriginal==cp.get2RollValue()) {
			cp.roll();
			
		}
		assertNotEquals(valOriginal, cp.get2RollValue());
	}

	@Test
	void testIsDualRoll() {
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

	@Test
	void testIsThirdDualRoll() {
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

	@Test
	void testRolledEven() {
		cp.roll();
		if(cp.get2RollValue()%2==0)
			assertEquals(true, cp.rolledEven());
		else
			assertEquals(false, cp.rolledEven());
	}

	@Test
	void testRolledOdd() {
		cp.roll();
		if(cp.get2RollValue()%2==1)
			assertEquals(true, cp.rolledOdd());
		else
			assertEquals(false, cp.rolledOdd());
	}
	
	@Test
	void testget2RollValue() {
		assertEquals(cp.getFirstDie() + cp.getSecondDie(),
				cp.get2RollValue());
	}

	@Test
	void testget3RollValue() {
		assertEquals(cp.getFirstDie() + cp.getSecondDie() + cp.getThirdDie(),
				cp.get3RollValue());
	}

	
}
