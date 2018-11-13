package domainLayer;
import java.util.ArrayList;
import java.util.List;

public class Board {
	private static final int SIZE = 40;
	private List squares = new ArrayList(SIZE);
	private Cup cup = new Cup();
	
	public Board() {
		buildSquares();
		linkSquares();
		
	}
	
	public Cup getCup() {
		return cup;
	}
	
	public List getSquaresList() {
		return squares;
	}
	
	public Square getSquare(Square start, int distance) {
		int endIndex = (start.getIndex() + distance) % SIZE;
		return (Square) squares.get(endIndex);
	}
	
	public Square getSquareByIndex(int index) {
		return (Square)squares.get(index);
	}
	
	public Square getStartSquare() {
		return (Square) squares.get(0);
	}
	
	private void buildSquares() {
		Square sq = new GoSquare("Go Square", 0);
		squares.add(sq);
		buildPS("Mediterranean Avenue", 1, 60, 2, "purple");
		buildRS("Community Chest", 2);
		buildPS("Baltic Avenue", 3, 60, 4, "purple");
		buildRS("Income Tax", 4);
		buildRS("Transit Station", 5);
		buildPS("Oriental Avenue", 6, 100, 6, "lblue");
		buildRS("Chance", 7);
		buildPS("Vermont Avenue", 8, 100, 6, "lblue");
		buildPS("Connecticut Avenue", 9, 120, 8, "lblue");
		buildRS("Jail", 10);
		buildPS("St. Charles Place", 11, 140, 10, "pink");
		buildRS("Electric Company", 12);
		buildPS("States Avenue", 13, 140, 10, "pink");
		buildPS("Virginia Avenue", 14, 160, 12 ,"pink");
		buildRS("Pennysylvania Railroad", 15);
		buildPS("St. James Place", 16, 180, 14, "orange");
		buildRS("Community Chest", 17);
		buildPS("Tennessee Avenue", 18, 180, 14, "orange");
		buildPS("New York Avenue", 19, 200, 16, "orange");
		buildRS("Free Parking", 20);
		buildPS("Kentucky Avenue", 21, 220, 18, "red");
		buildRS("Chance", 22);
		buildPS("Indiana Avenue", 23, 220, 18, "red");
		buildPS("Illinois Avenue", 24, 240, 20, "red");
		buildRS("Transit Station", 25);
		buildPS("Atlantic Avenue", 26, 260, 22, "yellow");
		buildPS("Ventnor Avenue", 27, 260, 22, "yellow");
		buildRS("Water Works", 28);
		buildPS("Marvin Gardens", 29, 280, 24, "yellow");
		buildRS("Go to Jail", 30);
		buildPS("Pacific Avenue", 31, 300, 26, "green");
		buildPS("North Carolina Avenue", 32, 300, 26, "green");
		buildRS("Community Chest", 33);
		buildPS("Pennysylvania Avenue", 34, 320, 28, "green");
		buildRS("Short Line", 35);
		buildRS("Chance", 36);
		buildPS("Park Place", 37, 350, 35, "dblue");
		buildRS("Luxury Tax", 38);
		buildPS("Board Walk", 39, 400, 50, "dblue");
		buildRS("Squeeze Play", 40);
		buildPS("The Embarcadero", 41, 210, 17, "white");
		buildPS("Fisherman's Wharf", 42, 250, 21, "white");
		buildRS("Telephone Company", 43);
		buildRS("Community Chest", 44);
		buildPS("Beacon Street", 45, 330, 30, "black");
		buildRS("Bonus", 46);
		buildPS("Boylston Street", 47, 330, 30, "black");
		buildPS("Newbury Street", 48, 380, 40, "black");
		buildRS("Transit Station", 49);
		buildPS("Fifth Avenue", 50, 430, 60, "gray");
		buildPS("Madison Avenue", 51, 430, 60, "gray");
		buildRS("Stock Exchange", 52);
		buildPS("Wall Street", 53, 500, 80, "gray");
		buildRS("Tax Refund", 54);
		buildRS("Gas Company", 55);
		buildRS("Chance", 56);
		buildPS("Florida Avenue", 57, 130, 9, "lbrown");
		buildRS("Holland Tunnel", 58);
		buildPS("Miami Avenue", 59, 130, 9 ,"lbrown");
		buildPS("Biscayne Avenue", 60, 150, 11, "lbrown");
		buildRS("Transit Station", 61);
		buildRS("Reverse Direction", 62);
		buildPS("Lombard Street", 63, 210, 17, "white");
		buildRS("Subway", 64);
		buildPS("Lake Street", 65, 30, 1, "lpink");
		buildRS("Community Chest", 66);
		buildPS("Nicollet Avenue", 67, 30, 1, "lpink");
		buildPS("Hennepin Avenue", 68, 60, 3, "lpink");
		buildRS("Bus Ticket", 69);
		buildRS("Checker Cab Co.", 70);
		buildRS("Reading Railroad", 71);
		buildPS("Esplanade Avenue", 72, 90, 5, "lgreen");
		buildPS("Canal Street", 73, 90, 5, "lgreen");
		buildRS("Chance", 74);
		buildRS("Cable Company", 75);
		buildPS("Magazine Street", 76, 120, 8, "lgreen");
		buildPS("Bourbon Street", 77, 120, 8, "lgreen");
		buildRS("Holland Tunnel", 78);
		buildRS("Auction", 79);
		buildPS("Katy Freeway", 80, 150, 11, "lyellow");
		buildPS("Westheimer Road", 81, 150, 11, "lyellow");
		buildRS("Internet Service Provider", 82);
		buildPS("Kirby Drive", 83, 180, 14, "lyellow");
		buildPS("Cullen Boulevard", 84, 180, 14, "lyellow");
		buildRS("Chance", 85);
		buildRS("Black & White Cab Co.", 86);
		buildPS("Dekalb Avenue", 87, 210, 17, "turqoise");
		buildRS("Community Chest", 88);
		buildPS("Andrew Young Int'l Boulevard", 89, 210, 17, "turqoise");
		buildPS("Decatur Street", 90, 240, 20, "turqoise");
		buildPS("Peachtree Street", 91, 240, 20, "turqoise");
		buildRS("Pay Day", 92);
		buildPS("Randolph Street", 93, 270, 23, "maroon");
		buildRS("Chance", 94);
		buildPS("Lake Shore Drive", 95, 270, 23, "maroon");
		buildPS("Wacher Drive", 96, 300, 26, "maroon");
		buildPS("Michigan Avenue", 97, 300, 26, "maroon");
		buildRS("Yellow Cab Co.", 98);
		buildRS("B&O Railroad", 99);
		buildRS("Community Chest", 100);
		buildPS("South Temple", 101, 330, 32, "mustard");
		buildPS("West Temple", 102, 330, 32 ,"mustard");
		buildRS("Trash Collector", 103);
		buildPS("North Temple", 104, 360, 38, "mustard");
		buildPS("Temple Square", 105, 360, 38, "mustard");
		buildRS("Go to Jail", 106);
		buildPS("South Street", 107, 390, 45, "salmon");
		buildPS("Broad Street", 108, 390, 45, "salmon");
		buildPS("Wallnut Street", 109, 420, 55, "salmon");
		buildRS("Community Chest", 110);
		buildPS("Market Street", 111, 420, 55, "salmon");
		buildRS("Bus Ticket", 112);
		buildRS("Sewage System", 113);
		buildRS("UTE Cab Co.", 114);
		buildRS("Birthday Gift", 115);
		buildPS("Mulholland Drive", 116, 450, 70, "dbrown");
		buildPS("Ventura Boulevard", 117, 480, 80, "dbrown");
		buildRS("Chance", 118);
		buildPS("Rodeo Drive", 119, 480, 90, "dbrown");
	}
	
	
	
	private void buildPS(String name, int ind, int pr, int rent, String color) {
		Square s = new PropertySquare(name, ind, pr, rent, color);
		squares.add(s);
	}
	
	private void buildRS(String name, int ind) {
		Square s = new RegularSquare(name, ind);
		squares.add(s);
	}
	
	private void linkSquares() {
		for (int i = 0; i < (SIZE - 1); i++) {
			link(i);
		}
		
		Square first = getStartSquare();
		Square last = (Square) squares.get(SIZE-1);
		last.setNextSquare(first);
	}
	
	private void link(int i) {
		Square current = (Square) squares.get(i);
		Square next = (Square) squares.get(i + 1);
		current.setNextSquare(next);
		//System.out.println(current.getName()+" linked to "+next.getName()+" at index "+current.getIndex()+" -> "+next.getIndex());
	}
}
