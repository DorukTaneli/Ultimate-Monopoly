package domainLayer.squares;

import domainLayer.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class TransitSquare.
 */
public class TransitSquare extends PropertySquare{
	/**
	 * OVERVIEW: Transit squares are squares that allow a player to change their layer. 
	 */

	/** The brother. */
	private TransitSquare brother;
	
	/** The base rent. */
	private int baseRent;
	
	/**
	 * EFFECTS: Instantiates a new transit square.
	 *
	 * @param name of square
	 * @param index of square
	 * @param price of square
	 * @param rent of square
	 */
	public TransitSquare(String name, int index, int price,int rent) {
		super(name, index,price,rent);
		setType("TransitSquare");
		baseRent=rent;
		// TODO Auto-generated constructor stub
		
		
	}
	
	/* (non-Javadoc)
	 * @see domainLayer.squares.Square#getNextSquare(int)
	 */
	public Square getNextSquare(int f) {
		if(f%2==0) {
			System.out.println("Transit Station is working!\n Player rolled: "+f+" which is even"
					+ "\n Sending him to my brothers next square!");
			return brother.getNextSquareFromSuper(f);
		}else {
			System.out.println("Transit Station is working!\n Player rolled: "+f+" which is odd"
					+ "\n Sending him to my own next square!");
			return this.getNextSquareFromSuper(f);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see domainLayer.squares.PropertySquare#setOwner(domainLayer.Player)
	 */
	public void setOwner(Player p) {
		this.setSuperOwner(p);
		brother.setSuperOwner(p);
		
	}
	
	/**
	 * MODIFIES: this
	 * EFFECTS: Sets the super's owner.
	 *
	 * @param player who is owner
	 */
	private void setSuperOwner(Player p) {
		super.setOwner(p);
	}

	/* (non-Javadoc)
	 * @see domainLayer.squares.Square#landedOn(domainLayer.Player)
	 */
	@Override
	public void landedOn(Player p) {
		if (owner != null && owner != p)
			payRent(p);
		
	}
	
	/**
	 * EFFECTS: Pays rent by reducing the player's cash and adding the same amount to the owner of the transit square.
	 *
	 * @param player who pays the rent
	 */
	public void payRent(Player p) {
		owner.addCash(baseRent);
		p.reduceCash(baseRent);
	}

	/* (non-Javadoc)
	 * @see domainLayer.squares.Square#passedOn(domainLayer.Player)
	 */
	public void passedOn(Player p) {
		
	}

	/**
	 * EFFECTS: Gets the square after a given distance from super.
	 *
	 * @param distance from super
	 * @return the square after the given distance from super
	 */
	public Square getNextSquareFromSuper(int f) {
		return super.getNextSquare(f);
	}

	/**
	 * EFFECTS: Gets the brother of the transit square.
	 *
	 * @return the brother
	 */
	public TransitSquare getBrother() {
		return brother;
	}

	/**
	 * MODIFIES: this.
	 * EFFECTS: Sets the brother of the transit square.
	 *
	 * @param brother square
	 */
	public void setBrother(TransitSquare brother) {
		this.brother = brother;
	}
	
	/**
	 * MODIFIES: this and brother
	 * EFFECTS: Sets the brother of the transit square and than sets this square as the brother's brother.
	 *
	 * @param brother square
	 */
	public void setBrothers(TransitSquare brother) {
		this.brother = brother;
		brother.setBrother(this);
	}
}
