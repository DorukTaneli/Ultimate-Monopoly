package domainLayer;

public class TransitSquare extends Square{

	private int secondIndex;
	private Square nextEvenSquare;
	private Square nextOddSquare;
	
	public TransitSquare(String name, int index) {
		super(name, index);
		type="TransitSquare";
		// TODO Auto-generated constructor stub
		
		
	}
	
	public Square getNextSqure(int f) {
		if(f%2==0) {
			return nextEvenSquare;
		}else {
			return nextOddSquare;
		}
	}

	@Override
	public void landedOn(Player p) {
		
		
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
	
	public void setNextEvenSquare(Square nextEvenSquare) {
		this.nextEvenSquare = nextEvenSquare;
	}

	public void setNextOddSquare(Square nextOddSquare) {
		this.nextOddSquare = nextOddSquare;
	}
	
}
