package domainLayer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domainLayer.Board;
import domainLayer.Player;

public class PlayerteleportToLandTest {
	Board b=new Board();
	Player p=new Player("TestingPlayer",b);
	
	@Test
	public void test() {
		p.teleportNoLand(b.getSquareByIndex(11));
		assertEquals(p.getLocation().getName(), b.getSquareByIndex(11).getName());
		assertNotEquals(p.getLocation().getName(), b.getSquareByIndex(12).getName());
	}
}
