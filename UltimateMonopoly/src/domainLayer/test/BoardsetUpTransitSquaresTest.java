package domainLayer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domainLayer.Board;
import domainLayer.squares.Square;

public class BoardsetUpTransitSquaresTest {
	Board b = new Board();
	@Test
	public void test() {
		
		assertEquals(true, b.getSquareByIndex(15).getType().equals("TransitSquare"));
			
		assertEquals(true, b.getSquareByIndex(25).getType().equals("TransitSquare"));
		
		assertEquals(true, b.getSquareByIndex(35).getType().equals("TransitSquare"));
		
		assertEquals(true, b.getSquareByIndex(5).getType().equals("TransitSquare"));
		
	}

}
