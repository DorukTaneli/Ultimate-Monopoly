package domainLayer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import domainLayer.cards.RollThreeCard;
import domainLayer.squares.ChanceSquare;
import domainLayer.squares.CommunityChestSquare;
import domainLayer.squares.DeedSquare;
import domainLayer.squares.GoSquare;
import domainLayer.squares.RegularSquare;
import domainLayer.squares.RollThreeSquare;
import domainLayer.squares.Square;
import domainLayer.squares.TransitSquare;

// TODO: Auto-generated Javadoc
/**
 * The Class Board.
 */
public class Board implements Serializable{
	/**
	 * OVERVIEW: Board is where the game is played. Has three layers.
	 */
	
	/** The size. */
	private static final int SIZE = 120;
	
	/** The squares list. */
	private ArrayList<Square> squares = new ArrayList<Square>(SIZE);
	
	/** The cup. */
	private Cup cup = new Cup();
	
	private SquareFactory sf = new SquareFactory();
	
	private RollThreeCard[] rtcards={(new RollThreeCard("rtcard1",new int[] {1,2,3})),(new RollThreeCard("rtcard2",new int[] {1,2,4}))
			,(new RollThreeCard("rtcard3",new int[] {1,2,5})),(new RollThreeCard("rtcard4",new int[] {1,2,6}))
			,(new RollThreeCard("rtcard5",new int[] {1,3,4})),(new RollThreeCard("rtcard6",new int[] {1,3,5}))
			,(new RollThreeCard("rtcard7",new int[] {1,4,5})),(new RollThreeCard("rtcard8",new int[] {1,4,6}))
			,(new RollThreeCard("rtcard9",new int[] {1,5,6})),(new RollThreeCard("rtcard10",new int[] {2,3,4}))
			,(new RollThreeCard("rtcard11",new int[] {2,4,5})),(new RollThreeCard("rtcard12",new int[] {2,4,6}))
			,(new RollThreeCard("rtcard13",new int[] {2,5,6})),(new RollThreeCard("rtcard14",new int[] {3,4,5}))
			,(new RollThreeCard("rtcard15",new int[] {3,4,6})),(new RollThreeCard("rtcard16",new int[] {3,5,6}))
			,(new RollThreeCard("rtcard17",new int[] {4,5,6})),(new RollThreeCard("rtcard18",new int[] {2,4,6}))
			,(new RollThreeCard("rtcard19",new int[] {2,5,6})),(new RollThreeCard("rtcard20",new int[] {3,4,5}))
			,(new RollThreeCard("rtcard121",new int[] {3,4,6})),(new RollThreeCard("rtcard22",new int[] {3,5,6}))
			,(new RollThreeCard("rtcard123",new int[] {4,5,6})),(new RollThreeCard("rtcard24",new int[] {1,3,6}))};
	private ArrayList<RollThreeCard> rtdeck=new ArrayList<RollThreeCard>();
	
	
	/**
	 * EFFECTS: Instantiates a new board by building and linking squares.
	 */
	public Board() {
		buildSquares();
		linkSquares();
		setUpTransitSquares();
		initializeRollThreeDeck();
		
	}
	
	/**
	 * EFFECTS: Sets up the transit squares and their brothers.
	 */
	public void setUpTransitSquares() {
		if(squares.get(15).getType().equals("TransitSquare")) {
			TransitSquare ts = (TransitSquare) squares.get(15);
			ts.setBrothers((TransitSquare)squares.get(49));
		}
		if(squares.get(25).getType().equals("TransitSquare")) {
			TransitSquare ts = (TransitSquare) squares.get(25);
			ts.setBrothers((TransitSquare)squares.get(99));
		}
		if(squares.get(35).getType().equals("TransitSquare")) {
			TransitSquare ts = (TransitSquare) squares.get(35);
			ts.setBrothers((TransitSquare)squares.get(61));
		}
		if(squares.get(5).getType().equals("TransitSquare")) {
			TransitSquare ts = (TransitSquare) squares.get(5);
			ts.setBrothers((TransitSquare)squares.get(71));
		}
		
		
	}
	
	/**
	 * EFFECTS: Gets the cup.
	 *
	 * @return the cup
	 */
	public Cup getCup() {
		return cup;
	}
	
	/**
	 * EFFECTS: Gets the squares list.
	 *
	 * @return the squares list
	 */
	public ArrayList<Square> getSquaresList() {
		return squares;
	}
	
	/**
	 * EFFECTS: Gets the square that is a given distance away as index from a starting square.
	 *
	 * @param starting square
	 * @param distance between the indexes of squares as integer
	 * @return targeted square
	 */
	public Square getSquare(Square start, int distance) {
		int endIndex = (start.getIndex() + distance) % SIZE;
		return (Square) squares.get(endIndex);
	}
	
	/**
	 * EFFECTS: Gets the square with a given index.
	 *
	 * @param index of the targeted square
	 * @return the square with the given index
	 */
	public Square getSquareByIndex(int index) {
		return (Square)squares.get(index);
	}
	
	/**
	 * EFFECTS: Gets the start square.
	 *
	 * @return the start square
	 */
	public Square getStartSquare() {
		return (Square) squares.get(0);
	}
	
	/**
	 * MODIFIES: squares
	 * EFFECTS: Builds the Go square and adds it to the squares list.
	 * 			Calls separate square creating methods to create each square on the board.
	 */
	public void buildSquares() {
//		Square sq = new GoSquare("Go Square", 0);
		Square sq = sf.getSquare("Go", "Go Square", 0, 0, 0, null);
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
	
	public ArrayList<RollThreeCard> getRTDeck(){
		return rtdeck;
	}
	
	public void initializeRollThreeDeck() {
		for(int i=0;i<rtcards.length;i++) {
			rtdeck.add(rtcards[i]);
		}
	}
	
	
	/**
	 * MODIFIES: squares
	 * EFFECTS: Builds a property square with the given parameters and adds it to the squares list.
	 *
	 * @param name of the square
	 * @param index of the square
	 * @param price of the property related to that square
	 * @param rent of the property related to that square
	 * @param color group of the property related to that square
	 */
	public void buildPS(String name, int ind, int pr, int rent, String color) {
		Square s = sf.getSquare("PS", name, ind, pr, rent, color);
		squares.add(s);
	}
	
	/**
	 * MODIFIES: squares
	 * EFFECTS: Builds a regular square with the given parameters and adds it to the squares list.
	 *
	 * @param name of the square
	 * @param index of the square
	 */
	public void buildRS(String name, int ind) {
		Square s = sf.getSquare("RS", name, ind, 0, 0, null);
		squares.add(s);
	}
	

	/**
	 * MODIFIES: squares
	 * EFFECTS: Builds a Roll Three square with the given parameters and adds it to the squares list.
	 *
	 * @param name of the square
	 * @param index of the square
	 */
	public void buildRTS(String name, int ind) {
		Square s = sf.getSquare("RTS", name, ind, 0, 0, null);
		squares.add(s);
		}

	/**
	 * MODIFIES: squares
	 * EFFECTS: Builds a transit square with the given parameters and adds it to the squares list.
	 *
	 * @param name of the square
	 * @param index of the square
	 * @param price of the transit property related to that square
	 */
	public void buildTransit(String name,int ind,int pr) {
		Square s = sf.getSquare("Transit", name, ind, pr, 25, null);
		squares.add(s);
		
	}
	
	/**
	 * MODIFIES: squares
	 * EFFECTS: Builds a chance square with the given parameters and adds it to the squares list.
	 *
	 * @param name of the square
	 * @param index of the square
	 */
	public void buildChance(String name, int index) {
		Square s = sf.getSquare("Chance", name, index, 0, 0, null);
		squares.add(s);
	}
	
	/**
	 * MODIFIES: squares
	 * EFFECTS: Builds a community chest square with the given parameters and adds it to the squares list.
	 *
	 * @param name of the square
	 * @param index of the square
	 */
	public void buildCCS(String name, int index) { //COMMUNUTY CHEST SQUARE
		Square s = sf.getSquare("CCS", name, index, 0, 0, null);
		squares.add(s);
	}
	
	/**
	 * EFFECTS: Links squares.
	 */
	public void linkSquares() {
		for (int i = 0; i < (SIZE - 1); i++) {
			link(i);
		}
		
		squares.get(39).setNextSquare(squares.get(0));
		squares.get(63).setNextSquare(squares.get(40));
		squares.get(119).setNextSquare(squares.get(64));
		
	}
	
	/**
	 * EFFECTS: Links two squares according to their indexes in the squares list.
	 *
	 * @param index of the squares list
	 */
	public void link(int i) {
		Square current = (Square) squares.get(i);
		Square next = (Square) squares.get(i + 1);
		current.setNextSquare(next);
		//System.out.println(current.getName()+" linked to "+next.getName()+" at index "+current.getIndex()+" -> "+next.getIndex());
	}
}
