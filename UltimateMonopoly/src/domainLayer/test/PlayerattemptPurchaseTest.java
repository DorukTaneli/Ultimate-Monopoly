package domainLayer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domainLayer.Board;
import domainLayer.Player;
import domainLayer.squares.PropertySquare;
import domainLayer.squares.Square;

public class PlayerattemptPurchaseTest {

	
	Board b = new Board();
	Player p = new Player("TestingPlayer",b);
	Player p2 = new Player("TestingPlayer2",b);
	@Test
	public void test() {
		PropertySquare pSquare = (PropertySquare)b.getSquareByIndex(1);
		p.teleportNoLand(pSquare);
		assertEquals(false,pSquare.isOwned());
		p.attemptPurchase(pSquare);
		assertEquals(true,pSquare.isOwned());
		assertEquals(p.getName(),pSquare.owner.getName());
		p2.teleportNoLand(pSquare);
		p2.attemptPurchase(pSquare);
		assertEquals(true,pSquare.isOwned());
		assertEquals(p.getName(),pSquare.owner.getName());
	}

}
