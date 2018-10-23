package domainLayer;

public class GoSquare extends Square{

	private int salary = 200;
	
	public GoSquare(String name, int index) {
		super(name, index);
		// TODO Auto-generated constructor stub
	}
	
	public void landedOn(Player p) {
		p.addCash(salary);
	}

}
