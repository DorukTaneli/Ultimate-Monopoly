package domainLayer;

public abstract class PropertySquare extends Square{

	Player owner = null;
	int price;
	
	public PropertySquare(String name, int index, int price,int rent) {
		super(name, index);
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
