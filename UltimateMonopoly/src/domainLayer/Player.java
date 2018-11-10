package domainLayer;

public class Player {

	private Piece piece;
	private String name;
	private Board board;
	private int cash = 1500;
	private boolean haveRolled = false;
	private Cup cup;

	public Player(String name, Board board) {
		this.name = name;
		this.board = board;
		this.cup=board.getCup();
		piece= new Piece(board.getStartSquare());
	}

	public void takeTurn() {
		if (!haveRolled) {
			cup.roll();
			int rollTotal = cup.get2RollValue();
			Square newLoc = board.getSquare(piece.getLocation(), rollTotal);
			piece.setLocation(newLoc);
			piece.getLocation().landedOn(this);
			haveRolled = true;
			if(cup.isDualRoll()) haveRolled=false;
		}
	}
	
	public void move(Square sq) {
		piece.setLocation(sq);
		
		sq.landedOn(this);
	}
	
	public void passSquare(int movesLeft) {
		
		
	}

	public Square getLocation() {
		return piece.getLocation();
	}

	public String getName() {
		return name;
	}

	public void addCash(int amount) {
		cash += amount;
	}

	public int getCash() {
		return cash;
	}

	public void reduceCash(int amount) {
		cash -= amount;
	}

	public void attemptPurchase (PropertySquare psq) {
		if (!psq.isOwned()) {
			int pr = psq.getPrice();
			if (cash >= pr) {
				psq.setOwner(this);
				reduceCash(pr);
			}
		}
	}

	public boolean haveRolled() {
		return haveRolled;
	}

	public void setHaveRolled(boolean haveRolled) {
		this.haveRolled = haveRolled;
	}

}
