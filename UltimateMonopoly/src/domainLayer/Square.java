package domainLayer;

public abstract class Square {
	
	private String name;
	private Square nextSquare;
	private int index;
	protected String type;
	
	public Square(String name, int index) {
		this.name = name;
		this.index = index;
	}
	
	public void setNextSquare (Square s) {
		nextSquare = s;
	}
	
	public Square getNextSquare(int f) {
		return nextSquare;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean equals(Square sq2) {
		if(this.name.equals(sq2.name)) return true;
		else return false;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	abstract public void landedOn(Player p);
	abstract public void passedOn(Player p);

	protected abstract boolean isOwned();

	protected abstract int getPrice();
}
