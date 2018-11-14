package domainLayer.cards;

public class PayHospitalBillsCommunityChestCard extends CommunityChestCard{

	public PayHospitalBillsCommunityChestCard(String name, Boolean keepable) {
		super(name, keepable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cardAction() {
		// TODO Auto-generated method stub
		System.out.println("PAY HOSPITAL BILLS COMMUNITY CHEST CARD ACTIVATED ON PLAYER: "+drawer.getName());

		drawer.reduceCash(100);
		
	}
	

}
