package domainLayer;

public class Piece {

	private Square location;
	
	public Piece(Square sq) {
		this.location = sq;
	}

	public Square getLocation() {
		return location;
	}

	public void setLocation(Square location) {
		this.location = location;
	}

}
