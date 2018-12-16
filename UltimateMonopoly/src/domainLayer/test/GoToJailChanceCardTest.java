package domainLayer.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import domainLayer.Board;
import domainLayer.Player;
import domainLayer.cards.GoToJailChanceCard;

class GoToJailChanceCardTest {
	
	Board b;
	Player p;
	
	@Before
	void setUp() {
		b = new Board();
		p = new Player("Testing Player",b);
	}
	
	
	@Test
	void testCardAction() {
		GoToJailChanceCard jCard = new GoToJailChanceCard("GoToJailChanceCard", false);
		jCard.setDrawer(p);
		p.teleportNoLand(b.getSquareByIndex(1));
		jCard.cardAction();
		assertEquals(p.getLocation().getName(), b.getSquareByIndex(10).getName());
	}

}
