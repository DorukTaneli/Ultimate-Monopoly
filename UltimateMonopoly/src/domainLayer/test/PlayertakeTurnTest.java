package domainLayer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domainLayer.Board;
import domainLayer.Player;

public class PlayertakeTurnTest {
	Board b = new Board();
	Player p = new Player("TestingPlayer",b);
	
	@Test
	public void test() {
		p.teleportNoLand(b.getSquareByIndex(11));
		p.haveRolled=true;
		p.takeTurn();
		assertEquals(p.getLocation().getName(), b.getSquareByIndex(11).getName());
		
		
		p.teleportNoLand(b.getSquareByIndex(11));
		p.haveRolled=false;
		p.takeTurn();
		if(p.cup.isDualRoll()) assertEquals(false,p.haveRolled);
		else assertEquals(true,p.haveRolled);
		
//		p.teleportNoLand(b.getSquareByIndex(11));
//		p.haveRolled=false;
//		int iter=0;
//		while(!p.cup.isThirdDualRoll()) {
//			p.inJail=false;
//			p.teleportNoLand(b.getSquareByIndex(11));
//			p.haveRolled=false;
//			p.takeTurn();
//			System.out.println("Iteration test: " + ++iter+"Dual roll?: "+p.cup.isDualRoll());
//			
//		}
//		assertEquals(true,p.haveRolled);
//		assertEquals(p.getLocation().getName(),b.getSquareByIndex(10).getName());
		
		
		
	}

}
