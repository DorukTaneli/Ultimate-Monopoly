package domainLayer.cards;

public class PayHospitalBillsCommunityChestCard extends CommunityChestCard{

	public PayHospitalBillsCommunityChestCard() {
		super("PayHospitalBillsCommunityChestCard", false);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cardAction() {
		// TODO Auto-generated method stub
		System.out.println("PAY HOSPITAL BILLS COMMUNITY CHEST CARD ACTIVATED ON PLAYER: "+drawer.getName());

		drawer.reduceCash(100);
		
	}
	
	public String getType() {
		return null;
	}
}
