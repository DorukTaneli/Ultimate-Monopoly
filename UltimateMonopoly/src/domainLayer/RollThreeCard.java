package domainLayer;


public class RollThreeCard extends Card{
	public int[] numbers;
	 
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
		for(int i=0;i<numbers.length;i++) {
			for(int j=0;j<x.length;j++) {
				if(numbers[i]==x[j])c++;
			}
		}
		if(no1==no2)c--;
		if(no3==no2)c--;
		if(no1==no3)c--;
		if(no1==no2 && no2==no3)c++;
			
		
		
		int prize;
		switch(c){
		case 1:
			prize=50;
			break;
		case 2: 
			prize=200;
			break;
		case 3: 
			prize=1500;
			break;
		default:
			prize=0;
			break;
		}
		return prize;
	}
	

}
