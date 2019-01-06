package domainLayer.cards;

public class HolidayBonusChanceCard extends ChanceCard {

	public HolidayBonusChanceCard() {
		super("HolidayBonusChanceCard", false);
	}

	@Override
	public void cardAction() {
		System.out.println(this.getName() + " ACTIVATED ON PLAYER: "+drawer.getName());
		
		drawer.addCash(100);

	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
