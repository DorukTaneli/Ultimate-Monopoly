package domainLayer.bots;

import java.util.Random;

import domainLayer.DomainController;
import domainLayer.Player;

public class BotRandom extends Bot implements BotInterface{
	public BotRandom(Player p, DomainController ctrl) {
		super(p, ctrl);
		// TODO Auto-generated constructor stub
	}

	Random rand = new Random();
	int turnMoveCounter=0;
	
	@Override
	public void manageAction() {
		System.out.println("Action wanted from Bot "+p.getName());
		if(turnMoveCounter==0) {
			botRoll(); turnMoveCounter++; return;
		}
		int r = rand.nextInt(3);
		switch(r) {
			case 0: botRoll(); break;
			case 1: botBuy(); break;
			case 2: botBuild(); break;
		}
		
		if(turnMoveCounter<5) turnMoveCounter++;
		else {
			turnMoveCounter=0;
			botEnd();
		}
		
	}
	
	
	
	

}
