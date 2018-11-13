package domainLayer;

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
