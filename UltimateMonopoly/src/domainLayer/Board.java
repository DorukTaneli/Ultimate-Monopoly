package domainLayer;
import java.util.ArrayList;
import java.util.List;

public class Board {
	buil
	private static final int SIZE = 40;
	private List squares = new ArrayList(SIZE);
	
	public Board() {
		buildSquares();
		linkSquares();
	}
	
	public Square getSquare(Square start, int distance) {
		int endIndex = (start.getIndex() + distance) % SIZE;
		return (Square) squares.get(endIndex);
	}
	
	public Square getStartSquare() {
		return (Square) squares.get(0);
	}
	
	private void buildSquares() {
		Square sq = new GoSquare("Go Square", 0);
		squares.add(sq);
		buildPS("Mediterranean Avenue", 1, 60, 6);
		buildRS("Community Chest", 2);
		buildPS("Baltic Avenue", 3, 60, 6);
		buildRS("Income Tax", 4);
		buildRS("Transit Station", 5);
		buildPS("Oriental Avenue", 6, 100, 10);
		buildRS("Chance", 7);
		buildPS("Vermont Avenue", 8, 100, 10);
		buildPS("Connecticut Avenue", 9, 120, 12);
		buildRS("Jail", 10);
		buildPS("St. Charles Place", 11, 140, 14);
		buildRS("Electric Company", 12);
		buildPS("States Avenue", 13, 140, 14);
		buildPS("Virginia Avenue", 14, 160, 16);
		buildRS("Pennysylvania Railroad", 15);
		buildPS("St. James Place", 16, 180, 18);
		buildRS("Community Chest", 17);
		buildPS("Tennessee Avenue", 18, 180, 18);
		buildPS("New York Avenue", 19, 200, 20);
		buildRS("Free Parking", 20);
		buildPS("Kentucky Avenue", 21, 220, 22);
		buildRS("Chance", 22);
		buildPS("Indiana Avenue", 23, 220, 22);
		buildPS("Illinois Avenue", 24, 240, 24);
		buildRS("Transit Station", 25);
		buildPS("Atlantic Avenue", 26, 260, 26);
		buildPS("Ventnor Avenue", 27, 260, 24);
		buildRS("Water Works", 28);
		buildPS("Marvin Gardens", 29, 280, 24);
		buildRS("Go to Jail", 30);
		buildPS("Pacific Avenue", 31, 300, 24);
		buildPS("North Carolina Avenue", 32, 300, 24);
		buildRS("Community Chest", 33);
		buildPS("Pennysylvania Avenue", 34, 320, 24);
		buildRS("Short Line", 35);
		buildRS("Chance", 36);
		buildPS("Park Place", 37, 350, 24);
		buildRS("Luxury Tax", 38);
		buildPS("Board Walk", 39, 350, 24);
	}
	
	private void buildPS(String name, int ind, int pr, int rent) {
		Square s = new PropertySquare(name, ind, pr, rent);
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
	}
}
