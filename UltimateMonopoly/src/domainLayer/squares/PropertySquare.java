package domainLayer.squares;

import domainLayer.Player;

public abstract class PropertySquare extends Square{

	Player owner = null;
	int price;
	int rent;
	
	public PropertySquare(String name, int index, int price,int rent) {
		super(name, index);
		this.rent=rent;
		this.price = price;
		
	}
	
	public boolean isOwned() {
		return owner == null;
	}

	public int getPrice() {
		return price;
	}

	public void setOwner(Player player) {
		this.owner = player;
	}
}
