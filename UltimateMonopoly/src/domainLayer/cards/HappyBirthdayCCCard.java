package domainLayer.cards;

import java.util.List;

import domainLayer.DomainController;
import domainLayer.Player;

public class HappyBirthdayCCCard extends CommunityChestCard {

	public HappyBirthdayCCCard(String name, Boolean keepable) {
		super("HappyBirthdayCCCard", false);
	}

	@Override
	public void cardAction() {
		System.out.println(this.getName() + " ACTIVATED ON PLAYER: "+drawer.getName());
		
		List<Player> players = DomainController.getInstance().getPlayers();
		for (Player p : players) {
			p.reduceCash(10);
			drawer.addCash(10);
		}
		
		drawer.teleportToLand(DomainController.getInstance().getBoard().getSquareByIndex(115));	
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
