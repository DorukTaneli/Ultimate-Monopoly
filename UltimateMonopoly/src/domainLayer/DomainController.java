package domainLayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import domainLayer.squares.PropertySquare;
import domainLayer.squares.Square;
import uiLayer.AppWindow; //THIS SHOULDNT BE HERE ************ DOING THIS TO SEE THE PIECES MOVE
import uiLayer.PropertyListener;

public class DomainController {
	private static final int PLAYERS_TOTAL = 2;
	private ArrayList<Player> players = new ArrayList<Player>(PLAYERS_TOTAL);
	private Board board = new Board();
	private Cup cup; //might not be needed in DC, might be needed in order to save the game.
	private int turn = 0;
	private AppWindow app;

	public DomainController(AppWindow app) {
		Player p;
		this.app=app;
		p = new Player("Hat", board);
		players.add(p);
		p = new Player("Car", board);
		players.add(p);
		this.cup=board.getCup();
		
		for(Player player: players) {
				player.addPropertyListener(app);
		}
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

	public List<Player> getPlayers() {
		return players;
	}

	public Player getPlayerLocationIndex(int a) {
		return players.get(a);
	}

	public Board getBoard() {
		return board;
	}

	public void rollPressed() {
		Player nextPlayer = getCurrentPlayer();
		nextPlayer.takeTurn();
		app.updatePieceGUILocation();
	}

	public void buyPressed() {
		Player p = getCurrentPlayer();
		Square sq = p.getLocation();
		if(sq instanceof PropertySquare)
			p.attemptPurchase((PropertySquare)p.getLocation());
	}

	public void buildPressed() {

	}

	public void endTurnPressed() {
		Player p = getCurrentPlayer();
		if(p.haveRolled()) {
			p.setHaveRolled(false);
			turn = (turn + 1) % PLAYERS_TOTAL;
		}

	}
}

