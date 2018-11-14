package domainLayer;

public class UtilitySquare extends Square{

	private int price;
	
	public UtilitySquare(String name, int index, int price) {
		super(name, index);
		this.price = price;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void passedOn(Player p) {
		// TODO Auto-generated method stub
		
	}
}
