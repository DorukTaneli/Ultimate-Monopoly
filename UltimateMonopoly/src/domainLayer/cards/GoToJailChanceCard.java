package domainLayer.cards;

public class GoToJailChanceCard extends ChanceCard{

	public GoToJailChanceCard(String name, Boolean keepable) {
		super(name, keepable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cardAction() {
		// TODO Auto-generated method stub
		System.out.println("GO TO JAIL CHANCE CARD ACTIVATED ON PLAYER: "+drawer.getName());
		drawer.goToJail();
	}

	@Override
	public String getType() {
		return null;
	}
	
	

}
