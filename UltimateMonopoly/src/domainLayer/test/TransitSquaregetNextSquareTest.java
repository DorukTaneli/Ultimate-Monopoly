package domainLayer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domainLayer.Board;
import domainLayer.Player;
import domainLayer.squares.TransitSquare;

public class TransitSquaregetNextSquareTest {

	Board b = new Board();
	
	
	@Test
	public void test() {
		System.out.println("\nTesting TransitSquare's getNextSquare()\n");
		for(int i=0;i<4;i++) {
			TransitSquare Tsq= (TransitSquare)b.getSquareByIndex(5+i*10);
			assertNotEquals(Tsq.getNextSquare(0).getName(), Tsq.getNextSquare(1).getName());
			assertEquals(Tsq.getBrother().getNextSquareFromSuper(0).getName(), Tsq.getNextSquare(0).getName());
			assertEquals(Tsq.getNextSquareFromSuper(1).getName(), Tsq.getNextSquare(1).getName());
		}
		
		
		
		
	}

}
