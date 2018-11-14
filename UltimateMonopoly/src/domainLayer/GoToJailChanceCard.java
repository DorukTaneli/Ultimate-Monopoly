package domainLayer;

public class GoToJailChanceCard extends ChanceCard{

	public GoToJailChanceCard(String name, Boolean keepable) {
		super(name, keepable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cardAction() {
		// TODO Auto-generated method stub
		drawer.goToJail();
	}
	
	

}
