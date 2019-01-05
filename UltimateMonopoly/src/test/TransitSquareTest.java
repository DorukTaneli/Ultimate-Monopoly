package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domainLayer.squares.TransitSquare;
import domainLayer.Board;
import domainLayer.Player;

class TransitSquareTest {
	
	Board b;
	Player p;

	@BeforeEach
	void setUp() {
		b=new Board();
		p = new Player("TestingPlayer",b);
	}
	
	
	@Test
	void testGetNextSquare() {
		System.out.println("\nTesting TransitSquare's getNextSquare()\n");
		for(int i=0;i<4;i++) {
			TransitSquare Tsq= (TransitSquare)b.getSquareByIndex(5+i*10);
			assertNotEquals(Tsq.getNextSquare(0).getName(), Tsq.getNextSquare(1).getName());
			assertEquals(Tsq.getBrother().getNextSquareFromSuper(0).getName(), Tsq.getNextSquare(0).getName());
			assertEquals(Tsq.getNextSquareFromSuper(1).getName(), Tsq.getNextSquare(1).getName());
		}
	}

	@Test
	void testGetBrother() {
		System.out.println("\nTesting TransitSquare's getBrother()\n");
		for(int i=0;i<4;i++) {
			TransitSquare Tsq= (TransitSquare)b.getSquareByIndex(5+i*10);
			assertNotEquals(Tsq.getBrother().getName(), Tsq.getName());
			assertEquals(Tsq.getBrother().getBrother().getName(),Tsq.getName());
		}
	}
	
	@Test
	void setOwnerTest() {
		System.out.println("\nTesting TransitSquare's setOwner()\n");
		for(int i=0;i<4;i++) {
			TransitSquare Tsq= (TransitSquare)b.getSquareByIndex(5+i*10);
			Tsq.setOwner(p);
			assertEquals(Tsq.getBrother().owner.getName(), p.getName());
			assertEquals(Tsq.owner.getName(),p.getName());
		}
	}

}
