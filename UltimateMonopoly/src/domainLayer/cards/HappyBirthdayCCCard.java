package domainLayer.cards;

import java.util.List;

import domainLayer.DomainController;
import domainLayer.Player;
import uiLayer.AppWindow;

public class HappyBirthdayCCCard extends CommunityChestCard {

	public HappyBirthdayCCCard() {
		super("HappyBirthdayCCCard", false);
	}

	@Override
	public void cardAction() {
		System.out.println(this.getName() + " ACTIVATED ON PLAYER: "+drawer.getName());
		
		List<Player> players = AppWindow.getInstance().ctrl.getPlayers(); //Gets the domain controller from AppWindow because of save/load issues
		for (Player p : players) {
			p.reduceCash(10);
			drawer.addCash(10);
		}
		
		drawer.teleportToLand(AppWindow.getInstance().ctrl.getBoard().getSquareByIndex(115));	
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
