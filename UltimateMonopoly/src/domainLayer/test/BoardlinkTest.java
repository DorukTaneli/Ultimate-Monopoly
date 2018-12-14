package domainLayer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domainLayer.Board;

public class BoardlinkTest {
	Board b = new Board();
	@Test
	public void test() {

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
