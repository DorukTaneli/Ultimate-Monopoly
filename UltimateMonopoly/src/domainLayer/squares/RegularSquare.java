package domainLayer.squares;

import domainLayer.Player;

public class RegularSquare extends Square{
	
	public RegularSquare(String name, int index) {
		super(name, index);
		setType("RegularSquare");
	}
	
	public void landedOn(Player p) {
		if(this.getName().equals("Go to Jail")) p.goToJail();
	}
	
	@Override
	public void passedOn(Player p) {
		// TODO Auto-generated method stub
		
	}

}
