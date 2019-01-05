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
		owner.addCash(baseRent+ houseNo*houseCost());
		p.reduceCash(baseRent + houseNo*houseCost());
	}
	
	public int houseCost() {
		switch(this.color) {
		case "purple": return 50;
		case "lblue": return 50;
		case "pink": return 100;
		case "orange": return 100;
		case "red": return 150;
		case "yellow": return 150;
		case "green": return 200;
		case "dblue": return 200;
		case "white": return 100;
		case "black": return 200;
		case "gray": return 300;
		case "lbrown": return 50;
		case "lpink": return 50;
		case "lgreen": return 50;
		case "lyellow": return 100;
		case "turqoise": return 100;
		case "maroon": return 150;
		case "mustard": return 200;
		case "salmon": return 250;
		case "dbrown": return 300;
		default: return 50;
		}	
	}

	@Override
	public void build(Player player, boolean canBuildSky) {
		// TODO Auto-generated method stub
		if (this.houseNo<5) {
			player.reduceCash(houseCost());
			this.houseNo++;
		}
		else if (this.houseNo==5 && canBuildSky) {
			player.reduceCash(houseCost());
			this.houseNo++;
		}
	}

	@Override
	public void demolish(Player player, boolean isHurricane) {
		// TODO Auto-generated method stub
		if(!isHurricane) {
			player.addCash(houseCost()/2);
		}
		this.houseNo--;
	}

	@Override
	public void demolishAll(Player player) {
		// TODO Auto-generated method stub
		player.addCash(houseNo*houseCost()/2);
		this.houseNo=0;
		
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
	
	public boolean hasHotel() {
		return this.getBuildingNo()==5;
	}
	
	public boolean hasSkyscraper() {
		return this.getBuildingNo()==6;
	}
}
