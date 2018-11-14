package domainLayer;

public class TransitSquare extends PropertySquare{

	private int secondIndex;
	private Square nextEvenSquare;
	private Square nextOddSquare;
	
	public TransitSquare(String name, int index, int price) {
		super(name, index,price);
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

	
	public void setNextEvenSquare(Square nextEvenSquare) {
		this.nextEvenSquare = nextEvenSquare;
	}

	public void setNextOddSquare(Square nextOddSquare) {
		this.nextOddSquare = nextOddSquare;
	}
	
}
