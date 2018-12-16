package domainLayer.cards;

/**
 * GoToJailChanceCard is a class that extends ChanceCards
 * @author SAWCON
 *
 */
public class GoToJailChanceCard extends ChanceCard{

	/**
	 * Creates a GoToJailChanceCard object
	 * @param the name of the card
	 * @param boolean keepable
	 */
	public GoToJailChanceCard(String name, Boolean keepable) {
		super(name, keepable);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Activates the card, resulting in the drawer of the card to be sent to the jail.
	 */
	@Override
	public void cardAction() {
		// TODO Auto-generated method stub
		System.out.println("GO TO JAIL CHANCE CARD ACTIVATED ON PLAYER: "+drawer.getName());
		drawer.goToJail();
	}

	/**
	 * Gets the type of the object.
	 * @return type of the object
	 */
	@Override
	public String getType() {
		return null;
	}
	
	

}
