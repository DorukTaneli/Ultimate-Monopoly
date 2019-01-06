package domainLayer.squares;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import domainLayer.Player;
import domainLayer.cards.ChanceCard;
import domainLayer.cards.GoToJailChanceCard;
import domainLayer.cards.HolidayBonusChanceCard;
import domainLayer.cards.StCharlesChanceCard;

public class ChanceSquare extends Square implements Serializable{
	
	List<ChanceCard> cards = new ArrayList<ChanceCard>();


	public ChanceSquare(String name, int index) {
		super(name, index);
		setType("ChanceSquare");
		ChanceCard JailCard = new GoToJailChanceCard();
		ChanceCard StCharlesCard = new StCharlesChanceCard();
		ChanceCard HolidayBonusCard = new HolidayBonusChanceCard();
		
		cards.add(JailCard);
		cards.add(StCharlesCard);
		cards.add(HolidayBonusCard);
	}

	@Override
	public void landedOn(Player p) {
		ChanceCard card = drawChanceCard(p);
		if(!card.isKeepable()) {
			card.cardAction();
//		}else{
//			card.addToInventory(p);
		}			
	}

	private ChanceCard drawChanceCard(Player p) {
		Random rand = new Random();
		int val = rand.nextInt(3);
		ChanceCard card = cards.get(val);
		card.setDrawer(p);
		return card;
	}

	@Override
	public void passedOn(Player p) {
		//Do nothing
	}
}
