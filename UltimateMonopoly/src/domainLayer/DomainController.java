package domainLayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DomainController {
	private static final int PLAYERS_TOTAL = 2;
	private List players = new ArrayList(PLAYERS_TOTAL);
	private Board board = new Board();
	private Die[] dice = {new Die(), new Die()};
	private int turn = 0;

	public DomainController() {
		Player p;
		p = new Player("Hat", dice, board);
		players.add(p);
		p = new Player("Car", dice, board);
		players.add(p);
	}

//	public void playGame() {
//		for (int i = 0; i < ROUNDS_TOTAL; i++) {
//			playRound();
//		}
//	}
	
//	private void playRound() {
//	for (Iterator iter = players.iterator(); iter.hasNext();) {
//		Player player = (Player) iter.next();
//		player.takeTurn();
//	}
//}

	public Player getCurrentPlayer() {
		return (Player) players.get(turn);
	}
	
	public Player getLastPlayer() {
		return (Player) players.get((turn - 1 + PLAYERS_TOTAL) % PLAYERS_TOTAL);
	}

	public List getPlayers() {
		return players;
	}

	public Board getBoard() {
		return board;
	}
	
	public void rollPressed() {
		Player nextPlayer = getCurrentPlayer();
		nextPlayer.takeTurn();
	}
	
	public void buyPressed() {
		Player nextPlayer = getCurrentPlayer();
		nextPlayer.attemptPurchase((PropertySquare)nextPlayer.getLocation());
	}
	
	public void buildPressed() {
		
	}
	
	public void endTurnPressed() {
		Player p = (Player) players.get(turn);
		p.setHaveRolled(false);
		turn = (turn + 1) % PLAYERS_TOTAL;
	}
}
