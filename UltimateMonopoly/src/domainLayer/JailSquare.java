package domainLayer;

public class JailSquare extends Square {

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

	@Override
	protected boolean isOwned() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

}
