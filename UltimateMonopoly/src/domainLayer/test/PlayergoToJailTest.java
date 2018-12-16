package domainLayer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domainLayer.Board;
import domainLayer.Player;
import domainLayer.squares.PropertySquare;
import domainLayer.squares.Square;

public class PlayergoToJailTest {
	Board b = new Board();
	Player p = new Player("TestingPlayer",b);
	
	@Test
	public void test() {
		p.teleportToLand(b.getSquareByIndex(22));
		p.goToJail();
		assertEquals(p.getLocation(),b.getSquareByIndex(10));
		assertNotEquals(p.getLocation(),b.getSquareByIndex(22));
		
	}
}
