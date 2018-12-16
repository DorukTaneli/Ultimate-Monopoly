package domainLayer.test;


import org.junit.Before;
import org.junit.Test;

import domainLayer.Board;
import domainLayer.squares.Square;

class BoardTest {
	
	Board b;
	
	@Before
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

/*	@Test
	void testGetSquare() {
		fail("Not yet implemented");
	}

	@Test
	void testGetSquareByIndex() {
		fail("Not yet implemented");
	}

	@Test
	void testBuildSquares() {
		fail("Not yet implemented");
	}

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

	@Test
	void testLinkSquares() {
		fail("Not yet implemented");
	}*/

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
