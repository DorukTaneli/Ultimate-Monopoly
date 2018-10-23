package domainLayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MonopolyGame {
	private static final int ROUNDS_TOTAL = 20;
	private static final int PLAYERS_TOTAL = 2;
	private List players = new ArrayList(PLAYERS_TOTAL);
	private Board board = new Board();
	private Die[] dice = {new Die(), new Die()};
	private int turn = 0;

	public MonopolyGame() {
		Player p;
		p = new Player("Hat", dice, board);
		players.add(p);
		p = new Player("Car", dice, board);
		players.add(p);
	}

	public void playGame() {
		for (int i = 0; i < ROUNDS_TOTAL; i++) {
			playRound();
		}
	}

	public void endTurn() {
		Player p = (Player) players.get(turn);
		p.setHaveRolled(false);
		turn = (turn + 1) % PLAYERS_TOTAL;
	}

	public Player getCurrentPlayer() {
		return (Player) players.get(turn);
	}

	public List getPlayers() {
		return players;
	}

	private void playRound() {
		for (Iterator iter = players.iterator(); iter.hasNext();) {
			Player player = (Player) iter.next();
			player.takeTurn();
		}
	}

	public Board getBoard() {
		return board;
	}
}
