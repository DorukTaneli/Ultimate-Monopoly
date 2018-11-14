package domainLayer;

public class ChanceSquare extends Square{
	
	ChanceCard card = new GoToJailChanceCard("Go to Jail Card", false);

	public ChanceSquare(String name, int index) {
		super(name, index);
		type="ChanceSquare";
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
