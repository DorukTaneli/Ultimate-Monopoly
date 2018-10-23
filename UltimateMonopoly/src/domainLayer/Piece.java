package domainLayer;
import javax.swing.JLabel;

public class Piece {
	
	public static final int BARHEIGHT = 0;
	public static final int HALFSQ = 56;

	private int offset;
	private JLabel lbl;
	private Player player;

	public Piece(JLabel lbl, Player p, int offset) {
		this.lbl = lbl;
		this.player = p;
		this.offset = offset;
	}
	
	public void setGUILocation() {
		Square sq = player.getLocation();
		lbl.setLocation(getPixelx(sq) + offset - 25, getPixely(sq) - 25);
	}

	public JLabel getJLabel() {
		return lbl;
	}

	public void setJLabel(JLabel lbl) {
		this.lbl = lbl;
	}

	public int getPixelx(Square sq) {
		int ind = sq.getIndex();
		switch (ind) {
		case 0: case 19: case 18:
		case 17: case 16: case 15:
			return HALFSQ*11;
		case 5: case 6: case 7:
		case 8: case 9: case 10:
			return HALFSQ*1;
		case 4: case 11:
			return HALFSQ*3;
		case 3: case 12:
			return HALFSQ*5;
		case 2: case 13:
			return HALFSQ*7;
		case 1: case 14:
			return HALFSQ*9;
		default:
			return HALFSQ*6;
		}
	}

	public int getPixely(Square sq) {
		int ind = sq.getIndex();
		switch (ind) {
		case 0: case 1: case 2:
		case 3: case 4: case 5:
			return BARHEIGHT + 11*HALFSQ;
		case 10: case 11: case 12:
		case 13: case 14: case 15:
			return BARHEIGHT + HALFSQ;
		case 9: case 16:
			return BARHEIGHT + HALFSQ*3;
		case 8: case 17:
			return BARHEIGHT + HALFSQ*5;
		case 7: case 18:
			return BARHEIGHT + HALFSQ*7;
		case 6: case 19:
			return BARHEIGHT + HALFSQ*9;
		default:
			return BARHEIGHT + HALFSQ*6;
		}
	}

}