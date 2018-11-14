package domainLayer;

public class CommunityChestSquare extends Square{
	
	CommunityChestCard card = new PayHospitalBillsCommunityChestCard("Pay Hospital Bills", false);

	public CommunityChestSquare(String name, int index) {
		super(name, index);
		type="CommunityChestSquare";
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
