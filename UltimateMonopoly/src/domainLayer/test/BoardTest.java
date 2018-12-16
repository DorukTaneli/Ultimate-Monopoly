package domainLayer.test;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import domainLayer.Board;
import domainLayer.squares.Square;

class BoardTest {
	
	Board b;

	@BeforeEach
	void setUp() {
		b = new Board();
	}
	
	@Test
	void testSetUpTransitSquares() {
		assertEquals(true, b.getSquareByIndex(15).getType().equals("TransitSquare"));
		
		assertEquals(true, b.getSquareByIndex(25).getType().equals("TransitSquare"));
		
		assertEquals(true, b.getSquareByIndex(35).getType().equals("TransitSquare"));
		
		assertEquals(true, b.getSquareByIndex(5).getType().equals("TransitSquare"));
			
	}

	@Test
	void testGetSquareByIndex() {
		assertEquals("Mediterranean Avenue",b.getSquareByIndex(1).getName());
		assertEquals("Oriental Avenue",b.getSquareByIndex(6).getName());
	}
	
	
	@Test
	void testBuildSquares() {
		assertEquals("Baltic Avenue",b.getSquareByIndex(3).getName());
		
		assertEquals("Virginia Avenue",b.getSquareByIndex(14).getName());
	}
	
	/*
	@Test
	void testBuildPS() {
		fail("Not yet implemented");
	}

	@Test
	void testBuildRS() {
		fail("Not yet implemented");
	}

	@Test
	void testBuildRTS() {
		fail("Not yet implemented");
	}

	@Test
	void testBuildTransit() {
		fail("Not yet implemented");
	}

	@Test
	void testBuildChance() {
		fail("Not yet implemented");
	}

	@Test
	void testBuildCCS() {
		fail("Not yet implemented");
	}
*/
	
	@Test
	void testLinkSquares() {
		assertEquals("Mediterranean Avenue", b.getStartSquare().getNextSquare(1).getName());
		assertEquals(40, b.getSquareByIndex(63).getNextSquare(1).getIndex());
	}

	@Test
	void testLink() {

		for(int i=0;i<=39;i++) {

			System.out.println("CurrentSquare's Next: "+b.getSquareByIndex(i).getNextSquare(7).getName()+"\n"
					+ "Next Square on Board: "+b.getSquareByIndex(((i+1)%40)).getName()+"\n\n");
			assertEquals(b.getSquareByIndex(i).getNextSquare(1).getName(),b.getSquareByIndex(((i+1)%40)).getName());

		}


		for(int i=0;i<=23;i++) {

			System.out.println("CurrentSquare's Next: "+b.getSquareByIndex(i+40).getNextSquare(7).getName()+"\n"
					+ "Next Square on Board: "+b.getSquareByIndex(((i+1)%24)+40).getName()+"\n\n");
			assertEquals(b.getSquareByIndex(i+40).getNextSquare(1).getName(),b.getSquareByIndex(((i+1)%24)+40).getName());

		}

		for(int i=0;i<=55;i++) {

			System.out.println("CurrentSquare's Next: "+b.getSquareByIndex(i+64).getNextSquare(7).getName()+"\n"
					+ "Next Square on Board: "+b.getSquareByIndex(((i+1)%56)+64).getName()+"\n\n");
			assertEquals(b.getSquareByIndex(i+64).getNextSquare(1).getName(),b.getSquareByIndex(((i+1)%56)+64).getName());

		}
	}

}
