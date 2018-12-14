/**
 * 
 */
package domainLayer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domainLayer.Board;
import domainLayer.Player;
import domainLayer.cards.GoToJailChanceCard;

public class GoToJailChanceCardcardActionTest {

	
	Board b = new Board();
	Player p = new Player("TestingPlayer",b);
	@Test
	public void test() {
		GoToJailChanceCard jCard = new GoToJailChanceCard("GoToJailChanceCard", false);
		jCard.setDrawer(p);
		p.teleportNoLand(b.getSquareByIndex(1));
		jCard.cardAction();
		assertEquals(p.getLocation().getName(), b.getSquareByIndex(10).getName());

	}

}
