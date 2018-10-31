package domainLayer;

import uiLayer.Piece;

public class Player {

	private Square location;
	private String name;
	private Board board;
	private Die[] dice;
	private int cash = 1500;
	private boolean haveRolled = false;

	public Player(String name, Die[] dice, Board board) {
		this.name = name;
		this.dice = dice;
		this.board = board;
		location = board.getStartSquare();
	}

	public void takeTurn() {
		if (!haveRolled) {
			int rollTotal = rollDice();

			Square newLoc = board.getSquare(location, rollTotal);
			location = newLoc;
			location.landedOn(this);
			haveRolled = true;
		}
	}

	private int rollDice() {
		//roll dice
		int rollTotal = 0;
		for (int i = 0; i < dice.length; i++) {
			dice[i].roll();
			rollTotal += dice[i].getFaceValue();
		}
		return rollTotal;
	}

	public Square getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	public void addCash(int amount) {
		cash += amount;
	}

	public int getCash() {
		return cash;
	}

	public void reduceCash(int amount) {
		cash -= amount;
	}

	public void attemptPurchase (PropertySquare psq) {
		if (!psq.isOwned()) {
			int pr = psq.getPrice();
			if (cash >= pr) {
				psq.setOwner(this);
				reduceCash(pr);
			}
		}
	}

	public boolean haveRolled() {
		return haveRolled;
	}

	public void setHaveRolled(boolean haveRolled) {
		this.haveRolled = haveRolled;
	}

}
