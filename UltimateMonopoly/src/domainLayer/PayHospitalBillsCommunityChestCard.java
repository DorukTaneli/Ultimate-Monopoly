package domainLayer;

public class PayHospitalBillsCommunityChestCard extends CommunityChestCard{

	public PayHospitalBillsCommunityChestCard(String name, Boolean keepable) {
		super(name, keepable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cardAction() {
		// TODO Auto-generated method stub
		drawer.reduceCash(100);
		
	}
	

}
