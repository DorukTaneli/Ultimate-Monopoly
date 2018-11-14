package domainLayer.squares;

import java.util.ArrayList;
import java.util.List;

import domainLayer.Buildable;
import domainLayer.Player;

public class DeedSquare extends PropertySquare implements Buildable{
	
	private int baseRent;
	private String color;
	private int houseNo;

	public DeedSquare(String name, int index, int price, int rent, String color) {
		super(name, index, price, rent);
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

	@Override
	public void build() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBuildingNo(int buildingNo) {
		// TODO Auto-generated method stub
		this.houseNo=buildingNo;
	}

	@Override
	public int getBuildingNo() {
		// TODO Auto-generated method stub
		return this.houseNo;
	}

	@Override
	public void demolish() {
		// TODO Auto-generated method stub
		this.houseNo--;
	}

	@Override
	public void demolishAll() {
		// TODO Auto-generated method stub
		this.houseNo=0;
	}

}
