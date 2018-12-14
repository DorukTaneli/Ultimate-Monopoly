package domainLayer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domainLayer.Board;
import domainLayer.squares.TransitSquare;

public class TransitSquaregetBrotherTest {
	Board b = new Board();
	@Test
	public void test() {
		System.out.println("\nTesting TransitSquare's getBrother()\n");
		for(int i=0;i<4;i++) {
			TransitSquare Tsq= (TransitSquare)b.getSquareByIndex(5+i*10);
			assertNotEquals(Tsq.getBrother().getName(), Tsq.getName());
			assertEquals(Tsq.getBrother().getBrother().getName(),Tsq.getName());
		}

	}


}
