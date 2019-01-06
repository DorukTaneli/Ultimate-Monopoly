package domainLayer.squares;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import domainLayer.Player;
import domainLayer.cards.CommunityChestCard;
import domainLayer.cards.HappyBirthdayCCCard;
import domainLayer.cards.PayHospitalBillsCommunityChestCard;

public class CommunityChestSquare extends Square implements Serializable{
	
	List<CommunityChestCard> cards = new ArrayList<CommunityChestCard>();

	public CommunityChestSquare(String name, int index) {
		super(name, index);
		setType("CommunityChestSquare");
		
		CommunityChestCard HospitalCard = new PayHospitalBillsCommunityChestCard();
		CommunityChestCard BDCard = new HappyBirthdayCCCard();
		
		cards.add(HospitalCard);
		cards.add(BDCard);
	}

	@Override
	public void landedOn(Player p) {
		CommunityChestCard card = drawCommunityChestCard(p);
		if(!card.isKeepable()) {
			card.cardAction();
//		}else{
//			card.addToInventory(p);
		}
	}

	private CommunityChestCard drawCommunityChestCard(Player p) {
		Random rand = new Random();
		int val = rand.nextInt(2);
		CommunityChestCard card = cards.get(val);
		card.setDrawer(p);
		return card;
	}
	

	@Override
	public void passedOn(Player p) {
		// Do nothing
	}
}
