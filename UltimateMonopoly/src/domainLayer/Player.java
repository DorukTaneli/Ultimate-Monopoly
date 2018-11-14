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
	private int jailCounter=0;
	private int layer;

	public Player(String name, Board board) {
		this.name = name;
		this.board = board;
		this.cup=board.getCup();
		piece= new Piece(board.getStartSquare());
	}
	
	private int whichlayer() {
		if(piece.getLocation().getIndex()<40) {
			layer=1;
			
		}else if(piece.getLocation().getIndex()<64) {
			layer=0;
		}else {
			layer=2;
		}
		return layer;
	}

	//TURN
	public void takeTurn() {
		if (!haveRolled) {
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
		
		System.out.println("Player "+this.name+" passed on");
		for(int k=0;k<f;k++) {
			Square nextLoc=currentLoc.getNextSquare(f);
			piece.setLocation(nextLoc);
			nextLoc.passedOn(this);
			System.out.println(" "+currentLoc.getName()+", ");
			currentLoc=nextLoc;
			
			
		}

		currentLoc.landedOn(this);
		System.out.println(" and Player "+this.name+" landed on "+currentLoc.getName()+" at Index: ("+currentLoc.getIndex()+")");
		
		
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
	
	public void tryToGetOutOfJail() { //how much cash is taken in 3 rd failed attempt
		
		if(cup.isDualRoll()) inJail=false;
		System.out.print("Player "+this.name+" tried to get out of jail. inJail = "+inJail );
		if(inJail) {
			jailCounter++;
			if(jailCounter>=3) {
				inJail=false;
				jailCounter=0;
				this.reduceCash(100);
			}
		}
		
	}

	public Square getLocation() {
		return piece.getLocation();
	}


	//CASH
	public void addCash(int amount) {
		System.out.println("Player " +this.name+" gained "+amount+" money!");
		cash += amount;
	}

	public int getCash() {
		return cash;
	}

	public void reduceCash(int amount) {
		System.out.println("Player " +this.name+" lost "+amount+" money!");
		cash -= amount;
	}

	public void attemptPurchase (PropertySquare psq) {
		
			boolean success=false;
			if (!psq.isOwned() && cash >= psq.getPrice()){
				reduceCash(psq.getPrice());
				addProperty(psq);
				psq.setOwner(this);
				success=true;
				
			}
			
			System.out.println("Purchase attempted,result is: "+success+". Properties of player "+this.name+ " are:");
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
