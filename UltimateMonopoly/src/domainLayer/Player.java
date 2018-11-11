package domainLayer;

public class Player {

	private Piece piece;
	private String name;
	private Board board;
	private int cash = 1500;
	private boolean haveRolled = false;
	private Cup cup;
	
	private boolean inJail=false;

	public Player(String name, Board board) {
		this.name = name;
		this.board = board;
		this.cup=board.getCup();
		piece= new Piece(board.getStartSquare());
	}

	public void takeTurn() {
		while (!haveRolled) {
			cup.roll();
			int rollTotal = cup.get2RollValue();
			if (inJail) tryToGetOutOfJail();
			
			if(!inJail) {
				System.out.println("Player "+this.name+" rolled "+rollTotal+" Dual Roll?: "+cup.isDualRoll());
				moveOneByOneFor(rollTotal);
				
				
			}
			
			
			
			haveRolled = true;
			if(cup.isDualRoll()) haveRolled=false;
			if(cup.isThirdDualRoll()) {
				haveRolled=true;
				
				 //10 is jail
			}
		}
	}
	
	public void moveOneByOneFor(int f) { //going to need to change this for transit stations
		
		
		Square currentLoc=piece.getLocation();
		
		for(int k=0;k<f;k++) {
			Square nextLoc=currentLoc.getNextSquare();
			piece.setLocation(nextLoc);
			nextLoc.passedOn(this);
			System.out.println("Player "+this.name+" moved from "+currentLoc.getName()+" to "+nextLoc.getName());
			currentLoc=nextLoc;
			
		}

		currentLoc.landedOn(this);
		System.out.println("Player "+this.name+" landed on "+currentLoc.getName());
		
		
	}
	
	
	public void teleportToLand(Square sq) {
		piece.setLocation(sq);
		sq.landedOn(this); //will landed on work on teleports?
	}
	
	public void teleportNoLand(Square sq) {
		piece.setLocation(sq);
	}
	
	public void goToJail() {
		teleportNoLand(board.getSquareByIndex(10));
		this.inJail=true;
		System.out.println("Player "+this.name+" is in jail!");
	}
	
	public void tryToGetOutOfJail() {
		
		if(cup.isDualRoll()) inJail=false;
		System.out.print("Player "+this.name+" tried to get out of jail. inJail = "+inJail );
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
