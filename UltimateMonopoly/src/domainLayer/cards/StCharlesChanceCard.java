package domainLayer.cards;

import domainLayer.DomainController;
import domainLayer.squares.Square;

public class StCharlesChanceCard extends ChanceCard{

	public StCharlesChanceCard(String name, Boolean keepable) {
		super(name, keepable);
	}

	@Override
	public void cardAction() {
		Square stCharles = DomainController.getInstance().getBoard().getSquareByIndex(11);
		this.drawer.teleportToLand(stCharles);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
