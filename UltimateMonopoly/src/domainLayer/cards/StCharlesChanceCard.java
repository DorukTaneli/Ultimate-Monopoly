package domainLayer.cards;

import domainLayer.DomainController;
import domainLayer.squares.Square;

public class StCharlesChanceCard extends ChanceCard{

	public StCharlesChanceCard() {
		super("StCharlesChanceCard", false);
	}

	@Override
	public void cardAction() {
		System.out.println(this.getName() + " ACTIVATED ON PLAYER: "+drawer.getName());
		
		Square stCharles = DomainController.getInstance().getBoard().getSquareByIndex(11);
		this.drawer.teleportToLand(stCharles);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
