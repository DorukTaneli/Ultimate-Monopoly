package domainLayer.cards;

/**
 * OVERVIEW: GoToJailChanceCard is a class that extends ChanceCards
 * @author SAWCON
 *
 */
public class GoToJailChanceCard extends ChanceCard{

	/**
	 * EFFECTS: Creates a GoToJailChanceCard object
	 * @param the name of the card
	 * @param boolean keepable
	 */
	public GoToJailChanceCard(String name, Boolean keepable) {
		super(name, keepable);
		// TODO Auto-generated constructor stub
	}

	/**
	 * EFFECTS: Activates the card, resulting in the drawer of the card to be sent to the jail.
	 * MODIFIES: Player
	 */
	@Override
	public void cardAction() {
		// TODO Auto-generated method stub
		System.out.println("GO TO JAIL CHANCE CARD ACTIVATED ON PLAYER: "+drawer.getName());
		drawer.goToJail();
	}

	/**
	 * EFFECTS: Gets the type of the object.
	 * @return type of the object
	 */
	@Override
	public String getType() {
		return null;
	}
	
	

}
