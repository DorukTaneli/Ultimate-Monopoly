package domainLayer;

import domainLayer.squares.ChanceSquare;
import domainLayer.squares.CommunityChestSquare;
import domainLayer.squares.DeedSquare;
import domainLayer.squares.GoSquare;
import domainLayer.squares.RegularSquare;
import domainLayer.squares.RollThreeSquare;
import domainLayer.squares.Square;
import domainLayer.squares.TransitSquare;

public class SquareFactory {

	public static Square getSquare(String type, String name, int index, int price, int rent, String color) {

		if("Go".equalsIgnoreCase(type)) return new GoSquare(name, 0);
		else if("PS".equalsIgnoreCase(type)) return new DeedSquare(name, index, price, rent, color);
		else if("RS".equalsIgnoreCase(type)) return new RegularSquare(name, index);
		else if("RTS".equalsIgnoreCase(type)) return new RollThreeSquare(name, index);
		else if("Transit".equalsIgnoreCase(type)) return new TransitSquare(name,index,price,rent);
		else if("Chance".equalsIgnoreCase(type)) return new ChanceSquare(name,index);
		else if("CCS".equalsIgnoreCase(type)) return new CommunityChestSquare(name,index);

		return null;
	}
}
