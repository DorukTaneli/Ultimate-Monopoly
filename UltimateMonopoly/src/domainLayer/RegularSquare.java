package domainLayer;

public class RegularSquare extends Square{
	
	public RegularSquare(String name, int index) {
		super(name, index);
		type="RegularSquare";
	}
	
	public void landedOn(Player p) {
		if(this.getName().equals("Go to Jail")) p.goToJail();
	}
	
	@Override
	public void passedOn(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isOwned() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
}
