package domainLayer.squares;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import domainLayer.Player;
import domainLayer.cards.ChanceCard;
import domainLayer.cards.GoToJailChanceCard;
import domainLayer.cards.StCharlesChanceCard;

public class ChanceSquare extends Square implements Serializable{
	
	List<ChanceCard> cards = new ArrayList<ChanceCard>();
	ChanceCard Jailcard = new GoToJailChanceCard("Go to Jail Card", false);
	ChanceCard StCharlescard = new StCharlesChanceCard("Go to Jail Card", false);

	public ChanceSquare(String name, int index) {
		super(name, index);
		setType("ChanceSquare");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn(Player p) {
		// TODO Auto-generated method stub
		drawChanceCard(p);
		if(!card.isKeepable()) {
			card.cardAction();
//		}else{
//			card.addToInventory(p);
		}			
	}

	private void drawChanceCard(Player p) {
		// TODO Auto-generated method stub
		card.setDrawer(p);
	}

	@Override
	public void passedOn(Player p) {
		//Do nothing
	}
}
