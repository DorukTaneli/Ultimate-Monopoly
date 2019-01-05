package domainLayer.bots;

import java.util.Random;

import domainLayer.DomainController;
import domainLayer.Player;

public class BotSmart extends Bot implements BotInterface{
	public BotSmart(Player p, DomainController ctrl) {
		super(p, ctrl);
		// TODO Auto-generated constructor stub
	}

	Random rand = new Random();
	int turnMoveCounter=0;
	
	@Override
	public void manageAction() {
		System.out.println("Action wanted from Bot "+p.getName());
		
		switch(turnMoveCounter) {
		case 0: botRoll(); break;
		case 1:	botBuy(); break;
		case 2: botBuild(); break;
		default: turnMoveCounter=0; botEnd();
		}
		turnMoveCounter++;
		
	}
	
	
	
	

}
