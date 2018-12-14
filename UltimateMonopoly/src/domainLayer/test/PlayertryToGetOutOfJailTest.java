package domainLayer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domainLayer.Board;
import domainLayer.Player;

public class PlayertryToGetOutOfJailTest {
	Board b = new Board();
	Player p = new Player("TestingPlayer",b);
	
	@Test
	public void test() {
		p.goToJail();
		assertEquals(p.getLocation().getName(),b.getSquareByIndex(10).getName()); //index 10 is the jail
		
		p.cup.setDual(1, 1);
		p.tryToGetOutOfJail();
		p.moveOneByOneFor(2);
		assertEquals(p.getLocation().getName(),b.getSquareByIndex(12).getName());
		
		p.goToJail();
		p.cup.setDual(1, 2);
		p.tryToGetOutOfJail();
		assertEquals(p.getLocation().getName(), b.getSquareByIndex(10).getName());
		
	}

}
