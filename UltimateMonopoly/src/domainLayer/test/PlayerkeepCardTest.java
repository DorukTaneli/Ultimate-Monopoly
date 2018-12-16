package domainLayer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domainLayer.Board;
import domainLayer.Player;
import domainLayer.cards.Card;
import domainLayer.cards.RollThreeCard;

public class PlayerkeepCardTest {
	Board b=new Board();
	Player p=new Player("Testing Player",b);
	int[] a= {1,2,3};
	Card card=new RollThreeCard("TestCard",a);
	
	@Test
	public void test() {
		p.keepCard(card);
		for(int i=0;i<p.getInventory().size();i++) {
			assertEquals(p.getInventory().get(i),card);
		}
	}
}
