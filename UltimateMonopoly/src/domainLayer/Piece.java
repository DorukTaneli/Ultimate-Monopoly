package domainLayer;

import java.io.Serializable;

import domainLayer.squares.Square;

public class Piece  implements Serializable{

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
