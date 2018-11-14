package domainLayer.cards;


public class RollThreeCard extends Card{
	private int[] numbers;
	 
	public RollThreeCard(String name, int[] numbers) {
		super(name,true);
		this.numbers=numbers;
		
	}

	@Override
	public void cardAction() {
		// TODO Auto-generated method stub
		
	}
	
	public int getReward(int no1,int no2,int no3,boolean pTurn) {
		int[] x= {no1,no2,no3};
		int c=0;
		if(pTurn==true)c++;
		for(int i=0;i<numbers.length;i++) {
			for(int j=0;j<x.length;j++) {
				if(numbers[i]==x[j])c++;
			}
		}
		int prize;
		switch(c){
		case 1:
			prize=50;
		case 2: 
			prize=200;			
		case 3: 
			prize=1000;
		case 4:
			prize=1500;
		default:
			prize=0;
		}
		return prize;
	}
	

}
