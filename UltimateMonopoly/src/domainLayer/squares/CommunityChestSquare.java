package domainLayer.squares;

import java.io.Serializable;

import domainLayer.Player;
import domainLayer.cards.CommunityChestCard;
import domainLayer.cards.PayHospitalBillsCommunityChestCard;

public class CommunityChestSquare extends Square implements Serializable{
	
	CommunityChestCard card = new PayHospitalBillsCommunityChestCard("Pay Hospital Bills", false);

	public CommunityChestSquare(String name, int index) {
		super(name, index);
		setType("CommunityChestSquare");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn(Player p) {
		// TODO Auto-generated method stub
		drawCommunityChanceCard(p);
		if(!card.isKeepable()) {
			card.cardAction();
//		}else{
//			card.addToInventory(p);
		}
	}

	private void drawCommunityChanceCard(Player p) {
		// TODO Auto-generated method stub
		card.setDrawer(p);
	}

	@Override
	public void passedOn(Player p) {
		// Do nothing
	}
}
