package domainLayer.cards;

import java.io.Serializable;

import domainLayer.Player;

public abstract class Card  implements Serializable{
	
	private String name;
	private String description;
	private boolean keepable;
	public Player drawer = null;
	
	public Card(String name,Boolean keepable) {
		this.name=name;
		this.keepable=keepable;
	}
	
	public abstract void cardAction();

	public Player getDrawer() {
		return drawer;
	}

	public void setDrawer(Player drawer) {
		this.drawer = drawer;
	}

	public boolean isKeepable() {
		return keepable;
	}

	public void setKeepable(boolean keepable) {
		this.keepable = keepable;
	}

	public abstract String getType();

	public String getName() {
		return name;
	}
}
