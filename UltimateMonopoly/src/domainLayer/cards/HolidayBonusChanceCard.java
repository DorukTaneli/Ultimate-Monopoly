package domainLayer.cards;

public class HolidayBonusChanceCard extends ChanceCard {

	public HolidayBonusChanceCard(String name, Boolean keepable) {
		super(name, keepable);
	}

	@Override
	public void cardAction() {
		drawer.addCash(100);

	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
