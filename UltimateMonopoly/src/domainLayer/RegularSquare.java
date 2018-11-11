package domainLayer;

public class RegularSquare extends Square{
	
	public RegularSquare(String name, int index) {
		super(name, index);
	}
	
	public void landedOn(Player p) {
		if(this.getName().equals("Go to Jail")) p.goToJail();
	}
	
	@Override
	public void passedOn(Player p) {
		// TODO Auto-generated method stub
		
	}
}
