package domainLayer.bots;

import domainLayer.DomainController;
import domainLayer.Player;

public class Bot {

	
	Player p;
	public BotInterface BI;
	DomainController ctrl;

	public Bot(Player p, DomainController ctrl){
		this.ctrl=ctrl;
		this.p=p;

	}
	
	public void manageTurn() {
		Player currentPlayer = ctrl.getCurrentPlayer();
		//System.out.println("Hello I Am A Bot and this is my Turn!!----------------------------");
		while(currentPlayer.getName().equals(p.getName())) {
			BI.manageAction();
			currentPlayer = ctrl.getCurrentPlayer();
		}
		
		
		
	}
	
	public void selectMode(int mode) {
		switch(mode) {
		case 1: BI = new BotRandom(p ,ctrl); return;
		
		
		}
	}


	public void botBuy() {
		ctrl.buyPressed();
	}

	public void botRoll() {
		ctrl.rollPressed();
	}

	public void botEnd() {
		ctrl.endTurnPressed();
	}


	public void botBuild() {
		ctrl.buildPressed();
	}



}
