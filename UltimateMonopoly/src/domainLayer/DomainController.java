package domainLayer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


import domainLayer.squares.DeedSquare;

import domainLayer.cards.RollThreeCard;
import domainLayer.squares.PropertySquare;
import domainLayer.squares.Square;
import uiLayer.AppWindow; //THIS SHOULDNT BE HERE ************ DOING THIS TO SEE THE PIECES MOVE
import uiLayer.PropertyListener;


/**
 * Domain Controller class is the controller of the Domain.
 * Utilizes Controller Pattern. Delegates Messages from UI to relevant classes in the Domain.
 * @author SAWCON
 */

public final class DomainController implements Serializable{
	public static DomainController instance = null;
	
	public int PLAYERS_TOTAL;
	public int BOTS_NUM_TOTAL;
	private ArrayList<Player> players = new ArrayList<Player>(PLAYERS_TOTAL);
	private Board board = new Board();
	private Cup cup; //might not be needed in DC, might be needed in order to save the game.
	private int turn = 0;
	public boolean playersAreSet=false;
	private SaveLoad saver;
	
	/**
	 * Creates Domain Controller Object.
	 * Initializes Appwindow, Players, Cup, and PropertyListeners
	 * @param Appwindow Object to be set 
	 */
	
	public DomainController(int pNum, int bNum) {
		instance=this;
		Player p;
		saver = new SaveLoad(1);
		PLAYERS_TOTAL = pNum;
		BOTS_NUM_TOTAL = bNum;
		System.out.println("Num of players: "+PLAYERS_TOTAL);
		players = new ArrayList<Player>();
		for(int i=0;i<PLAYERS_TOTAL;i++) {
			p = new Player("Player"+i, board);
			players.add(p);
			Random rand = new Random();
			int botMode = rand.nextInt(3);
			
			if(i>=PLAYERS_TOTAL-BOTS_NUM_TOTAL) p.setBotBehaviour(true , botMode, this);
		}
		
		
		
		distributeRTCards();
		playersAreSet=true;
	}
	
	public void addPropertyListeners(AppWindow apw) {
		for(Player player: players) {
			player.addPropertyListener(apw);
	}
	}
	/**
	 * Returns the singleton instance of Domain Controller
	 * @return the singleton instance of Domain Controller
	 */
	public static DomainController getInstance() {
		return instance;
		
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
	public ArrayList<RollThreeCard> getRollThreeDeck(){
		return board.getRTDeck();
	}
	
	public void distributeRTCards() {
		for(int i=0;i<players.size();i++) {
			int len=board.getRTDeck().size();
			int a=(int) Math.floor((Math.random() * len));
			players.get(i).keepCard(board.getRTDeck().get(a));
		}
	}

	/**
	 * Gets the current PLayer
	 * @return the current Player
	 */
	public Player getCurrentPlayer() {
		return (Player) players.get(turn);
	}
	
	/**
	 * Gets the Players List
	 * @return the Players List
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * Gets the Location Index of the Player with given index
	 * @param Index of player
	 * @return LocationIndex of Player
	 */
	public Player getPlayerLocationIndex(int a) {
		return players.get(a);
	}

	/**
	 * Gets the Board
	 * @return the Board
	 */
	public Board getBoard() {
		return board;
	}
	
	public void publishPlayers() {	
		for(Player player: players) {
			player.publishPropertyEvent("Money", player.getCash()+"");
			player.publishPropertyEvent("Purchase", player.getPlayerProperties());
	}
	}

	/**
	 * Passes takeTurn message to the current Player
	 * Updates UI location of player's piece
	 */
	public void rollPressed(AppWindow apw) {
		Player currentPlayer = getCurrentPlayer();
		currentPlayer.takeTurn();
		//TODO make the following observer pattern
		apw.updatePieceGUILocation();
	}

	/**
	 * If the location of the current player is a PropertySquare,
	 * The player attempts to purchase that square.
	 */
	public void buyPressed() {
		Player p = getCurrentPlayer();
		Square sq = p.getLocation();
		if(sq instanceof PropertySquare)
			p.attemptPurchase((PropertySquare)sq);
	}

	public void buildPressed() {

		System.out.println("Build attempted by "+getCurrentPlayer().getName());

		Player p= getCurrentPlayer();
		Square sq=p.getLocation();
		if(sq instanceof DeedSquare) {
			p.attemptBuild((DeedSquare)sq);
		}

	}

	/**
	 * If the player has rolled,
	 * his turn ends and it is the next player's turn.
	 */
	public void endTurnPressed() {

		Player p = getCurrentPlayer();
		System.out.println("End Turn attempted by "+p.getName());
		if(p.haveRolled()) {
			p.setHaveRolled(false);
			System.out.println("There are "+PLAYERS_TOTAL+" players.");
			turn = (turn + 1) % PLAYERS_TOTAL;
			System.out.print(p.getName()+" ended their turn. ");
			p=getCurrentPlayer();
			System.out.print("It is now the turn of "+p.getName()+". isBot?:"+p.amIBot+"\n");
			
			if(p.amIBot && getCurrentPlayer().getName().equals(p.getName())) p.bot.manageTurn();;
		}

	}
	
	public void savePressed() {
		saver.save(this);
	}
}

