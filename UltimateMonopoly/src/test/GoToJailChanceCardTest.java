package test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domainLayer.Board;
import domainLayer.Player;
import domainLayer.cards.GoToJailChanceCard;

class GoToJailChanceCardTest {
	
	Board b;
	Player p;
	
	@BeforeEach
	void setUp() {
		b = new Board();
		p = new Player("Testing Player",b);
	}
	
	
	@Test
	void testCardAction() {
		GoToJailChanceCard jCard = new GoToJailChanceCard();
		jCard.setDrawer(p);
		p.teleportNoLand(b.getSquareByIndex(1));
		jCard.cardAction();
		assertEquals(p.getLocation().getName(), b.getSquareByIndex(10).getName());
	}

}

