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
	public GoToJailChanceCard() {
		super("Go To Jail Card", false);
		// TODO Auto-generated constructor stub
	}

	/**
	 * EFFECTS: Activates the card, resulting in the drawer of the card to be sent to the jail.
	 * MODIFIES: Player
	 */
	@Override
	public void cardAction() {
		// TODO Auto-generated method stub
		System.out.println(this.getName() + " ACTIVATED ON PLAYER: "+drawer.getName());
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
