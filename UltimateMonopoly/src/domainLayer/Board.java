package domainLayer;
import java.util.ArrayList;
import java.util.List;

public class Board {
	private static final int SIZE = 120;
	private ArrayList<Square> squares = new ArrayList<Square>(SIZE);
	private Cup cup = new Cup();
	
	public Board() {
		buildSquares();
		linkSquares();
		setUpTransitSquares();
		
	}
	
	private void setUpTransitSquares() {
		if(squares.get(15).type.equals("TransitSquare")) {
			TransitSquare ts = (TransitSquare) squares.get(15);
			ts.setBrothers((TransitSquare)squares.get(49));
		}
		if(squares.get(25).type.equals("TransitSquare")) {
			TransitSquare ts = (TransitSquare) squares.get(25);
			ts.setBrothers((TransitSquare)squares.get(99));
		}
		if(squares.get(35).type.equals("TransitSquare")) {
			TransitSquare ts = (TransitSquare) squares.get(35);
			ts.setBrothers((TransitSquare)squares.get(61));
		}
		if(squares.get(5).type.equals("TransitSquare")) {
			TransitSquare ts = (TransitSquare) squares.get(5);
			ts.setBrothers((TransitSquare)squares.get(71));
		}
		
		
	}
	
	public Cup getCup() {
		return cup;
	}
	
	public ArrayList<Square> getSquaresList() {
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
		buildCCS("Community Chest", 2);
		buildPS("Baltic Avenue", 3, 60, 4, "purple");
		buildRS("Income Tax", 4);
		buildTransit("Transit Station", 5, 200);
		buildPS("Oriental Avenue", 6, 100, 6, "lblue");
		buildChance("Chance", 7);
		buildPS("Vermont Avenue", 8, 100, 6, "lblue");
		buildPS("Connecticut Avenue", 9, 120, 8, "lblue");
		buildRS("Jail", 10);
		buildPS("St. Charles Place", 11, 140, 10, "pink");
		buildRS("Electric Company", 12);
		buildPS("States Avenue", 13, 140, 10, "pink");
		buildPS("Virginia Avenue", 14, 160, 12 ,"pink");
		buildTransit("Pennysylvania Railroad", 15,200);
		buildPS("St. James Place", 16, 180, 14, "orange");
		buildCCS("Community Chest", 17);
		buildPS("Tennessee Avenue", 18, 180, 14, "orange");
		buildPS("New York Avenue", 19, 200, 16, "orange");
		buildRS("Free Parking", 20);
		buildPS("Kentucky Avenue", 21, 220, 18, "red");
		buildChance("Chance", 22);
		buildPS("Indiana Avenue", 23, 220, 18, "red");
		buildPS("Illinois Avenue", 24, 240, 20, "red");
		buildTransit("Transit Station", 25,200);
		buildPS("Atlantic Avenue", 26, 260, 22, "yellow");
		buildPS("Ventnor Avenue", 27, 260, 22, "yellow");
		buildRS("Water Works", 28);
		buildPS("Marvin Gardens", 29, 280, 24, "yellow");
		buildRS("Go to Jail", 30);
		buildPS("Pacific Avenue", 31, 300, 26, "green");
		buildPS("North Carolina Avenue", 32, 300, 26, "green");
		buildCCS("Community Chest", 33);
		buildPS("Pennysylvania Avenue", 34, 320, 28, "green");
		buildTransit("Short Line", 35,200);
		buildChance("Chance", 36);
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
		buildTransit("Transit Station", 49,200);
		buildPS("Fifth Avenue", 50, 430, 60, "gray");
		buildPS("Madison Avenue", 51, 430, 60, "gray");
		buildRTS("Roll Three Square", 52);
		buildPS("Wall Street", 53, 500, 80, "gray");
		buildRS("Tax Refund", 54);
		buildRS("Gas Company", 55);
		buildChance("Chance", 56);
		buildPS("Florida Avenue", 57, 130, 9, "lbrown");
		buildRS("Holland Tunnel", 58);
		buildPS("Miami Avenue", 59, 130, 9 ,"lbrown");
		buildPS("Biscayne Avenue", 60, 150, 11, "lbrown");
		buildTransit("Transit Station", 61,200);
		buildRS("Reverse Direction", 62);
		buildPS("Lombard Street", 63, 210, 17, "white");
		buildRS("Subway", 64); //is actually stock exchange on board
		buildPS("Lake Street", 65, 30, 1, "lpink");
		buildCCS("Community Chest", 66);
		buildPS("Nicollet Avenue", 67, 30, 1, "lpink");
		buildPS("Hennepin Avenue", 68, 60, 3, "lpink");
		buildRS("Bus Ticket", 69);
		buildRS("Checker Cab Co.", 70);
		buildTransit("Reading Railroad", 71,200);
		buildPS("Esplanade Avenue", 72, 90, 5, "lgreen");
		buildPS("Canal Street", 73, 90, 5, "lgreen");
		buildChance("Chance", 74);
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
		buildChance("Chance", 85);
		buildRS("Black & White Cab Co.", 86);
		buildPS("Dekalb Avenue", 87, 210, 17, "turqoise");
		buildCCS("Community Chest", 88);
		buildPS("Andrew Young Int'l Boulevard", 89, 210, 17, "turqoise");
		buildPS("Decatur Street", 90, 240, 20, "turqoise");
		buildPS("Peachtree Street", 91, 240, 20, "turqoise");
		buildRS("Pay Day", 92);
		buildPS("Randolph Street", 93, 270, 23, "maroon");
		buildChance("Chance", 94);
		buildPS("Lake Shore Drive", 95, 270, 23, "maroon");
		buildPS("Wacher Drive", 96, 300, 26, "maroon");
		buildPS("Michigan Avenue", 97, 300, 26, "maroon");
		buildRS("Yellow Cab Co.", 98);
		buildTransit("B&O Railroad", 99,200);
		buildCCS("Community Chest", 100);
		buildPS("South Temple", 101, 330, 32, "mustard");
		buildPS("West Temple", 102, 330, 32 ,"mustard");
		buildRS("Trash Collector", 103);
		buildPS("North Temple", 104, 360, 38, "mustard");
		buildPS("Temple Square", 105, 360, 38, "mustard");
		buildRS("Subway", 106); //NEEDS TO BE SUBWAY
		buildPS("South Street", 107, 390, 45, "salmon");
		buildPS("Broad Street", 108, 390, 45, "salmon");
		buildPS("Wallnut Street", 109, 420, 55, "salmon");
		buildCCS("Community Chest", 110);
		buildPS("Market Street", 111, 420, 55, "salmon");
		buildRS("Bus Ticket", 112);
		buildRS("Sewage System", 113);
		buildRS("UTE Cab Co.", 114);
		buildRS("Birthday Gift", 115);
		buildPS("Mulholland Drive", 116, 450, 70, "dbrown");
		buildPS("Ventura Boulevard", 117, 480, 80, "dbrown");
		buildChance("Chance", 118);
		buildPS("Rodeo Drive", 119, 480, 90, "dbrown");
	}
	
	
	
	private void buildPS(String name, int ind, int pr, int rent, String color) {
		Square s = new DeedSquare(name, ind, pr, rent, color);
		squares.add(s);
	}
	
	private void buildRS(String name, int ind) {
		Square s = new RegularSquare(name, ind);
		squares.add(s);
	}
	
//<<<<<<< HEAD
	private void buildRTS(String name, int ind) {
		Square s = new RollThreeSquare(name, ind);}
//=======
	private void buildTransit(String name,int ind,int pr) {
		Square s = new TransitSquare(name,ind,pr,25);
		squares.add(s);
		
	}
	
	private void buildChance(String name, int index) {
		Square s = new ChanceSquare(name,index);
		squares.add(s);
	}
	
	private void buildCCS(String name, int index) { //COMMUNUTY CHEST SQUARE
		Square s = new CommunityChestSquare(name,index);
//>>>>>>> refs/remotes/origin/master
		squares.add(s);
	}
	
	private void linkSquares() {
		for (int i = 0; i < (SIZE - 1); i++) {
			link(i);
		}
		
		Square first = getStartSquare();
		Square last = (Square) squares.get(SIZE-1);
		last.setNextSquare(first);
		squares.get(63).setNextSquare(squares.get(40));
		squares.get(119).setNextSquare(squares.get(64));
		
	}
	
	private void link(int i) {
		Square current = (Square) squares.get(i);
		Square next = (Square) squares.get(i + 1);
		current.setNextSquare(next);
		//System.out.println(current.getName()+" linked to "+next.getName()+" at index "+current.getIndex()+" -> "+next.getIndex());
	}
}
