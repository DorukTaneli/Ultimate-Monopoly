package domainLayer.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domainLayer.Board;
import domainLayer.Player;
import domainLayer.cards.Card;
import domainLayer.cards.RollThreeCard;
import domainLayer.squares.PropertySquare;
import domainLayer.squares.Square;

class PlayerTest {
	
	Board b;
	Player p;
	Player p2;
	Card card;
	Card card1;
	Square prop;
	Square prop2;
	
	public boolean repOK() {
		if(p.getJailCounter() < 0) return false;
		if(p.getCash() < 0) return false;
		return true;
	}
	
	@BeforeEach
	void setUp() {
		b = new Board();
		p = new Player("TestingPlayer",b);
		p2 = new Player("TestingPlayer2",b);
		int[] a= {1,2,3};
		card=new RollThreeCard("TestCard",a);
		int[] c= {1,2,4};
		card1=new RollThreeCard("TestCard",c);
		prop=b.getSquareByIndex(1);
		prop2=b.getSquareByIndex(2);
	}
	
	@Test
	void testWhichlayer() {
		Square sq = b.getSquareByIndex(4);
		p.teleportNoLand(sq);
		assertEquals(1, p.whichlayer());
		
		sq = b.getSquareByIndex(45);
		p.teleportNoLand(sq);
		assertEquals(0, p.whichlayer());
		
		sq = b.getSquareByIndex(93);
		p.teleportNoLand(sq);
		assertEquals(2, p.whichlayer());
	}

	@Test
	void testTakeTurn() {
		p.teleportNoLand(b.getSquareByIndex(11));
		p.haveRolled=true;
		p.takeTurn();
		assertEquals(p.getLocation().getName(), b.getSquareByIndex(11).getName());
		
		
		p.teleportNoLand(b.getSquareByIndex(11));
		p.haveRolled=false;
		p.takeTurn();
		if(p.cup.isDualRoll()) assertEquals(false,p.haveRolled);
		else assertEquals(true,p.haveRolled);
	}
	
	@Test
	void testUseCard() {
		p.keepCard(card);
		p.keepCard(card1);
		p.useCard(card);
		for(int i=0;i<p.getInventory().size();i++) {
			assertEquals(p.getInventory().get(i),card1);
		}
		assertEquals(p.getInventory().size(),1);
	}

	@Test
	void testMoveOneByOneFor() {
		for(int i=2;i<13;i++) {
			Square start = b.getSquareByIndex(100);
			Square end = b.getSquareByIndex(100+i);
			p.teleportNoLand(start);
			p.moveOneByOneFor(i);
			assertEquals(end.getName(),p.getLocation().getName());
			
		}
	}

	@Test
	void testTeleportToLand() {
		p.teleportToLand(b.getSquareByIndex(11));
		assertEquals(p.getLocation().getName(), b.getSquareByIndex(11).getName());
		assertNotEquals(p.getLocation().getName(), b.getSquareByIndex(12).getName());
	}

	@Test
	void testGoToJail() {
		p.teleportToLand(b.getSquareByIndex(22));
		p.goToJail();
		assertEquals(p.getLocation(),b.getSquareByIndex(10));
		assertNotEquals(p.getLocation(),b.getSquareByIndex(22));
	}

	@Test
	void testTryToGetOutOfJail() {
		p.goToJail();
		assertEquals(p.getLocation().getName(),b.getSquareByIndex(10).getName()); //index 10 is the jail
		
		p.cup.setDual(1, 1);
		p.tryToGetOutOfJail();
		p.moveOneByOneFor(2);
		assertEquals(p.getLocation().getName(),b.getSquareByIndex(12).getName());
		
		p.goToJail();
		p.cup.setDual(1, 2);
		p.tryToGetOutOfJail();
		assertEquals(p.getLocation().getName(), b.getSquareByIndex(10).getName());
	}

	@Test
	void testAttemptPurchase() {
		PropertySquare pSquare = (PropertySquare)b.getSquareByIndex(1);
		p.teleportNoLand(pSquare);
		assertEquals(false,pSquare.isOwned());
		p.attemptPurchase(pSquare);
		assertEquals(true,pSquare.isOwned());
		assertEquals(p.getName(),pSquare.owner.getName());
		p2.teleportNoLand(pSquare);
		p2.attemptPurchase(pSquare);
		assertEquals(true,pSquare.isOwned());
		assertEquals(p.getName(),pSquare.owner.getName());
	}

	@Test
	void testAddProperty() {
		p.addProperty(prop);
		p.addProperty(prop2);
		assertNotEquals(p.getPlayerProperties().size(),1);
		assertEquals(p.getPlayerProperties().size(),2);
	}

	@Test
	void testKeepCard() {
		p.keepCard(card);
		for(int i=0;i<p.getInventory().size();i++) {
			assertEquals(p.getInventory().get(i),card);
		}
	}
	
	@Test
	void testIsMyProperty() {
		p.attemptPurchase((PropertySquare)b.getSquareByIndex(1));
		p.isMyProperty(b.getSquareByIndex(1));
	}
	
	@Test 
    void testAddCash() {
        Player p3 = new Player("TestingPlayer",b);
        p3.addCash(300);
        assertEquals(p3.getCash(),1800);
    }
	
	@Test 
    void testReduceCash() {
        Player p3 = new Player("TestingPlayer",b);
        p3.reduceCash(300);
        assertEquals(p3.getCash(),1200);
    }
	
	
}

