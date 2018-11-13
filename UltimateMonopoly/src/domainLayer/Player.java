package domainLayer;

import java.util.ArrayList;

public class Player {

	public Piece piece;
	private String name;
	private Board board;
	private int cash = 1500;
	private boolean haveRolled = false;
	private Cup cup;
	private ArrayList<Square> myProperties= new ArrayList<Square>();
	
	private boolean inJail=false;

	public Player(String name, Board board) {
		this.name = name;
		this.board = board;
		this.cup=board.getCup();
		piece= new Piece(board.getStartSquare());
	}

	//TURN
	public void takeTurn() {
		while (!haveRolled) {
			cup.roll();
			int rollTotal = cup.get2RollValue();
			if (inJail) tryToGetOutOfJail();
			
			if(!inJail) {
				System.out.println("**Player "+this.name+" rolled "+rollTotal+" Dual Roll?: "+cup.isDualRoll());
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
	
	public boolean haveRolled() {
		return haveRolled;
	}

	public void setHaveRolled(boolean haveRolled) {
		this.haveRolled = haveRolled;
	}

	public String getName() {
		return name;
	}

	
	
	//MOVEMENT
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
		System.out.println("Player "+this.name+" landed on "+currentLoc.getName()+" at Index: ("+currentLoc.getIndex()+")");
		
		
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


	//CASH
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
		
			if (!psq.isOwned() && cash >= psq.getPrice()){
				reduceCash(psq.getPrice());
				addProperty(psq);
				psq.setOwner(this);
				
			}
			
			System.out.println("Purchase attempted. Properties of player "+this.name+ " are:");
			for(Square sq : myProperties) {
				System.out.println("--"+sq.getName());
			}
			System.out.println("Money left: "+this.cash);
			
		}

	public void addProperty(Square sq) {
		if(!myProperties.contains(sq)) myProperties.add(sq);
	}
	
	public void removeProperty(Square sq) {
		if(myProperties.contains(sq)) myProperties.remove(sq);
		
	}
	
	public ArrayList<Square> getPlayerProperties(){
		return myProperties;
	}
	
	public boolean isMyProperty(Square sq) {
		return myProperties.contains(sq);
	}
}
