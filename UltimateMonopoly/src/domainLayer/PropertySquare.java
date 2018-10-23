package domainLayer;

public class PropertySquare extends Square{
	
	private int price;
	private Player owner = null;
	private int rent;

	public PropertySquare(String name, int index, int price, int rent) {
		super(name, index);
		this.price = price;
		this.rent = rent;
	}

	@Override
	public void landedOn(Player p) {
		if (owner != null && owner != p)
			payRent(p);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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
		owner.addCash(rent);
		p.reduceCash(rent);
	}

}
