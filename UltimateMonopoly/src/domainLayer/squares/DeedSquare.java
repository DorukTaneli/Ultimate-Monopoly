package domainLayer.squares;

import domainLayer.Player;

public class DeedSquare extends PropertySquare{
	
	private int baseRent;
	private String color;

	public DeedSquare(String name, int index, int price, int rent, String color) {
		super(name, index, price,rent);
		this.price = price;
		this.baseRent = rent;
		this.color = color;
		setType("PropertySquare");
	}

	@Override
	public void landedOn(Player p) {
		if (owner != null && owner != p)
			payRent(p);
	}
	
	public void passedOn(Player p) {
	
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getColor() {
		return color;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public boolean isOwned() {
		return owner != null;
	}
	
	public void payRent(Player p) {
		owner.addCash(baseRent);
		p.reduceCash(baseRent);
	}

}
