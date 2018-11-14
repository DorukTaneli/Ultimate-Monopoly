package domainLayer;

public class TransitSquare extends Square{

	private int secondIndex;
	
	public TransitSquare(String name, int index) {
		super(name, index);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn(Player p) {
		//if(p.haveRolledEven()==true)
		
	}

	public void passedOn(Player p) {
		
	}

	public int getSecondIndex() {
		return secondIndex;
	}

	public void setSecondIndex(int secondIndex) {
		this.secondIndex = secondIndex;
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
