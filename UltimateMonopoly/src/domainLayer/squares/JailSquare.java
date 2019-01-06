package domainLayer.squares;

import java.io.Serializable;

import domainLayer.Player;

public class JailSquare extends Square  implements Serializable{

	public JailSquare(String name, int index) {
		super(name, index);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn(Player p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void passedOn(Player p) {
		// TODO Auto-generated method stub

	}
}
