package domainLayer.squares;

import domainLayer.Player;

public class GoSquare extends Square{

	private int salary = 200;
	private Player lastToPass;
	
	public GoSquare(String name, int index) {
		super(name, index);
		// TODO Auto-generated constructor stub
	}
	
	public void landedOn(Player p) {
		p.addCash(salary);
		System.out.println("Player "+p.getName()+" has passed Go and received "+salary+"\n Total Money: "+p.getCash());
		
	}
	
	public void passedOn(Player p) {
		p.addCash(salary);
		System.out.println("Player "+p.getName()+" has passed Go and received "+salary+"\n Total Money: "+p.getCash());

	}
}
