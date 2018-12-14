package domainLayer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domainLayer.Board;
import domainLayer.Player;
import domainLayer.squares.Square;

public class PlayermoveOneByOneForTest {
	Board b = new Board();
	Player p = new Player("TestingPlayer",b);
	
	
	@Test
	public void test() {
		for(int i=2;i<13;i++) {
			Square start = b.getSquareByIndex(100);
			Square end = b.getSquareByIndex(100+i);
			p.teleportNoLand(start);
			p.moveOneByOneFor(i);
			assertEquals(end.getName(),p.getLocation().getName());
			
		}
		
	}

}
