package domainLayer;

public abstract class Card {
	
	private String name;
	private String description;
	private boolean keepable;
	
	public Card(String name,Boolean keepable) {
		this.name=name;
		this.keepable=keepable;
	}
	
	public abstract void cardAction();
	
	
	
}
