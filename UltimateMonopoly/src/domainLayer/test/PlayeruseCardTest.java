package domainLayer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domainLayer.Board;
import domainLayer.Player;
import domainLayer.cards.Card;
import domainLayer.cards.RollThreeCard;

public class PlayeruseCardTest {
	Board b=new Board();
	Player p=new Player("Testing Player",b);
	int[] a= {1,2,3};
	Card card=new RollThreeCard("TestCard",a);
	int[] c= {1,2,4};
	Card card1=new RollThreeCard("TestCard",c);
	
	@Test
	public void test() {
		p.keepCard(card);
		p.keepCard(card1);
		p.useCard(card);
		for(int i=0;i<p.getInventory().size();i++) {
			assertEquals(p.getInventory().get(i),card1);
		}
		assertEquals(p.getInventory().size(),1);
	
	}
}
