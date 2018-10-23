package domainLayer;
import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private static final int SIZE = 20;
	private List squares = new ArrayList(SIZE);
	
	public Board() {
		buildSquares();
		linkSquares();
	}
	
	public Square getSquare(Square start, int distance) {
		int startInd = start.getIndex();
		int endIndex = (startInd + distance) % SIZE;
//		int endIndex = (start.getIndex() + distance) % SIZE;
		return (Square) squares.get(endIndex);
	}
	
	public Square getStartSquare() {
		return (Square) squares.get(0);
	}
	
	private void buildSquares() {
		Square sq = new GoSquare("Go Square", 0);
		squares.add(sq);
		buildPS("Oriental Ave", 1, 100, 6);
		buildRS("Free Parking 1", 2);
		buildPS("Vermont Ave", 3, 100, 6);
		buildPS("Connecticut Ave", 4, 125, 8);
		buildRS("Roll once", 5);
		buildPS("St. Charles Place", 6, 140, 10);
		buildRS("Bonus", 7);
		buildPS("States Ave", 8, 140, 10);
		buildPS("Virginia Ave", 9, 160, 12);
		buildRS("Free Parking 2", 10);
		buildPS("St. James Place", 11, 180, 14);
		buildRS("Koc Meydani", 12);
		buildPS("Tennesse Ave", 13, 180, 14);
		buildPS("New York Ave", 14, 200, 16);
		buildRS("Squeeze Play", 15);
		buildPS("Pacific Ave", 16, 300, 26);
		buildPS("North Carolina Ave", 17, 300, 26);
		buildRS("Reverse Direction", 18);
		buildPS("Pennsylvania Ave", 19, 320, 28);
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
