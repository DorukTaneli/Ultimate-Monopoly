package domainLayer.bots;

import java.io.Serializable;

import domainLayer.DomainController;
import domainLayer.Player;
import uiLayer.AppWindow;

public class Bot  implements Serializable{

	
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
		case 1: BI = new BotDumb(p, ctrl); return;
		case 2: BI = new BotSmart(p, ctrl); return;
		default: BI = new BotRandom(p ,ctrl); return;
		}
	}


	public void botBuy() {
		ctrl.buyPressed();
	}

	public void botRoll() {
		ctrl.rollPressed(AppWindow.instance);
	}

	public void botEnd() {
		ctrl.endTurnPressed();
	}


	public void botBuild() {
		ctrl.buildPressed();
	}



}
