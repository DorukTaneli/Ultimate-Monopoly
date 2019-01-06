package domainLayer;

import java.io.Serializable;
import java.util.ArrayList;

import domainLayer.bots.Bot;
import domainLayer.cards.Card;
import domainLayer.squares.DeedSquare;
import domainLayer.squares.PropertySquare;
import domainLayer.squares.Square;


import uiLayer.PropertyListener;

// TODO: Auto-generated Javadoc
/**
 * OVERVIEW: The Player class is a class which represents the players of the Monopoly game
 * Each player has a name, money, inventory of properties and cards
 * The player class implements the Publisher interface in order to publish changes in player attributes to the UI layer.
 *
 * @author SAWCON
 */

public class Player implements Publisher,Serializable{

	
	/** The piece. */
	public Piece piece;
	
	/** The name. */
	private String name;
	
	/** The board. */
	private Board board;
	
	/** The cash. */
	private int cash;
	
	/** The have rolled boolean. */
	public boolean haveRolled = false;
	
	/** The cup. */
	public Cup cup;
	
	/** The my properties list. */
	private ArrayList<Square> myProperties= new ArrayList<Square>();
	
	/** The inventory list. */
	private ArrayList<Card> inventory=new ArrayList<Card>();
	
	/** The in jail boolean. */
	public boolean inJail=false;
	
	/** The jail counter. */
	private int jailCounter=0;
	
	public int getJailCounter() {
		return jailCounter;
	}

	/** The layer. */
	private int layer;
	
	/** The index. */
	private int index;
	
	public boolean amIBot=false;
	
	public Bot bot;
	
	/** The my listeners. */
	private ArrayList<PropertyListener> myListeners=new ArrayList<PropertyListener>();

	/**
	 *EFFECTS: Creates an Player object with name, board, cash, cup and piece attributes.
	 *
	 * @param name of the player
	 * @param board
	 */
	public Player(String name, Board board) {
		this.name = name;
		this.board = board;
		this.addCash(1500);
		this.cup=board.getCup();
		piece= new Piece(board.getStartSquare());
		
		
	}
	
	/**
	 * EFFECTS: Gets the number of the layer that the player is currently located in
	 * If the player stands on a square between 0 and 39, returns 1
	 * Else if the player stands on a square between 40 and 63, returns 0
	 * Otherwise, returns 2.
	 * MODIFIES: this
	 *
	 * @return the number of the layer the player is located in
	 */
	public int whichlayer() {
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
	/**
	 * EFFECTS: Takes turn for the current Player object, rolling the dice and moves to the corresponding square
	 * The the player moves to the destination square one square at a time
	 * Performs the checks for jail and rolls the dice accordingly.
	 * MODIFIES: this
	 */
	public void takeTurn() {
		if (!haveRolled) {
			cup.roll();
			int rollTotal = cup.get2RollValue();
			if (inJail) tryToGetOutOfJail();
			
			if(!inJail) {
				System.out.println("*****Player "+this.name+" rolled "+rollTotal+" Dual Roll?: "+cup.isDualRoll());
				moveOneByOneFor(rollTotal);		
			}
			
			
			haveRolled = true;
			if(cup.isDualRoll()) haveRolled=false;
			if(cup.isThirdDualRoll()) {
				haveRolled=true;
				 this.goToJail();
			}
		}
	}
	
	/**
	 * EFFECTS: Gets the haveRolled attribute of this Player object, which represents whether if the current Player has already rolled or not.
	 * @return the haveRolled attribute
	 */
	public boolean haveRolled() {
		return haveRolled;
	}

	/**
	 * EFFECTS: Sets the haveRolled attribute of this Player object to the given boolean.
	 * @param new haveRolled boolean
	 */
	public void setHaveRolled(boolean haveRolled) {
		this.haveRolled = haveRolled;
	}

	/**
	 * EFFECTS: Gets the name.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public void setBotBehaviour(boolean isBot,int c,DomainController ctrl) {
		amIBot=isBot;
		if(isBot) {
			bot= new Bot(this,ctrl);
			bot.selectMode(c);
			System.out.println("****Bot created with "+this.getName()+".****");
		}
		
	}
	
	/**
	 * EFFECTS: Move one by one for f squares.
	 * MODIFIES: this
	 * @param f the amount of squares moved
	 */
	//MOVEMENT
	public void moveOneByOneFor(int f) { 
		
		
		Square currentLoc=piece.getLocation();
		
		//System.out.println("Player "+this.name+" passed on");
		for(int k=0;k<f;k++) {
			//System.out.println("->"+currentLoc.getName()+" ");
			Square nextLoc=currentLoc.getNextSquare(f);
			piece.setLocation(nextLoc);	
			nextLoc.passedOn(this);
			currentLoc=nextLoc;
		}
		
		System.out.println(" and Player "+this.name+" landed on "+currentLoc.getName()+" at Index: ("+currentLoc.getIndex()+")");
		currentLoc.landedOn(this);
		publishPropertyEvent("Location", currentLoc.getName());
		
	}
	
	
	/**
	 * EFFECTS: Teleport to land.
	 * MODIFIES: this
	 * @param square to be teleported to
	 */
	public void teleportToLand(Square sq) {
		piece.setLocation(sq);
		sq.landedOn(this); 
		publishPropertyEvent("Location", sq.getName());
	}
	
	/**
	 * EFFECTS: Teleport without calling the landedOn function.
	 * MODIFIES: this
	 * @param square to be teleported to
	 */
	public void teleportNoLand(Square sq) {
		piece.setLocation(sq);
	}
	
	/**
	 * EFFECTS: Go to jail.
	 * MODIFIES: this
	 */
	public void goToJail() {
		teleportNoLand(board.getSquareByIndex(10));
		this.inJail=true;
		System.out.println("Player "+this.name+" is in jail!");
	}
	
	/**
	 *EFFECTS: Gets out of jail if any of the next three rolls are doubles, pays a fee at the end of 3rd turn 
	 * to get out if none were doubles.
	 * MODIFIES: this
	 */
	public void tryToGetOutOfJail() { //how much cash is taken in 3 rd failed attempt
		
		if(cup.isDualRoll()) inJail=false;
		System.out.println("Player "+this.name+" tried to get out of jail. inJail = "+inJail );
		if(inJail) {
			jailCounter++;
			if(jailCounter>=3) {
				inJail=false;
				jailCounter=0;
				this.reduceCash(100); //??
			}
		}
		
	}

	/**
	 * EFFECTS: Gets the location.
	 * @return the location
	 */
	public Square getLocation() {
		return piece.getLocation();
	}


	/**
	 * EFFECTS: Adds the cash.
	 * MODIFIES: this
	 * @param amount of cash added
	 */
	//CASH
	public void addCash(int amount) {
		System.out.println("Player " +this.name+" gained "+amount+" money!");
		cash += amount;
		publishPropertyEvent("Money", cash+"");
	}

	/**
	 * EFFECTS: Gets the cash.
	 * @return the cash
	 */
	public int getCash() {
		return cash;
	}

	/**
	 * EFFECTS: Reduce cash.
	 * MODIFIES: this
	 * @param amount of cash reduced
	 */
	public void reduceCash(int amount) {
		System.out.println("Player " +this.name+" lost "+amount+" money!");
		cash -= amount;
		publishPropertyEvent("Money", cash+"");
	}

	/**
	 * EFFECTS: Attempt purchase.
	 * MODIFIES: this
	 * @param property square to be purchased
	 */
	public void attemptPurchase (PropertySquare psq) {
		
			boolean success=false;
			if (!psq.isOwned() && cash >= psq.getPrice()){
				reduceCash(psq.getPrice());
				addProperty(psq);
				psq.setOwner(this);
				success=true;
				publishPropertyEvent("Purchase", myProperties);
			}
			
			System.out.println("Purchase attempted,result is: "+success+"");
			if(success) {
				for(Square sq : myProperties) {
					System.out.println("--"+sq.getName());
				}
				System.out.println("Money left: "+this.cash);	
			}
		}

	/**
	 * EFFECTS: Adds the property.
	 * MODIFIES: this
	 * @param square to be added to my properties list
	 */
	public void addProperty(Square sq) {
		if(!myProperties.contains(sq)) myProperties.add(sq);
	}
	
	/**
	 * REQUIRES: myProperties list is initialized
	 * EFFECTS: Removes the property.
	 * MODIFIES: this
	 * @param square to be removed from my properties list
	 */
	public void removeProperty(Square sq) {
		if(myProperties.contains(sq)) myProperties.remove(sq);
	}
	
	/**
	 * EFFECTS: Gets the player properties.
	 * @return my properties list
	 */
	public ArrayList<Square> getPlayerProperties(){
		return myProperties;
	}
	
	/**
	 * REQUIRES: myProperties list is initialized.
	 * EFFECTS: Checks if is my property.
	 * @param square to be checked
	 * @return true, if is in my properties list
	 */
	public boolean isMyProperty(Square sq) {
		return myProperties.contains(sq);
	}
	
	/**
	 * EFFECTS: Adds a card to the players inventory.
	 * MODIFIES: this
	 * @param card to be kept
	 */
	public void keepCard(Card card) {
		inventory.add(card);
	}
	
	/**
	 * EFFECTS: Uses a card's action.
	 * MODIFIES: this
	 * @param card to be used
	 */
	public void useCard(Card card) {
		card.cardAction();
		if(inventory.contains(card)) inventory.remove(card);
	}
	
	/**
	 * EFFECTS: Gets the roll three cards list of player.
	 * @return the roll three cards list
	 */
	public ArrayList<Card> getRollThreeCards(){
		ArrayList<Card> rtcards=new ArrayList<Card>();
		for(int i=0;i<inventory.size();i++) {
			if(inventory.get(i).getType()=="RollThreeCard") {
				rtcards.add(inventory.get(i));
			}
		}
		return rtcards;
	}
	
	/**
	 * EFFECTS: Gets the inventory list of player.
	 * @return the inventory list
	 */
	public ArrayList<Card> getInventory(){
		return inventory;
	}
	
	/**
	 * EFFECTS: Have rolled even boolean. True if roll is even, false otherwise.
	 * @return rolledEven boolean
	 */
	public boolean haveRolledEven(){
		return cup.rolledEven();
	}
	
	/**
	 * EFFECTS: Have rolled even boolean. True if roll is even, false otherwise.
	 * @return rolledOdd boolean
	 */
	public boolean haveRolledOdd(){
		return cup.rolledOdd();
	}
	
	/* (non-Javadoc)
	 * @see domainLayer.Publisher#addPropertyListener(uiLayer.PropertyListener)
	 */
	@Override
	public void addPropertyListener(PropertyListener listener) {
		// TODO Auto-generated method stub
		myListeners.add(listener);
	}

	/* (non-Javadoc)
	 * @see domainLayer.Publisher#removePropertyListener(uiLayer.PropertyListener)
	 */
	@Override
	public void removePropertyListener(PropertyListener listener) {
		// TODO Auto-generated method stub
		if(myListeners.contains(listener)) {
			myListeners.remove(listener);
		}
	}

	/* (non-Javadoc)
	 * @see domainLayer.Publisher#publishPropertyEvent(java.lang.String, java.lang.Object)
	 */
	@Override
	public void publishPropertyEvent(String type, Object value) {
		// TODO Auto-generated method stub
		for(PropertyListener listener:myListeners) {
			listener.onPropertyEvent(this, type, value);
		}

	}
	
	public int ownershipCount(DeedSquare dsq) {
		int ownershipCount=0;
		String dsqColor=dsq.getColor();
		for (Square sq: myProperties) {
			if (sq instanceof DeedSquare) {
				DeedSquare ndsq=(DeedSquare) sq;
				if (ndsq.getColor()==dsqColor) {
					ownershipCount++;
				}
			}
		}
		return ownershipCount;
	}
	
	public boolean hasMajorityOwnership(int ownershipCount, String dsqColor) {
		if(dsqColor=="purple" || dsqColor=="dblue") {
			return ownershipCount==2;
		}
		else if(dsqColor=="lgreen" || dsqColor=="lyellow" || dsqColor=="turqoise" || dsqColor=="maroon" || dsqColor=="mustard" || dsqColor=="salmon") {
			return ownershipCount>3;
		}
		else {
			return ownershipCount>2;
		}
	}
	
	public boolean hasMonopoly(int ownershipCount, String dsqColor) {
		if(dsqColor=="purple" || dsqColor=="dblue") {
			return ownershipCount==2;
		}
		else if(dsqColor=="lgreen" || dsqColor=="lyellow" || dsqColor=="turqoise" || dsqColor=="maroon" || dsqColor=="mustard" || dsqColor=="salmon") {
			return ownershipCount==4;
		}
		else {
			return ownershipCount==3;
		}
	}
	
	public boolean canBuildSkyscraper(String dsqColor, boolean hasMonopoly) {
		boolean hasHotelInAll=true;
		for (Square sq: myProperties) {
			if (sq instanceof DeedSquare) {
				DeedSquare ndsq=(DeedSquare) sq;
				if (ndsq.getColor()==dsqColor) {
					if(ndsq.hasSkyscraper()) {
						return true;
					}
					else if(!ndsq.hasHotel()) {
						return false;
					}
				}
			}
		}
		return hasHotelInAll;
	}

	public void attemptBuild(DeedSquare dsq) {
		// TODO Auto-generated method stub
		boolean success=false;
		int ownershipCount=ownershipCount(dsq);
		if (hasMajorityOwnership(ownershipCount, dsq.getColor()) && cash >= dsq.houseCost()){
			boolean canBuildSky= canBuildSkyscraper(dsq.getColor(), hasMonopoly(ownershipCount, dsq.getColor()));
			dsq.build(this, canBuildSky);
			success=true;
			publishPropertyEvent("Build", myProperties);
		}
		
		System.out.println("Build attempted,result is: "+success+"");
		if(success) {
			System.out.println("House count: "+ dsq.getBuildingNo());
			System.out.println("Money left: "+this.cash);	
		}
	}
}
