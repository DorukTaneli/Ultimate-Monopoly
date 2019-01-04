package domainLayer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domainLayer.Board;
import domainLayer.Player;
import domainLayer.squares.TransitSquare;

public class TransitSquaresetOwnerTest {

	Board b = new Board();
	Player p = new Player("TestingPlayer",b);
	@Test
	public void test() {
		System.out.println("\nTesting TransitSquare's setOwner()\n");
		for(int i=0;i<4;i++) {
			TransitSquare Tsq= (TransitSquare)b.getSquareByIndex(5+i*10);
			Tsq.setOwner(p);
			assertEquals(Tsq.getBrother().owner.getName(), p.getName());
			assertEquals(Tsq.owner.getName(),p.getName());
		}

	}

}
