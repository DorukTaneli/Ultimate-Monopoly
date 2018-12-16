package domainLayer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domainLayer.Board;
import domainLayer.Player;
import domainLayer.squares.DeedSquare;
import domainLayer.squares.PropertySquare;
import domainLayer.squares.Square;

public class PlayeraddPropertyTest {
	Board b=new Board();
	Player p=new Player("Testing Player", b);
	Square prop=b.getSquareByIndex(1);
	Square prop2=b.getSquareByIndex(2);
	
	@Test
	public void test() {
		p.addProperty(prop);
		p.addProperty(prop2);
		assertNotEquals(p.getPlayerProperties().size(),1);
		assertEquals(p.getPlayerProperties().size(),2);
		
	}
}
