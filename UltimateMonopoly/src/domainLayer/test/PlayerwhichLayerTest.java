package domainLayer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domainLayer.Board;
import domainLayer.Player;
import domainLayer.squares.Square;

public class PlayerwhichLayerTest {

	Board b = new Board();
	Player p = new Player("TestingPlayer",b);
	@Test
	public void test() {
		Square sq = b.getSquareByIndex(4);
		p.teleportNoLand(sq);
		assertEquals(1, p.whichlayer());
		
		sq = b.getSquareByIndex(45);
		p.teleportNoLand(sq);
		assertEquals(0, p.whichlayer());
		
		sq = b.getSquareByIndex(93);
		p.teleportNoLand(sq);
		assertEquals(2, p.whichlayer());
		
	}

}
